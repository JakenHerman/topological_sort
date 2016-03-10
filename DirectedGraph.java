
import java.util.*; // For HashMap, HashSet

public final class DirectedGraph<T> implements Iterable<T> {

    private final Map<T, Set<T>> mGraph = new HashMap<T, Set<T>>();

    public boolean addNode(T node) {
        if (mGraph.containsKey(node))
            return false;

        mGraph.put(node, new HashSet<T>());
        return true;
    }

    public void addEdge(T start, T dest) {
        if (!mGraph.containsKey(start) || !mGraph.containsKey(dest))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        mGraph.get(start).add(dest);
    }


    public void removeEdge(T start, T dest) {
        if (!mGraph.containsKey(start) || !mGraph.containsKey(dest))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        mGraph.get(start).remove(dest);
    }

    public boolean edgeExists(T start, T end) {
        if (!mGraph.containsKey(start) || !mGraph.containsKey(end))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        return mGraph.get(start).contains(end);
    }

    public Set<T> edgesFrom(T node) {
        Set<T> arcs = mGraph.get(node);
        if (arcs == null)
            throw new NoSuchElementException("Source node does not exist.");

        return Collections.unmodifiableSet(arcs);
    }


    public Iterator<T> iterator() {
        return mGraph.keySet().iterator();
    }

    public int size() {
        return mGraph.size();
    }

    public boolean isEmpty() {
        return mGraph.isEmpty();
    }
}
