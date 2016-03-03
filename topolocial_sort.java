import java.awt.*;

class Vertex
{
    public char label;
    
    public Vertex(char lab)
    {
        label = lab;
    }
} //end class Vertex

class Graph
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; //list of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices
    private char sortedArray[];
    
    public Graph()
    {
        vertexList = new Vertex[MAX_VERTS];
        
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) //set adjacency
            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = 0;
        sortedArray = new char[MAX_VERTS]; //sorted vert labels
    }
    
    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }
    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
    }
    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }
    public void topological_sort()
    {
        int orig_nVerts = nVerts; //remember how many verts
        
        //PICK UP HERE
    }
}