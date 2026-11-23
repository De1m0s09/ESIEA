public class CompteBancaire {
    private String numero;
    private String titulaire;
    private double solde;
    public CompteBancaire(String numero, String titulaire, double solde){
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = solde;
        if (solde<0){
            System.out.println("Solde initial négatif impossible");
            this.solde=0;
        }
    }
    public String getnumero(){
        return this.numero;
    }
    public String gettitulaire(){
        return this.titulaire;
    }
    public double getsolde(){
        return this.solde;
    }
    public void setnumero(String numero){
        this.numero = numero;
    }
    public void settitulaire(String titulaire){
        this.titulaire = titulaire;
    }
    public void setsolde(double solde){
        this.solde = solde;
    }
    public void depot(double montant){
        if (montant<0){
            System.out.println("Dépôt négatif refusé");
        }
        else{this.solde = this.solde+montant;}
    }      
    public void retrait(double montant){
        if (montant<0){
            System.out.println("Retrait négatif refusé");
        }
        else if (montant>this.solde){
            System.out.println("Retrait supérieur au solde refusé");
        }
        else{this.solde = this.solde-montant;}
        }
    public static void main(String[] args){
        CompteBancaire compte1 = new CompteBancaire("123456789", "Ce salopard de Toto", 10000);
        System.out.println("Nouveau compte créé : " + compte1.getnumero() + " au nom de " + compte1.gettitulaire() + " avec un solde de " + compte1.getsolde());
    }
}

