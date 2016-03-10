import java.util.*; // For List, Map.

public final class TopologicalSort {
    public static <T> List<T> sort(DirectedGraph<T> g) {
        DirectedGraph<T> gRev = reverseGraph(g);

        List<T> result = new ArrayList<T>();
        Set<T> visited = new HashSet<T>();

        Set<T> expanded = new HashSet<T>();

        for (T node: gRev)
            explore(node, gRev, result, visited, expanded);

        return result;
    }

    private static <T> void explore(T node, DirectedGraph<T> g,
                                    List<T> ordering, Set<T> visited,
                                    Set<T> expanded) {

        if (visited.contains(node)) {
 
            if (expanded.contains(node)) return;
            throw new IllegalArgumentException("Graph contains a cycle.");
        }
        
        visited.add(node);

        for (T predecessor: g.edgesFrom(node))
            explore(predecessor, g, ordering, visited, expanded);

        ordering.add(node);

        expanded.add(node);
    }

    private static <T> DirectedGraph<T> reverseGraph(DirectedGraph<T> g) {
        DirectedGraph<T> result = new DirectedGraph<T>();

        for (T node: g)
            result.addNode(node);

        for (T node: g)
            for (T endpoint: g.edgesFrom(node))
                result.addEdge(endpoint, node);

        return result;
    }
    
}
