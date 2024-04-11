import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class Program8 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Program8 <file_path>");
            return;
        }

        String filePath = args[0];
        try {
            processFile(filePath);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void processFile(String filePath) throws FileNotFoundException, QueueFullException, QueueEmptyException {
        File inputFile = new File(filePath);
        try (Scanner scan = new Scanner(inputFile)) {
            scan.useDelimiter(""); // Read character by character

            // Assuming the queue size is always two digits
            if (!scan.hasNext()) throw new IllegalArgumentException("File is empty or queue size not specified.");
            String queueSizeStr = scan.next() + scan.next();
            int queueSize = Integer.parseInt(queueSizeStr);

            Queue<Character> queue = new Queue<>(queueSize);

            // Now, process the rest of the input as the queue content
            while (scan.hasNext()) {
                char ch = scan.next().charAt(0);
                if (queue.isFull()) {
                    printAndEmptyQueue(queue); // Print the queue if it's full
                } else {
                    queue.enqueue(ch); // Enqueue characters until the queue is full
                }
            }
            // Ensure to print and empty the queue if it's not empty by the end of file processing
            if (!queue.isEmpty()) {
                printAndEmptyQueue(queue);
            }
        }
    }


    private static void printAndEmptyQueue(Queue<Character> queue) throws QueueEmptyException {
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue());
        }
        System.out.println(); // Ensure to print a newline after printing queue contents
    }
}
