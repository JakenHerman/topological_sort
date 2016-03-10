public class DataSort {
    
    public static void main(String[] args){
        
        DirectedGraph x = new DirectedGraph();
        TopologicalSort y = new TopologicalSort();
      /*  x.addNode(3);
        x.addNode(5);
        x.addNode(10);
        x.addNode(4);
        x.addNode(9);
        x.addNode(8);
        x.addNode(7);
        x.addNode(6);
        x.addNode(1);
        x.addEdge(3, 6);
        x.addEdge(6, 1);
        x.addEdge(6, 5);
        x.addEdge(5, 1);
        x.addEdge(3, 4);
        x.addEdge(10, 4);
        x.addEdge(9, 8);
        x.addEdge(8, 7);
        x.addEdge(4, 6); */
        
        
      
        x.addNode("Mary");
        x.addNode("Tom");
        x.addNode("Bob");
        x.addNode("Sam");
        x.addNode("Joe");
        x.addNode("Betty");
        
        x.addEdge("Mary", "Sam");
        x.addEdge("Tom", "Sam");
        x.addEdge("Tom", "Bob");
        x.addEdge("Joe", "Sam");
        x.addEdge("Sam", "Betty");
        
        System.out.println(y.sort(x));
    
    }
}