# MaxFlow-FordFulkerson-Java

A comprehensive implementation of the Ford-Fulkerson method for computing maximum flow in directed networks, featuring both BFS-based (Edmonds-Karp) and DFS-based algorithms.

## 📋 Overview

This project implements the Ford-Fulkerson algorithm using two different path-finding strategies:
- **BFS-based Edmonds-Karp**: Uses Breadth-First Search to find shortest augmenting paths
- **DFS-based Ford-Fulkerson**: Uses Depth-First Search to find any augmenting path

The implementation efficiently handles flow networks using optimized data structures and provides detailed performance analysis.

## 🚀 Features

- **Dual Algorithm Support**: Both BFS and DFS implementations
- **Memory Efficient**: Sparse adjacency list representation
- **Performance Optimized**: Hybrid data structure for fast lookups and traversals
- **Scalable**: Handles large graphs efficiently (tested up to 128MB+)
- **Detailed Output**: Shows step-by-step augmenting paths and flow updates

## 📊 Algorithm Comparison

| Algorithm | Time Complexity | Space Complexity | Best Use Case |
|-----------|----------------|------------------|---------------|
| BFS (Edmonds-Karp) | O(VE²) | O(V + E) | Real-world applications, guaranteed polynomial time |
| DFS (Ford-Fulkerson) | O(EF) | O(V + E) | Faster per iteration, good for specific graph types |

## 🔧 Data Structure Design

### Capacity Map
```java
HashMap<Integer, HashMap<Integer, Integer>>
```
- Stores only existing edges, reducing memory usage
- Avoids full N × N matrix representation

### Adjacency List
```java
Map<Integer, List<Integer>> adjList
```
- Enables constant-time neighbor traversal
- Efficient for sparse graphs

## 📈 Performance Results

Empirical testing results on benchmark graphs:

| Graph Size | BFS Execution Time | DFS Execution Time |
|------------|-------------------|-------------------|
| Small (bridge_1.txt) | 1.5 ms | 1.8 ms |
| Medium (bridge_5.txt) | 12 ms | 15 ms |
| Large (bridge_10.txt) | 187 ms | 241 ms |

**Key Findings:**
- BFS consistently outperforms DFS for small and medium graphs
- BFS-based Edmonds-Karp is preferred for very large graphs
- DFS is faster per iteration but requires more iterations

## 🎯 Input Format

The program accepts graph input in the following format:
```
6
0 1 4
0 4 1
1 2 2
1 3 1
2 3 1
2 4 1
3 4 2
1 5 1
4 5 4
```

Where:
- First line: Number of vertices
- Following lines: `source destination capacity`
- Source node: 0
- Sink node: highest numbered vertex

## 💻 Usage

### Running BFS-based Edmonds-Karp
```java
// Initialize the algorithm with your graph
MaxFlowBFS maxFlow = new MaxFlowBFS(graph);
int result = maxFlow.fordFulkerson(source, sink);
System.out.println("Maximum Flow: " + result);
```

### Running DFS-based Ford-Fulkerson
```java
// Initialize the algorithm with your graph
MaxFlowDFS maxFlow = new MaxFlowDFS(graph);
int result = maxFlow.fordFulkerson(source, sink);
System.out.println("Maximum Flow: " + result);
```

## 📁 Project Structure

```
MaxFlow-FordFulkerson-Java/
├── src/
│   ├── MaxFlowBFS.java          # BFS-based Edmonds-Karp implementation
│   ├── MaxFlowDFS.java          # DFS-based Ford-Fulkerson implementation
│   └── Main.java                # Main driver program
├── test/
│   ├── bridge_1.txt             # Small benchmark graph
│   ├── bridge_5.txt             # Medium benchmark graph
│   └── bridge_10.txt            # Large benchmark graph
└── README.md
```

## 🔍 Example Output

For the benchmark graph `bridge_1.txt`:

**BFS-based Edmonds-Karp:**
- Finds shortest augmenting paths systematically
- Guarantees optimal number of iterations
- Maximum Flow: 3

**DFS-based Ford-Fulkerson:**
- Finds any available augmenting path
- May require more iterations but faster per iteration
- Maximum Flow: 3

Both algorithms correctly update the residual graph and terminate when no augmenting paths are available.

## 🛠️ Technical Details

### Key Optimizations
- **Sparse Representation**: Only stores existing edges, saving memory
- **Iterative DFS**: Stack-based implementation prevents stack overflow
- **Efficient Path Finding**: Optimized BFS/DFS implementations
- **Residual Graph Updates**: Proper forward and backward edge handling

### Space Complexity
- Adjacency list and capacity map: O(V + E)
- Significantly better than full O(V²) matrix representation
- Enables handling of millions of nodes efficiently

## 🚦 Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/rehangodakumbura/MaxFlow-FordFulkerson-Java.git
   cd MaxFlow-FordFulkerson-Java
   ```

2. **Compile the project**
   ```bash
   javac src/*.java
   ```

3. **Run with test data**
   ```bash
   java -cp src Main test/bridge_1.txt
   ```

## 📝 Requirements

- Java 8 or higher
- No external dependencies required

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Rehan Dewkalana Godakumbura**

## 🙏 Acknowledgments

- Ford-Fulkerson algorithm by L. R. Ford Jr. and D. R. Fulkerson
- Edmonds-Karp algorithm improvement by Jack Edmonds and Richard Karp
