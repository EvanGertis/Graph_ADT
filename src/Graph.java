import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

}
