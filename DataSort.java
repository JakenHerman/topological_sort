import java.util.*;

public class DataSort {
    
    static String userType = " ";
    static Scanner scanCommand = new Scanner(System.in);

    public static void main(String[] args){
        
        // ask the user what datatype they would like to sort
        getDataType();
        
        /*
         * Prompt the user for commands and show what commands are available. This wont
         * show up until after the user has specified which datatype they'd like to sort.
         * Once the prompt is displayed, the user can immediately start manipulating their
         * directed graph.
         */
        System.out.println("Create your graph here in the terminal. Commands are:");
        System.out.println("add-node-x - replace x with data");
        System.out.println("add-edge-x-y - replace x with starting node, y with ending node");
        System.out.println("remv-edge-x-y - replace x with starting node, y with ending node");
        System.out.println("emerge-from-x - replace x with node to see what edges emerge from node x");
        System.out.println("empty-graph - checks if graph is empty");
        System.out.println("sort-data - sort the data, stop reading input");
        System.out.println("quit - quit program");
        
     
     // Check what type the userType is so we can handle the data appropriately.
        switch (userType.toLowerCase()) {
            case "int":
                intType();
                break;
           case "string":
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
                break;
            default:
                intType();
                break;
        }
       
    }
   
   /*
    * 
    * getDataType will allow the user to specify what type of data they would like to sort.
    * the options are int, string, double, float, or char, and we can handle them all because
    * our directed graph is using a generic type "T".
    * 
    */ 
    
   public static void getDataType(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What datatype will your graph be containing? int, string, double, float, or char? If your input is invalid, type will default to string");
        userType = scan.nextLine();
    }
    
    /*
     * intType takes in string commands, creates a string array, then parses the nodes to be 
     * integers as specified by the variable userType which was given by the user in getDataType()
     * 
     * This will continue to loop until the user says "quit", and can add nodes, add edges, remove edges,
     * see what nodes emerge from a given node, check to see if a directed graph is empty, and sort data.
     * 
     */
    
