import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSeparator {
    public static void main(String[] args) {
        // Step 1: Read from numbers.txt and separate into even.txt and odd.txt
        try {
            File inputFile = new File("numbers.txt");
            Scanner reader = new Scanner(inputFile);
            
            PrintWriter evenWriter = new PrintWriter("even.txt");
            PrintWriter oddWriter = new PrintWriter("odd.txt");

            while (reader.hasNextInt()) {
                int num = reader.nextInt();
                if (num % 2 == 0) {
                    evenWriter.print(num + " ");
                } else {
                    oddWriter.print(num + " ");
                }
            }

            // Close resources to ensure data is written and saved
            reader.close();
            evenWriter.close();
            oddWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error processing files.");
            return;
        }

        // Step 2: Read and display even.txt
        System.out.print("Even File: ");
        try (Scanner readEven = new Scanner(new File("even.txt"))) {
            while (readEven.hasNext()) {
                System.out.print(readEven.next() + " ");
            }
        } catch (FileNotFoundException e) {
            // Silently handle or print error if even.txt wasn't created
        }
        System.out.println();

        // Step 3: Read and display odd.txt
        System.out.print("Odd File: ");
        try (Scanner readOdd = new Scanner(new File("odd.txt"))) {
            while (readOdd.hasNext()) {
                System.out.print(readOdd.next() + " ");
            }
        } catch (FileNotFoundException e) {
            // Silently handle or print error if odd.txt wasn't created
        }
        System.out.println();
    }
}
