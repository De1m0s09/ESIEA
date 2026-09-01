public class GestionGains {
    public static void main(String[] args) {
        int gains, payment = 0, encaissement = 0, invest = 0;

        // Exemple de valeur pour tester (à modifier pour tester les autres cas)
        gains = 15;

        if (gains < 0) {
            payment = gains;
        } else if (gains > 10) {
            encaissement = 10;
            invest = gains - 10;
        } else {
            encaissement = gains;
        }

        System.out.println("gains = " + gains);
        System.out.println("payment = " + payment);
        System.out.println("encaissement = " + encaissement);
        System.out.println("invest = " + invest);
    }
}