    public static void intType(){
        DirectedGraph x = new DirectedGraph();
        TopologicalSort y = new TopologicalSort();                
        String userCommand = " ";
        String[] command = new String[5];
        do{
            userCommand = scanCommand.next();
            command = userCommand.split("-");
            if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("node")){
                int node = Integer.parseInt(command[2]);
                x.addNode(node);            
            }
            else if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("edge")){
                int startNode = Integer.parseInt(command[2]);
                int endNode = Integer.parseInt(command[3]);
                x.addEdge(startNode, endNode);
            }
            else if(command[0].equalsIgnoreCase("remv")){
                int startNode = Integer.parseInt(command[2]);
                int EndNode = Integer.parseInt(command[3]);
                x.removeEdge(startNode, EndNode);
            }
            else if(command[0].equalsIgnoreCase("emerge")){
                int node = Integer.parseInt(command[2]);
                System.out.println(x.connectedNodes(node));
            }
            else if(command[0].equalsIgnoreCase("empty")){
                System.out.println(x.isEmpty());
            }
            else if(command[0].equalsIgnoreCase("sort")){
                System.out.println(y.sort(x));
            }
            else if(command[0].equalsIgnoreCase("quit")){
                System.out.println("Thank you. Exiting Program.");
            }
            else {
                System.out.println("invalid command. try again");
            }
        } while(!command[0].equalsIgnoreCase("quit"));
    }
    
     /*
     * stringType takes in string commands, creates a string array, and then allows for node manipulation 
     * immediately because no parsing is necessary.
     * 
     * This will continue to loop until the user says "quit", and can add nodes, add edges, remove edges,
     * see what nodes emerge from a given node, check to see if a directed graph is empty, and sort data.
     * 
     */   
    
    public static void stringType(){
        DirectedGraph x = new DirectedGraph();
        TopologicalSort y = new TopologicalSort();                
        String userCommand = " ";
        String[] command = new String[5];
        do{
            userCommand = scanCommand.next();
            command = userCommand.split("-");
            if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("node")){
                x.addNode(command[2]);            
            }
            else if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("edge")){
                x.addEdge(command[2], command[3]);
            }
            else if(command[0].equalsIgnoreCase("remv")){
                x.removeEdge(command[2], command[3]);
            }
            else if(command[0].equalsIgnoreCase("emerge")){
                System.out.println(x.connectedNodes(command[2]));
            }
            else if(command[0].equalsIgnoreCase("empty")){
                System.out.println(x.isEmpty());
            }
            else if(command[0].equalsIgnoreCase("sort")){
                System.out.println(y.sort(x));
            }
            else if(command[0].equalsIgnoreCase("quit")){
                System.out.println("Thank you. Exiting Program.");
            }
            else {
                System.out.println("invalid command. try again");
            }
        } while(!command[0].equalsIgnoreCase("quit"));
    }
    
     /*
     * charType takes in string commands, creates a string array, then the nodes are the first char
     * given because char is specified by the variable userType which was given by the user in getDataType()
     * 
     * This will continue to loop until the user says "quit", and can add nodes, add edges, remove edges,
     * see what nodes emerge from a given node, check to see if a directed graph is empty, and sort data.
     * 
     */
    
    public static void charType(){
        DirectedGraph x = new DirectedGraph();
        TopologicalSort y = new TopologicalSort();                
        String userCommand = " ";
        String[] command = new String[5];
        do{
            userCommand = scanCommand.next();
            command = userCommand.split("-");
            if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("node")){
                x.addNode(command[2].charAt(0));            
            }
            else if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("edge")){
                x.addEdge(command[2].charAt(0), command[3].charAt(0));
            }
            else if(command[0].equalsIgnoreCase("remv")){
                x.removeEdge(command[2].charAt(0), command[3].charAt(0));
            }
            else if(command[0].equalsIgnoreCase("emerge")){
                System.out.println(x.connectedNodes(command[2].charAt(0)));
            }
            else if(command[0].equalsIgnoreCase("empty")){
                System.out.println(x.isEmpty());
            }
            else if(command[0].equalsIgnoreCase("sort")){
                System.out.println(y.sort(x));
            }
            else if(command[0].equalsIgnoreCase("quit")){
                System.out.println("Thank you. Exiting Program.");
            }
            else {
                System.out.println("invalid command. try again");
            }
        } while(!command[0].equalsIgnoreCase("quit"));
    }  

    
    /*
     * floatType takes in string commands, creates a string array, then parses the nodes to be 
     * floats as specified by the variable userType which was given by the user in getDataType()
     * 
     * This will continue to loop until the user says "quit", and can add nodes, add edges, remove edges,
     * see what nodes emerge from a given node, check to see if a directed graph is empty, and sort data.
     * 
     */    
    
    public static void floatType(){
        DirectedGraph x = new DirectedGraph();
        TopologicalSort y = new TopologicalSort();                
        String userCommand = " ";
        String[] command = new String[5];
        do{
            userCommand = scanCommand.next();
            command = userCommand.split("-");
            if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("node")){
                x.addNode(Float.parseFloat(command[2]));            
            }
            else if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("edge")){
                x.addEdge(Float.parseFloat(command[2]), Float.parseFloat(command[3]));
            }
            else if(command[0].equalsIgnoreCase("remv")){
                x.removeEdge(Float.parseFloat(command[2]), Float.parseFloat(command[3]));
            }
            else if(command[0].equalsIgnoreCase("emerge")){
                System.out.println(x.connectedNodes(Float.parseFloat(command[2])));
            }
            else if(command[0].equalsIgnoreCase("empty")){
                System.out.println(x.isEmpty());
            }
            else if(command[0].equalsIgnoreCase("sort")){
                System.out.println(y.sort(x));
            }
            else if(command[0].equalsIgnoreCase("quit")){
                System.out.println("Thank you. Exiting Program.");
            }
            else {
                System.out.println("invalid command. try again");
            }
        } while(!command[0].equalsIgnoreCase("quit"));
    }    
   
    
    /*
     * doubleType takes in string commands, creates a string array, then parses the nodes to be 
     * doubles as specified by the variable userType which was given by the user in getDataType()
     * 
     * This will continue to loop until the user says "quit", and can add nodes, add edges, remove edges,
     * see what nodes emerge from a given node, check to see if a directed graph is empty, and sort data.
     * 
     */
    
    public static void doubleType(){
        DirectedGraph x = new DirectedGraph();
        TopologicalSort y = new TopologicalSort();                
        String userCommand = " ";
        String[] command = new String[5];
        do{
            userCommand = scanCommand.next();
            command = userCommand.split("-");
            if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("node")){
                x.addNode(Double.parseDouble(command[2]));            
            }
            else if(command[0].equalsIgnoreCase("add") && command[1].equalsIgnoreCase("edge")){
                x.addEdge(Double.parseDouble(command[2]), Double.parseDouble(command[3]));
            }
            else if(command[0].equalsIgnoreCase("remv")){
                x.removeEdge(Double.parseDouble(command[2]), Double.parseDouble(command[3]));
            }
            else if(command[0].equalsIgnoreCase("emerge")){
                System.out.println(x.connectedNodes(Double.parseDouble(command[2])));
            }
            else if(command[0].equalsIgnoreCase("empty")){
                System.out.println(x.isEmpty());
            }
            else if(command[0].equalsIgnoreCase("sort")){
                System.out.println(y.sort(x));
            }
            else if(command[0].equalsIgnoreCase("quit")){
                System.out.println("Thank you. Exiting Program.");
            }
            else {
                System.out.println("invalid command. try again");
            }
        } while(!command[0].equalsIgnoreCase("quit"));
    }    
    
}