
public class Main {

	public static void main(String[] args) {
		Graph g = new Graph<Integer>();
		g.addEdge('0', '1', true);
		g.addEdge('0', '4', true);
		g.addEdge('1', '0', true);
		g.addEdge('1', '4', true);
		g.addEdge('1', '3', true);
		g.addEdge('1', '2', true);
		g.addEdge('2', '1', true);
		g.addEdge('2', '3', true);
		g.addEdge('3', '1', true);
		g.addEdge('3', '4', true);
		g.addEdge('3', '2', true);
		g.addEdge('4', '3', true);
		g.addEdge('4', '1', true);
		g.addEdge('4', '0', true);
		
		System.out.println(g.getVertexCount());
		g.DFS('0');
		System.out.println();
		g.BFS('0');
	}

}
