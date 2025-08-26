//Name: Rehan Godakumbura
//UOW ID: W2053994
//iit ID: 20230879


import java.util.*;

public class FlowNetwork {
    private final Map<Integer, Map<Integer, Integer>> adjList = new HashMap<>();
    private final int numberOfNodes;

    public FlowNetwork(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        for (int i = 0; i < numberOfNodes; i++) {
            adjList.put(i, new HashMap<>());
        }
    }

    public void addEdge(int from, int to, int capacity) {
        adjList.get(from).put(to, capacity);
        adjList.get(to).putIfAbsent(from, 0); // Ensure reverse edge exists
    }

    public Map<Integer, Map<Integer, Integer>> getAdjacencyList() {
        return adjList;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }
}
