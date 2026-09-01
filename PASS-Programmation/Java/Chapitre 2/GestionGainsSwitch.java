public class GestionGainsSwitch {
    public static void main(String[] args) {
        int gains = 15;
        int payment = 0, encaissement = 0, invest = 0;

        // Étape 1 : déterminer la catégorie (un if reste nécessaire ici,
        // car un switch ne sait pas tester des intervalles comme gains < 0)
        int categorie;
        if (gains < 0) {
            categorie = 1;
        } else if (gains > 10) {
            categorie = 2;
        } else {
            categorie = 3;
        }

        // Étape 2 : agir selon la catégorie, avec un switch
        switch (categorie) {
            case 1:
                payment = gains;
                break;
            case 2:
                encaissement = 10;
                invest = gains - 10;
                break;
            case 3:
                encaissement = gains;
                break;
        }

        System.out.println("gains = " + gains);
        System.out.println("payment = " + payment);
        System.out.println("encaissement = " + encaissement);
        System.out.println("invest = " + invest);
    }
}

