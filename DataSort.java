import java.util.*;

public class DataSort {
    
    static String userType = " ";
    
    public static void main(String[] args){
        
        DirectedGraph x = new DirectedGraph();
        TopologicalSort y = new TopologicalSort();

        getDataType();
        switch (userType.toLowerCase()) {
            case "int":
                intType();
                break;
           /* case "string":
                stringType();
                break;
            case "double":
                doubleType();
                break;
            case "float":
                floatType();
                break;
            case "char":
                charType();
                break; */
            default:
                intType();
                break;
        }
        
        
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
        x.addEdge(4, 6);
        
        
      
        x.addNode("Mary");
        x.addNode("Tom");
        x.addNode("Bob");
        x.addNode("Sam");
        x.addNode("Joe");
        x.addNode("Betty");
        x.addNode("Betty");
        x.addNode("Joe");
        
        x.addEdge("Mary", "Sam");
        x.addEdge("Tom", "Sam");
        x.addEdge("Tom", "Bob");
        x.addEdge("Joe", "Sam");
        x.addEdge("Sam", "Betty");
        
        System.out.println(y.sort(x)); */
    
    }
    
    public static void intType(){
        DirectedGraph x = new DirectedGraph();
        TopologicalSort y = new TopologicalSort();
        
                
        System.out.println("Create your graph here in the terminal. Commands are:");
        System.out.println("add node x - replace x with data");
        System.out.println("add edge x y - replace x with starting node, y with ending node");
        System.out.println("remv edge x y - replace x with starting node, y with ending node");
        System.out.println("emerge from x - replace x with node to see what edges emerge from node x");
        System.out.println("empty graph - checks if graph is empty");
        System.out.println("sort data - sort the data, stop reading input");
        System.out.println("quit program - quit program");
        
       
        Scanner scanCommand = new Scanner(System.in);
        String userCommand = "null value";
        do{
            userCommand = scanCommand.nextLine();
            if(userCommand.substring(0, 8).equalsIgnoreCase("add node")){
                String strnode = userCommand.substring(9, 10);
                int node = Integer.parseInt(strnode);
                x.addNode(node);            
            }
            else if(userCommand.substring(0, 8).equalsIgnoreCase("add edge")){
                String strnode = userCommand.substring(9, 10);
                String strend = userCommand.substring(11, 12);

                int startNode = Integer.parseInt(strnode);
                int endNode = Integer.parseInt(strend);
                x.addEdge(startNode, endNode);
            }
            else if(userCommand.substring(0, 8).equalsIgnoreCase("remv edg")){
                String strnode = userCommand.substring(10, 11);
                String strend = userCommand.substring(12, 13);

                int startNode = Integer.parseInt(strnode);
                int EndNode = Integer.parseInt(strend);

                x.removeEdge(startNode, EndNode);
            }
            else if(userCommand.substring(0, 8).equalsIgnoreCase("emerge f")){
                String strnode = userCommand.substring(12, 13);
                int node = Integer.parseInt(strnode);

                x.edgesFrom(node);
            }
            else if(userCommand.substring(0, 8).equalsIgnoreCase("empty g")){
                System.out.println(x.isEmpty());
            }
            else if(userCommand.substring(0, 8).equalsIgnoreCase("sort dat")){
                System.out.println(y.sort(x));
            }
            else {
                System.out.println("invalid command. try again");
            }
        } while(!userCommand.substring(0, 8).equalsIgnoreCase("quit prog"));
    }
    
    public static void getDataType(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What datatype will your graph be containing? int, string, double, float, or char? If your input is invalid, type will default to string");
        userType = scan.nextLine();
        scan.close();
    }
}