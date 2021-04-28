import java.util.*;

class Graph<E> 
{
    private Map<E, Integer> vertexToIndex;
	private E[] indexToVertex;
    private int[][] adjacencyMatrix;
	 
     @SuppressWarnings("unchecked")
	public Graph(E[] vertices) 
    {
    	 adjacencyMatrix = new int[vertices.length][vertices.length];
    	 vertexToIndex = new HashMap<>();
    	 indexToVertex = (E[])new Object[vertices.length];
    	 addVertex(vertices);
     }

     public void addEdge(E from, E to) 
     {
        int fromIdx = vertexToIndex.get(from);
        int toIdx = vertexToIndex.get(to);
        adjacencyMatrix[fromIdx][toIdx] = 1;
    }
    public void addVertex(E[] vertices) 
    {
        for(int i=0; i<vertices.length; i++) 
        {
            vertexToIndex.put(vertices[i], i);
            indexToVertex[i] = vertices[i];
        }
    }
    public void print() 
    {
        System.out.print("  ");
        for(int i=0; i<indexToVertex.length; i++) 
        {
            System.out.print(indexToVertex[i] + " ");
        }
        System.out.println();
        for(int i=0; i<adjacencyMatrix.length; i++) 
        {
            System.out.print(indexToVertex[i] + " ");
            for(int j=0; j<adjacencyMatrix.length; j++) 
            {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}