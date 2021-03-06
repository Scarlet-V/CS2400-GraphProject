
import java.util.*;

class Graph<E> 
{
    private Map<E, List<E> > edgeMap;
	 
	Graph()
    {
    edgeMap = new HashMap<>();
	}

    public void addVertex(E s)
    {
        edgeMap.put(s, new LinkedList<E>());
    }
    public void addEdge(E from, E to)
    {  
        if (!edgeMap.containsKey(from))
            addVertex(from);
  
        if (!edgeMap.containsKey(to))
            addVertex(to);
  
        edgeMap.get(from).add(to);
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
  
        for (E v : edgeMap.keySet()) {
            str.append(v.toString() + " : ");
            for (E w : edgeMap.get(v)) 
            {
                str.append(w.toString() + " ");
            }
            str.append("\n");
        }
  
        return (str.toString());
    }
    Set<E> breadthFirstTraversal(E root)
    {
    	Queue<E> queue = new LinkedList<E>();
    	Set<E> visited = new LinkedHashSet<E>();
    	visited.add(root);
    	queue.add(root);
    	
    	while(!queue.isEmpty()) 
        {
    		E vertex = queue.poll();
    		for(E v: this.edgeMap.get(vertex)) 
            {
    			if(!visited.contains(v)) 
                {
    				visited.add(v);
    				queue.add(v);
    			}
    		}
    	}
    	return visited;
    }
    
    public static void main(String[] args)
    {
        Graph<String> graph = new Graph<String>();
  
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
        
        System.out.println("Graph:\n" + graph.toString());
        
        
        Set<String> bfs = graph.breadthFirstTraversal("A");
        for(String x: bfs) 
        {
        	System.out.print(x + "->");
        }
    }
}