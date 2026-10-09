class Testarea {
    public static int fibonacci(int n) {
    // your code here
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
}

public static void main(String[] args) {
    int n=15;
    System.out.println("Fibonacci of "+n+" is: "+fibonacci(n));
}
}