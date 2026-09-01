public class TP2_Ex1 {
    public static void main(String[] args){
        double note = 13.5;
        if(note < 10) {
            System.out.println("Ajourné");
        }
        else if(10<=note && note<12) {
            System.out.println("Passable");
        }
        else if(12<=note && note<14) {
            System.out.println("Assez bien");
        }
        else if(14<=note && note<16){
            System.out.println("Bien");
        }
        else{
            System.out.println("Très bien");
        }
    }

}

/*
Pseudocode :
DEBUT
//Definition des variables
double note :
//Traitement
SI note < 10 ALORS AFFICHER String "Ajourné"
SINON SI 10 <= note < 12 ALORS AFFICHER String "Passable"
SINON SI 12 <= note < 14 ALORS AFFICHER String "Assez bien"
SINON SI 14 <= note < 16 ALORS AFFICHER String "Bien"
SINON AFFICHER String "Très bien"
FIN
*/