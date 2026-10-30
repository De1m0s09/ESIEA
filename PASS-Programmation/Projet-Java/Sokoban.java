import java.util.Scanner;

public class Sokoban {
    private static final Scanner SC = new Scanner(System.in);

    // Les niveaux utilisent : # mur, espace case libre, . objectif,
    // @ joueur, + joueur sur objectif, $ caisse, * caisse sur objectif.
    private static final String[][] NIVEAUX = {
        {
            "########",
            "#      #",
            "#  .   #",
            "#  $   #",
            "#  @   #",
            "#      #",
            "########"
        },
        {
            "##########",
            "#        #",
            "#  . .   #",
            "#  $$    #",
            "#   @    #",
            "#        #",
            "##########"
        },
        {
            "##########",
            "#        #",
            "# .      #",
            "# $  ##  #",
            "#   @    #",
            "#      . #",
            "#      $ #",
            "##########"
        }
    };

    private char[][] grille;
    private int joueurLigne;
    private int joueurColonne;
    private int mouvements;
    private int niveauActuel;

    public static void main(String[] args) {
        new Sokoban().menuPrincipal();
    }

    private void menuPrincipal() {
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n========== SOKOBAN JAVA ==========");
            System.out.println("1. Nouvelle partie");
            System.out.println("2. Choisir un niveau");
            System.out.println("3. Afficher les règles");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            String choix = SC.nextLine().trim();

            switch (choix) {
                case "1":
                    choisirNiveau();
                    jouer();
                    break;
                case "2":
                    choisirNiveau();
                    break;
                case "3":
                    afficherRegles();
                    break;
                case "4":
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Recommencez.");
            }
        }
    }

    private void choisirNiveau() {
        System.out.println("\n--- Choix du niveau ---");
        for (int i = 0; i < NIVEAUX.length; i++) {
            System.out.println((i + 1) + ". Niveau " + (i + 1));
        }
        System.out.print("Votre choix : ");

        int choix = lireEntier(1, NIVEAUX.length);
        chargerNiveau(choix - 1);
    }

    private int lireEntier(int minimum, int maximum) {
        while (true) {
            String saisie = SC.nextLine().trim();
            try {
                int valeur = Integer.parseInt(saisie);
                if (valeur >= minimum && valeur <= maximum) {
                    return valeur;
                }
            } catch (NumberFormatException ignored) {
                // La saisie sera redemandée.
            }
            System.out.print("Entrez un nombre entre " + minimum + " et " + maximum + " : ");
        }
    }

    private void chargerNiveau(int numero) {
        niveauActuel = numero;
        String[] lignes = NIVEAUX[numero];
        int hauteur = lignes.length;
        int largeur = 0;

        for (String ligne : lignes) {
            largeur = Math.max(largeur, ligne.length());
        }

        grille = new char[hauteur][largeur];
        mouvements = 0;
        boolean joueurTrouve = false;

        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                char c = j < lignes[i].length() ? lignes[i].charAt(j) : ' ';
                grille[i][j] = c;

                if (c == '@' || c == '+') {
                    joueurLigne = i;
                    joueurColonne = j;
                    joueurTrouve = true;
                }
            }
        }

        if (!joueurTrouve) {
            throw new IllegalStateException("Le niveau ne contient pas de joueur.");
        }
    }

    private void afficherGrille() {
        System.out.println("\nNiveau " + (niveauActuel + 1)
                + " | Mouvements : " + mouvements);
        for (char[] ligne : grille) {
            System.out.println(new String(ligne));
        }
        System.out.println("Commandes : Z haut, S bas, Q gauche, D droite, X quitter");
    }

    private void jouer() {
        boolean partieEnCours = true;

        while (partieEnCours) {
            afficherGrille();

            if (partieTerminee()) {
                System.out.println("\nVICTOIRE !");
                System.out.println("Nombre de mouvements : " + mouvements);
                return;
            }

            System.out.print("Votre commande : ");
            String saisie = SC.nextLine().trim().toLowerCase();

            if (saisie.isEmpty()) {
                System.out.println("Commande invalide.");
                continue;
            }

            char commande = saisie.charAt(0);
            if (commande == 'x') {
                partieEnCours = false;
            } else if (commande == 'z' || commande == 's'
                    || commande == 'q' || commande == 'd') {
                deplacerJoueur(commande);
            } else {
                System.out.println("Commande invalide.");
            }
        }
    }

    private void deplacerJoueur(char direction) {
        int deltaLigne = 0;
        int deltaColonne = 0;

        switch (direction) {
            case 'z': deltaLigne = -1; break;
            case 's': deltaLigne = 1; break;
            case 'q': deltaColonne = -1; break;
            case 'd': deltaColonne = 1; break;
            default: return;
        }

        int nouvelleLigne = joueurLigne + deltaLigne;
        int nouvelleColonne = joueurColonne + deltaColonne;

        if (!dansGrille(nouvelleLigne, nouvelleColonne)) {
            System.out.println("Déplacement impossible : limite de la grille.");
            return;
        }

        char cible = grille[nouvelleLigne][nouvelleColonne];

        if (cible == '#') {
            System.out.println("Déplacement impossible : un mur bloque le passage.");
            return;
        }

        if (cible == '$' || cible == '*') {
            if (!peutPousser(nouvelleLigne, nouvelleColonne,
                    deltaLigne, deltaColonne)) {
                System.out.println("Impossible de pousser la caisse.");
                return;
            }
            deplacerCaisse(nouvelleLigne, nouvelleColonne,
                    nouvelleLigne + deltaLigne, nouvelleColonne + deltaColonne);
        } else if (cible != ' ' && cible != '.') {
            System.out.println("Déplacement impossible.");
            return;
        }

        // Libérer l'ancienne position du joueur en conservant l'objectif éventuel.
        grille[joueurLigne][joueurColonne] =
                grille[joueurLigne][joueurColonne] == '+' ? '.' : ' ';

        // Le joueur arrive sur une case libre ou sur un objectif.
        grille[nouvelleLigne][nouvelleColonne] =
                (cible == '.' || cible == '*') ? '+' : '@';

        joueurLigne = nouvelleLigne;
        joueurColonne = nouvelleColonne;
        mouvements++;
    }

    private boolean peutPousser(int caisseLigne, int caisseColonne,
                                int deltaLigne, int deltaColonne) {
        int destinationLigne = caisseLigne + deltaLigne;
        int destinationColonne = caisseColonne + deltaColonne;

        if (!dansGrille(destinationLigne, destinationColonne)) {
            return false;
        }

        char destination = grille[destinationLigne][destinationColonne];
        return destination == ' ' || destination == '.';
    }

    private void deplacerCaisse(int ancienneLigne, int ancienneColonne,
                                int nouvelleLigne, int nouvelleColonne) {
        boolean ancienneCaseEstObjectif = grille[ancienneLigne][ancienneColonne] == '*';
        boolean nouvelleCaseEstObjectif = grille[nouvelleLigne][nouvelleColonne] == '.';

        grille[nouvelleLigne][nouvelleColonne] =
                nouvelleCaseEstObjectif ? '*' : '$';

        // La case de départ de la caisse sera occupée par le joueur.
        // Son objectif éventuel sera représenté par '+'.
        grille[ancienneLigne][ancienneColonne] =
                ancienneCaseEstObjectif ? '.' : ' ';
    }

    private boolean deplacementValide(int ligne, int colonne) {
        return dansGrille(ligne, colonne) && grille[ligne][colonne] != '#';
    }

    private boolean dansGrille(int ligne, int colonne) {
        return ligne >= 0 && ligne < grille.length
                && colonne >= 0 && colonne < grille[ligne].length;
    }

    private boolean partieTerminee() {
        for (char[] ligne : grille) {
            for (char c : ligne) {
                if (c == '$') {
                    return false;
                }
            }
        }
        return true;
    }

    private void afficherRegles() {
        System.out.println("\n--- REGLES DU SOKOBAN ---");
        System.out.println("Le but est de placer toutes les caisses sur les objectifs.");
        System.out.println("Z : haut | S : bas | Q : gauche | D : droite | X : quitter");
        System.out.println("Vous pouvez pousser une caisse, mais pas la tirer.");
        System.out.println("Une caisse ne peut pas être poussée contre un mur ou une autre caisse.");
        System.out.println("# = mur, @ = joueur, $ = caisse, . = objectif, * = caisse sur objectif.");
    }
}
