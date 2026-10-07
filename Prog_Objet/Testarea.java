class Testarea {
    public static int fibonacci(int n) {
    // your code here
    int suite[];
    suite=new int[n];
    for(int i=0;i<n;i++){
        if(i==0){
            suite[i]=i;
        }
        else if(i==1){
            suite[i]=i;
        }
        else{
            suite[i]=suite[i-1]+suite[i-2];
        }
    }
    return(suite[n-1]);
}
}
