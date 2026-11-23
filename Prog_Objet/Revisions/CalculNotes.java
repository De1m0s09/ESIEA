import java.util.Scanner;

public class CalculNotes {
    public static void main(String[] args){
        Scanner notes = new Scanner(System.in);
        System.out.println("Entrez trois notes : ");
        double note1 = notes.nextDouble();
        double note2 = notes.nextDouble();
        double note3 = notes.nextDouble();
        double moyenne = (note1 + note2 + note3) / 3;
        boolean supA10 = moyenne >= 10;
        Scanner nom = new Scanner(System.in);
        System.out.println("Entrez votre nom : ");
        String nomEtudiant = nom.nextLine();
        System.out.println("La moyenne de " + nomEtudiant + " est : " + moyenne);
        
    }    
}
