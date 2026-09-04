public class ExempleRchrDichotomique {

    static int rechercheBinaire(int[] T, int n, int valeur) {
        int debut = 0;
        int fin = n - 1;

        while (debut <= fin) {
            int milieu = (debut + fin) / 2;

            if (T[milieu] == valeur) {
                return milieu;
            } else if (T[milieu] < valeur) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] T = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72};
        int n = T.length;

        System.out.println(rechercheBinaire(T, n, 23));
        System.out.println(rechercheBinaire(T, n, 100));
    }
}
