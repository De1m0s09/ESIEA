import java.util.Scanner;
class Sokobon_Main {
    int  niveau;
    public void joueur(){
        
    }
    public static int MenuSelect(){
        //scanner in
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Sokoban ========");
        System.out.println("1.Niveau 1");
        System.out.println("2.Niveau 2");
        System.out.println("3.Niveau 3");
        System.out.println("4.Quitter");
        System.out.println("Votre choix:");
        int choix = sc.nextInt();
        switch (choix) {
            case 1:
                System.out.println("Vous avez choisi le niveau 1");
                
            case 2:
                System.out.println("Vous avez choisi le niveau 2");
                
            case 3:
                System.out.println("Vous avez choisi le niveau 3");
                
            case 4:
                System.out.println("Vous avez choisi de quitter le jeu");
                break;
            default:
                System.out.println("Choix invalide");
                MenuSelect();
        }
        return choix;
    }
    //Lancement niveau
    public void lancementNiveau(int niveau){
        this.niveau = niveau;
        if (niveau == 1) {
            System.out.println("Lancement du niveau 1");
        }}
    public void main(String[] args) {
        //affichage menu et sélection
        int niveau = MenuSelect();
        lancementNiveau(niveau);

    }
    public void niveau1(){
        String Niveau1[]={
            "########",
            "#      #",
            "#  $   #",
            "#  .   #",
            "#      #",
            "########"
        };
        For (int i = 0; i < Niveau1.length; i++) {
            System.out.println(Niveau1[i]);
        }
    }
}
