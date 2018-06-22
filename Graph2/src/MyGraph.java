import java.util.HashSet;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.graph.SimpleGraph;

public class MyGraph
{
	private SimpleGraph<Node, Edge> graph;

	public MyGraph()
	{
		this.graph = new SimpleGraph<>(Edge.class);
	}

	public SimpleGraph<Node, Edge> getMainGraph()
	{
		return graph;
	}

	public void setMainGraph(SimpleGraph<Node, Edge> mainGraph)
	{
		this.graph = mainGraph;
	}

	public void addNode(Node node)
	{
		this.graph.addVertex(node);
	}

	public void addEdge(Edge e)
	{
		this.graph.addEdge(e.getSourceNode(), e.getDestNode(), e);
	}

	public Set<Node> getVertices()
	{
		return this.graph.vertexSet();
	}
	public int getNodeDegree(Node vertex)
	{
		return this.graph.degreeOf(vertex);
	}
	public Set<Node> getNeighbours(Node vertex)
	 {
	  Set<Node> neighbours = new HashSet<>();

	  for (Node neighbour : this.graph.vertexSet())
	   if (this.graph.containsEdge(vertex, neighbour))
	    neighbours.add(neighbour);

	  return neighbours;
	 }
	
	public Node getNodeByName(int name)
	{
		for (Node node : graph.vertexSet())
			if (node.getNodeID() == name)
				return node;

		return null;
	}

	@Override
	public String toString()
	{
		String main = "";
		String pre = "MyGraph: "
			+ "\nNode Counts: " + this.graph.vertexSet().size()
			+ "\nEdge Counts: " + this.graph.edgeSet().size();
		for (Node node : getVertices())
			main += "Node " + node.getNodeName() + "'s neighbours are: " + Graphs.neighborListOf(graph, node) + "\n";

		return pre + "\n" + main;
	}

}
