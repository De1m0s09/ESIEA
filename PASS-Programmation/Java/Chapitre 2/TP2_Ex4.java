//exercice boucle while
public class TP2_Ex4 {
    
    static void whiledo(){
    int n=10000;
    int s = 42;
    int d = 0;
    while (n>s){
        n=n/2;
        d++;
    }
    System.out.println("Nombre plus petit que le secret atteint en " + d + " divisions avec whiledo."); 
}
    static void dowhile(){
        int n=10000;
        int s = 42;
        int d = 0;
        do {
            n=n/2;
            d++;}
        while(n>s);
        System.out.println("Nombre plus petit que le secret atteint en " + d + " divisions avec dowhile."); 
    }
    public static void main(String[] args){
        dowhile();
    }
}
    
