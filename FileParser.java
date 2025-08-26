//Name: Rehan Godakumbura
//UOW ID: W2053994
//iit ID: 20230879


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
    public static FlowNetwork parseFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();
        FlowNetwork network = new FlowNetwork(n);

        while (scanner.hasNextInt()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int capacity = scanner.nextInt();
            network.addEdge(from, to, capacity);
        }

        scanner.close();
        return network;
    }
}
