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

     public void addEdge(E from, E to) {
        int fromIdx = vertexToIndex.get(from);
        int toIdx = vertexToIndex.get(to);
        adjacencyMatrix[fromIdx][toIdx] = 1;
    }
     

}