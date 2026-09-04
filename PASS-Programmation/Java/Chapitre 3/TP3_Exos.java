//Exercice fonctionnement méthode
public class TP3_Exos {
    static void afficherAuRevoir(){
        System.out.println("Au revoir et à bientôt !");
    }
    static void prenom(String nom, String nom2){
        System.out.println("Bonjour " + nom + " et " + nom2);
    }
    static void carre(int nombre){
        System.out.println(nombre*nombre);
    }
    static void perimetreRectangle(double longueur, double largeur){
        System.out.println("Le rectangle fait " + longueur*largeur +" unités au carré.");
    }
    static float maximum(float a, float b, float c){
        if (a>b && a>c){
            return a;}
        else if (b>a && b>c){
            return b;}
        else if (c>a && c>b){
            return c;}
        else{
            System.out.println("Les trois nombres ont la même valeur.");
            return 0;
        }
    }
       public static void main(String[] args){
        System.out.println(maximum(8/4, 456/75,9/3));
}
}