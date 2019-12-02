import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.Queue;

public class Graph<T>{
	
	private Map<T, List<T>> map = new HashMap<>();
	
	public void addVertex(T source) {
		map.put(source, new LinkedList<T>());
	}
	
	public void addEdge(T source, T destination, boolean bidirectional) {
		
		if(!map.containsKey(source))
			addVertex(source);
		
		if(!map.containsKey(destination))
			addVertex(destination);
		
		map.get(source).add(destination);
		
		if(bidirectional)
			map.get(destination).add(source);
	}
	
	public int getVertexCount() {
		return map.keySet().size();
	}
	
	public int getEdgesCount(boolean bidirection) {
		int count = 0;
		
		for(T vertex : map.keySet())
			count += map.get(vertex).size();
		
		if(bidirection == true)
			count = count/2;
		
		return count;
	}
	
	public void DFS(T node) {
		System.out.println("DFS:");
		
		Map<T, Boolean> finished = new HashMap<>();
		Map<T, Boolean> discovered = new HashMap<>();
		
		Stack<T> stack = new Stack<T>();
		stack.push(node);
		discovered.put(node, true);
		
		while(!stack.isEmpty()) {
			T current = stack.pop();
			System.out.print(current + " , ");
			finished.put(current, true);
			
			for(T vertex : map.keySet()) {
				if(!discovered.containsKey(vertex))
				{
					stack.push(vertex);
					discovered.put(vertex, true);
				}
			}
		}
	}
	
	public void BFS(T node) {
		Map<T, Boolean> visited = new HashMap<>();
		Queue<T> queue = new LinkedList<T>();
		
		visited.put(node, true);
		queue.add(node);
		System.out.println("BFS: ");
		
		while(!queue.isEmpty()) {
			T current = queue.poll();
			System.out.print(current + " ");
			
			for( T vertex : map.keySet()) {
				if(!visited.containsKey(vertex)) {
					visited.put(vertex, true);
					queue.add(vertex);
				}
			}
			
		}
		
	}
	
	
	
	
	

}
