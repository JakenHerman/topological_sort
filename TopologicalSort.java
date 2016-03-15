import java.util.*;

public final class TopologicalSort {
    public static <T> List<T> sort(DirectedGraph<T>userGraph) {
        DirectedGraph<T> reversed_user_graph = reverseGraph(userGraph);

        List<T> result = new ArrayList<T>();
        Set<T> visited = new HashSet<T>();

        Set<T> expanded = new HashSet<T>();

        for (T node: reversed_user_graph)
            explore(node, reversed_user_graph, result, visited, expanded);

        return result;
    }

    
    private static <T> DirectedGraph<T> reverseGraph(DirectedGraph<T>userGraph) {
        DirectedGraph<T> result = new DirectedGraph<T>();

        for (T node:userGraph)
            result.addNode(node);

        for (T node:userGraph)
            for (T endpoint:userGraph.connectedNodes(node))
                result.addEdge(endpoint, node);

        return result;
    }
    
    private static <T> void explore(T node, DirectedGraph<T>userGraph,
                                    List<T> ordering, Set<T> visited,
                                    Set<T> expanded) {

        if (visited.contains(node)) {
 
            if (expanded.contains(node)) return;
            throw new IllegalArgumentException("THIS GRAPH CONTAINS A CYCLE");
        }
        
        visited.add(node);

        for (T predecessor:userGraph.connectedNodes(node))
            explore(predecessor,userGraph, ordering, visited, expanded);

        ordering.add(node);

        expanded.add(node);
    }


    
}
