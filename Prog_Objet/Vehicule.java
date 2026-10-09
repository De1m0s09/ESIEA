
public class Vehicule {
    
    //attributs de la classe Vehicule, c'est une caractéristique de la classe
    //Ce sont qu'il faut définir pour pouvoir les utiliser dans le constructeur et les méthodes de la classe
    public String marque;
    public int roues;

    //Le constructeur est une méthode qui permet de définir un "moule" de création d'objet.
    //Il est appelé comme un "Type" de l'objet, et permet de créer un objet de type "Vehicule"
    public Vehicule(String marque, int roues) {
        //on va utiliser this. "attribut" pour renvoyer la valeur de l'attribut de l'objet créé
        // à la valeur du paramètre passé au constructeur lors de la création de l'objet
        this.marque = marque;
        this.roues = roues;
    }

    public static void main(String[] args) {
        //création d'une première instance de la classe Vehicule, premier "objet" de type Vehicule
        Vehicule v1 = new Vehicule("Renault", 4);
        //création d'une deuxième instance de la classe Vehicule, deuxième "objet" de type Vehicule
        Vehicule v2 = new Vehicule("Peugeot", 2);
        //affichage des attributs de l'objet v1
        //on utilise les getters pour accéder aux attributs de l'objet v1 et les afficher
        System.out.println("La marque du véhicule 1 est : " + v1.getMarque());
        //on utilise les setters pour modifier les attributs de l'objet v1
        //c'est préférable d'utiliser les setters pour modifier les attributs de l'objet, 
        // plutôt que d'accéder directement aux attributs de l'objet car
        // cela permet de protéger les données de l'objet et d'éviter les modifications non souhaitées.
        v1.setMarque("Citroën");
        System.out.println("Le nombre de roues du véhicule 1 est : " + v1.getRoues());
        //affichage des attributs de l'objet v2
        System.out.println("La marque du véhicule 2 est : " + v2.getMarque());
        System.out.println("Le nombre de roues du véhicule 2 est : " + v2.getRoues());
    }
//On va chercher à utiliser des getters/setters pour accéder aux attributs de la classe Vehicule
//et les modifier. Les getters permettent de récupérer la valeur d'un attribut, et les setters permettent de modifier la valeur d'un attribut.
//Les getters et setters sont des méthodes publiques qui permettent d'accéder aux attributs privés de la classe. 
// Ils sont utilisés pour protéger les données de la classe et éviter les modifications non souhaitées.

    public String getMarque() {
        //ici, on va utiliser this pour confirmer qu'il s'agit bien de la propriété de la classe et non d'une variable locale.
        return this.marque;
    }

    public int getRoues() {
        return this.roues;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setRoues(int roues) {
        this.roues = roues;
    }
}
