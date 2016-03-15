import java.util.*;

public final class DirectedGraph<T> implements Iterable<T> {

    private final Map<T, Set<T>> userGraph = new HashMap<T, Set<T>>();

 /*
 * 
 * addNode method allows users to add a node of generic type
 * T into the Directed Graph.The method will check to see if
 * the node already exists. If the node already exists in the 
 * graph, this input will be ignored. 
 * 
 */  
    
    
    public boolean addNode(T node) {
        if (userGraph.containsKey(node))
            return false;

        userGraph.put(node, new HashSet<T>());
        return true;
    }
    
    
/*
 * 
 * addEdge method allows users to add an edge in the graph from 
 * one node to another as specified by the user. The first node
 * that is called in the method of generic type T will be the 
 * predecessor of the following node called in the method, also
 * of generic type T.
 * 
 */
    
    public void addEdge(T startNode, T endNode) {
        if (!userGraph.containsKey(startNode) || !userGraph.containsKey(endNode))
            throw new NoSuchElementException("ONE OF THE NODES YOU SELECTED DOES NOT EXIST IN THE USER GRAPH");

        userGraph.get(startNode).add(endNode);
    }


    public void removeEdge(T startNode, T endNode) {
        if (!userGraph.containsKey(startNode) || !userGraph.containsKey(endNode))
            throw new NoSuchElementException("ONE OF THE NODES YOU SELECTED DOES NOT EXIST IN THE USER GRAPH");

        userGraph.get(startNode).remove(endNode);
    }

    public boolean edgeExists(T startNode, T endNode) {
        if (!userGraph.containsKey(startNode) || !userGraph.containsKey(endNode))
            throw new NoSuchElementException("ONE OF THE NODES YOU SELECTED DOES NOT EXIST IN THE USER GRAPH.");

        return userGraph.get(startNode).contains(endNode);
    }

    public Set<T> edgesFrom(T node) {
        Set<T> arcs = userGraph.get(node);
        if (arcs == null)
            throw new NoSuchElementException("NO SOURCE NODE");

        return Collections.unmodifiableSet(arcs);
    }


    public Iterator<T> iterator() {
        return userGraph.keySet().iterator();
    }

    public boolean isEmpty() {
        return userGraph.isEmpty();
    }
}
