//Name: Rehan Godakumbura
//UOW ID: W2053994
//iit ID: 20230879


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select benchmark type:");
        System.out.println("1. Bridge Files");
        System.out.println("2. Ladder Files");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        String filePath = "";

        if (choice == 1) {
            System.out.print("Enter bridge file number (1-19): ");
            int fileNumber = scanner.nextInt();
            if (fileNumber < 1 || fileNumber > 19) {
                System.out.println("Invalid bridge file number.");
                scanner.close();
                return;
            }
            filePath = "benchmarks/bridge_" + fileNumber + ".txt";

        } else if (choice == 2) {
            System.out.print("Enter ladder file number (1-20): ");
            int fileNumber = scanner.nextInt();
            if (fileNumber < 1 || fileNumber > 20) {
                System.out.println("Invalid ladder file number.");
                scanner.close();
                return;
            }
            filePath = "benchmarks/ladder_" + fileNumber + ".txt";

        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        try {
            FlowNetwork network = FileParser.parseFile(filePath);
            FordFulkerson ff = new FordFulkerson();
            
            long startTime = System.nanoTime(); // Start Timer
            int maxFlow = ff.maxFlow(network, 0, network.getNumberOfNodes() - 1);
            long endTime = System.nanoTime();   // End Timer

            System.out.println("Maximum Flow: " + maxFlow);

            long durationNano = endTime - startTime;
            double durationMilli = durationNano / 1_000_000.0;
            double durationSec = durationNano / 1_000_000_000.0;

            System.out.printf("Execution Time: %.3f ms (%.3f seconds)%n", durationMilli, durationSec);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
