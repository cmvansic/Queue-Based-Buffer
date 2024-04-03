import java.io.File;
import java.util.Scanner;
public class Program8 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Provide a file name as a command line argument.");
            return; // not neccesary?
        }

        File inputFile = new File(args[0]); // File in command line at first index
        try (Scanner scan = new Scanner(inputFile)) {
            scan.useDelimiter(""); //empty delimiter so the Input is read character by character.
        }

    }

}