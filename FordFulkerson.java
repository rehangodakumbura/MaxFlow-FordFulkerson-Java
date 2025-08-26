//Name: Rehan Godakumbura
//UOW ID: W2053994
//iit ID: 20230879

import java.util.*;

public class FordFulkerson {

    public int maxFlow(FlowNetwork network, int source, int sink) {
        Map<Integer, Map<Integer, Integer>> adj = network.getAdjacencyList();
        int maxFlow = 0;
        int pathCount = 0;

        while (true) {
            int[] parent = new int[network.getNumberOfNodes()];
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            parent[source] = source;

            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (Map.Entry<Integer, Integer> entry : adj.get(u).entrySet()) {
                    int v = entry.getKey();
                    int capacity = entry.getValue();
                    if (capacity > 0 && parent[v] == -1) {
                        parent[v] = u;
                        if (v == sink) break;
                        queue.add(v);
                    }
                }
            }

            if (parent[sink] == -1) {
                break;
            }

            // Find bottleneck capacity
            int pathFlow = Integer.MAX_VALUE;
            int v = sink;
            while (v != source) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, adj.get(u).get(v));
                v = u;
            }

            // Print path
            pathCount++;
            System.out.print("Path " + pathCount + ": ");
            printPath(parent, source, sink);
            System.out.println(" with flow: " + pathFlow);

            // Update residual capacities
            v = sink;
            while (v != source) {
                int u = parent[v];
                adj.get(u).put(v, adj.get(u).get(v) - pathFlow);
                adj.get(v).put(u, adj.get(v).getOrDefault(u, 0) + pathFlow);
                v = u;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private void printPath(int[] parent, int source, int current) {
        if (current == source) {
            System.out.print(source);
        } else {
            printPath(parent, source, parent[current]);
            System.out.print(" -> " + current);
        }
    }
}
