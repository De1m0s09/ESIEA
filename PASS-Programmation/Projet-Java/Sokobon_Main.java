import java.util.Scanner;

class Sokobon_Main {

    int choix_niveau = 0;
    int joueur_ligne = 0;
    int joueur_colonne = 0;
    int position_joueur = 0;

    static char[] niveau_actuel;

    public static void main(String[] args) {

        Sokobon_Main jeu = new Sokobon_Main();

        // Affichage menu et sélection
        int niveau = MenuSelect();

        switch (niveau) {
            case 1:
                jeu.niveau1();
                break;
            case 2:
                jeu.niveau2();
                break;
            case 3:
                jeu.niveau3();
                break;
            case 4:
                System.out.println("Merci d'avoir joué à Sokoban !");
                break;
            case 5:
                System.out.println("Merci d'avoir joué à Sokoban !");
                break;
        }
    }

    public static int MenuSelect() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Sokoban ========");
        System.out.println("1. Niveau 1");
        System.out.println("2. Niveau 2");
        System.out.println("3. Niveau 3");
        System.out.println("4. Règles du jeu");
        System.out.println("5. Quitter");
        System.out.println("Votre choix:");

        int choix = sc.nextInt();

        switch (choix) {
            case 1:
                System.out.println("Vous avez choisi le niveau " + choix);
                break;
            case 2:
                System.out.println("Vous avez choisi le niveau " + choix);
                break;
            case 3:
                System.out.println("Vous avez choisi le niveau " + choix);
                break;
            case 4:
                System.out.println("Règles du jeu :");
                System.out.println("Le but du jeu est de pousser toutes les caisses sur les objectifs.");
                System.out.println("Vous pouvez déplacer le joueur avec les touches z (haut), s (bas), d (droite) et q (gauche).");
                System.out.println("Vous pouvez recommencer le niveau avec la touche r.");
                System.out.println("Vous pouvez retourner au menu avec la touche x.");
                System.out.println("Vous pouvez quitter le jeu avec la touche q.");
                MenuSelect();
                break;
            case 5:
                System.out.println("Vous avez choisi de quitter le jeu");
                break;
            default:
                System.out.println("Choix invalide");
                return MenuSelect();
        }

        return choix;
    }

    public void boucle() {

        for (int i = 0; i < niveau_actuel.length; i++) {
            System.out.print(niveau_actuel[i]);
            if ((i + 1) % 8 == 0) {
                System.out.println();
            }
        }

        for (int i = 0; i < niveau_actuel.length; i++) {
            if (niveau_actuel[i] == '@') {
                joueur_ligne = i / 8;
                joueur_colonne = i % 8;
                position_joueur = i;
            }
        }

        System.out.println("Position : ligne :" + joueur_ligne + " colonne :" + joueur_colonne);
        System.out.println("Entrez votre choix :");

        Scanner sc = new Scanner(System.in);
        String step = sc.nextLine();

        int indice;

        switch (step) {
            case "z":
                System.out.println("Vous avez choisi de monter");
                joueur_ligne--;
                indice = joueur_ligne * 8 + joueur_colonne;
                verif_case();
                break;

            case "s":
                System.out.println("Vous avez choisi de descendre");
                joueur_ligne++;
                indice = joueur_ligne * 8 + joueur_colonne;
                verif_case();
                break;

            case "d":
                System.out.println("Vous avez choisi d'aller à droite");
                joueur_colonne++;
                indice = joueur_ligne * 8 + joueur_colonne;
                verif_case();
                break;

            case "q":
                System.out.println("Vous avez choisi d'aller à gauche");
                joueur_colonne--;
                indice = joueur_ligne * 8 + joueur_colonne;
                verif_case();
                break;

            case "r":
                System.out.println("Vous avez choisi de recommencer le niveau ");
                switch (choix_niveau) {
                    case 1:
                        niveau1();
                        break;
                    case 2:
                        niveau2();
                        break;
                    case 3:
                        niveau3();
                        break;
                }
                break;

            case "x":
                System.out.println("Vous avez choisi de retourner au menu");
                MenuSelect();
                break;

            default:
                System.out.println("Choix invalide");
        }

        boucle();
    }

    public void verif_case() {

        int indice = joueur_ligne * 8 + joueur_colonne;

        if (niveau_actuel[indice] == '#') {
            System.out.println("Vous ne pouvez pas aller sur un mur");
            boucle();
        }

        else if (niveau_actuel[indice] == ' ') {
            niveau_actuel[indice] = '@';
            niveau_actuel[position_joueur] = ' ';
        }

        else if (niveau_actuel[indice] == '$') {
            niveau_actuel[indice-8] = '$';
            niveau_actuel[indice] = '@';
            niveau_actuel[position_joueur] = ' ';

        }
    }

    public void niveau1() {

        char[] Niveau1 = {
            '#','#','#','#','#','#','#','#',
            '#',' ',' ',' ',' ',' ',' ','#',
            '#',' ',' ','.',' ',' ',' ','#',
            '#',' ',' ','$',' ',' ',' ','#',
            '#',' ',' ','@',' ',' ',' ','#',
            '#',' ',' ',' ',' ',' ',' ','#',
            '#','#','#','#','#','#','#','#'
        };

        niveau_actuel = Niveau1.clone();

        boucle();
    }

    public void niveau2() {

        System.out.println("Lancement du niveau 2");

        char[] Niveau2 = {
            '#','#','#','#','#','#','#','#',
            '#',' ',' ',' ',' ',' ',' ','#',
            '#',' ',' ','.',' ',' ',' ','#',
            '#','$',' ','$',' ',' ',' ','#',
            '#',' ',' ','@',' ','.',' ','#',
            '#',' ',' ',' ',' ',' ',' ','#',
            '#','#','#','#','#','#','#','#'
        };

        niveau_actuel = Niveau2.clone();

        boucle();
    }

    public void niveau3() {

        System.out.println("Lancement du niveau 3");

        char[] Niveau3 = {
            '#','#','#','#','#','#','#','#',
            '#','.',' ',' ',' ',' ',' ','#',
            '#',' ',' ','.',' ','$',' ','#',
            '#',' ',' ','$',' ',' ',' ','#',
            '#',' ',' ','@',' ',' ',' ','#',
            '#',' ',' ',' ',' ',' ',' ','#',
            '#','#','#','#','#','#','#','#'
        };

        niveau_actuel = Niveau3.clone();

        boucle();
    }
}