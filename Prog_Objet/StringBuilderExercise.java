import java.util.Scanner;

public class StringBuilderExercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String baseString = scanner.nextLine();
        String appendString = scanner.nextLine();

        // Using StringBuilder to append the substring to the base string and print the result.
        StringBuilder builder = new StringBuilder(baseString);
        builder.append(appendString);
        
        String result = builder.toString();
        
        System.out.println(result);

        scanner.close();
    }
}
