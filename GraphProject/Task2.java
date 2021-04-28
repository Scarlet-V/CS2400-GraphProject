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
     

}