public class ExempleRechSequentielle {

    static int rechercheLineaire(int[] T, int n, int valeur) {
        for (int i = 0; i < n; i++) {
            if (T[i] == valeur) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] T = {8, 3, 17, 5, 12, 9};
        int n = T.length;

        System.out.println(rechercheLineaire(T, n, 12));
        System.out.println(rechercheLineaire(T, n, 100));
    }
}
