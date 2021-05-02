
import java.util.*;

class Graph2<E> {
	 private Map<E, Integer> vertexToIndex;
	 private E[] indexToVertex;
     private int[][] adjacencyMatrix;
	 
     @SuppressWarnings("unchecked")
	public Graph2(E[] vertices) {
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
     public void addVertex(E[] vertices) {
    	 for(int i=0; i<vertices.length; i++) {
    		 vertexToIndex.put(vertices[i], i);
    		 indexToVertex[i] = vertices[i];
    	 }
     }
     
     public void print() {
    	 System.out.print("  ");
    	 for(int i=0; i<indexToVertex.length; i++) {
    		 System.out.print(indexToVertex[i] + " ");
    	 }
    	 System.out.println();
    	 for(int i=0; i<adjacencyMatrix.length; i++) {
    		 System.out.print(indexToVertex[i] + " ");
    		 for(int j=0; j<adjacencyMatrix.length; j++) {
    			 System.out.print(adjacencyMatrix[i][j] + " ");
    		 }
    		 System.out.println();
    	 }
     }
     void depthFirstTraverse(E source) {
    	 Boolean[] visited = new Boolean[adjacencyMatrix.length];
    	 for(int i=0; i<indexToVertex.length; i++)
    		 visited[i] = false;
    	 
    	 Stack<E> stack = new Stack<E>();
    	 stack.push(source);
    	 
    	 int fromIdx, toIdx;
    	 while(stack.empty()==false) {
    		 
    		 System.out.print("Stack: ");
    		 for(E e: stack) {
    			 System.out.print(e + " ");
    		 }
    		 System.out.println();
    		 
    		 source = stack.pop();
    		 
    		 fromIdx = vertexToIndex.get(source);
    		 visited[fromIdx] = true;
    		 System.out.print(source + " ");
    		 for(toIdx=0;toIdx<adjacencyMatrix.length; toIdx++) {
    			 if(adjacencyMatrix[fromIdx][toIdx]==1 && visited[toIdx]==false) {
    				 if(!stack.contains(indexToVertex[toIdx]))
    					 stack.push(indexToVertex[toIdx]);
    			 }
    		 }
    		 System.out.println();
    	 }
     }
    public static void main(String[] args){
    	String[] vertices = {"A","B","C","D","E","F","G","H","I"};
    	Graph2<String> graph = new Graph2<String>(vertices);
    	  
        graph.addEdge("A", "B");
        graph.addEdge("A", "E");
        graph.addEdge("A", "D");
        graph.addEdge("D", "G");
        graph.addEdge("G", "H");
        graph.addEdge("H", "I");
        graph.addEdge("I", "F");
        graph.addEdge("F", "H");
        graph.addEdge("F", "C");
        graph.addEdge("C", "B");
        graph.addEdge("B", "E");
        graph.addEdge("E", "F");
        graph.addEdge("E", "H");
        graph.print();
        
        graph.depthFirstTraverse("A");
    }
}