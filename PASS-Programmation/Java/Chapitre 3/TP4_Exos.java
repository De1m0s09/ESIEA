//exercices sur l'exploitation d'arrays (listes)
public class TP4_Exos {
    
    //exo 1
    static void entiers(){
        int[] entiers = {12, 15, 8, 17, 16};
        for(int i=0; i<entiers.length; i++ ){
            System.out.println(entiers[i]);
        }
    }
    //exo 3
    static void temperatures(){
        int[] temps = {14, 21, 9, 25, 18, 30, 12};
        int max = 0;
        for(int i=0; i<temps.length; i++){
            if(temps[i]>max){
                max=temps[i];}
        }
        System.out.println(max);
    }
    //exo 4
    static void longueur(String mot){
        int l=mot.length();
        char prem=mot.charAt(0);
        char der=mot.charAt(mot.length()-1);
        System.out.println("Le mot est de longueur " + l);
        System.out.println("La première lettre est " + prem);
        System.out.println("La dernière lettre est " + der);
    }
    //exo 5
    static void concat(String mot1, String mot2){
        String sortie = mot1 + mot2;
        System.out.println(sortie);
    }
    //Exo 6
    static void anti(){
        int compteur=0;
        String mot = "anticonstitutionnellement";
        for(int i=1; i<mot.length(); i++){
            char a= mot.charAt(i);
            if(a == 'n'){
                compteur++;
            }
        }    
    System.out.println(compteur);
    }
        
    //main
    static void main(String[] Args){
        anti();
    }
}
