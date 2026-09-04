//exemple d'exploitation d'un tableau
public class ExempleTableau {
    public static void main(String[] args) {
        int[] T = {4, 8, 6, 2, 10};
        int somme = 0;

        for (int i = 0; i < 5; i++) {
            somme = somme + T[i];
        }

        double moyenne = (double) somme / 5;

        System.out.println("Somme : " + somme);
        System.out.println("Moyenne : " + moyenne);
    }
}
