
public class Edge
{
	private int		edgeID;
	private Node	sourceNode;
	private Node	destNode;
	private int		weight;
	private int		weight2;

	public Edge(int edgeID, Node source, Node dest)
	{
		this.edgeID = edgeID;
		this.sourceNode = source;
		this.destNode = dest;
	}

	public int getEdgeID()
	{
		return edgeID;
	}

	public void setEdgeID(int edgeID)
	{
		this.edgeID = edgeID;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(String weight)
	{
		this.weight = Integer.parseInt(weight);
	}

	public int getWeight2() {
		return weight2;
	}

	public void setWeight2(String weight2) {
		this.weight2 = Integer.parseInt(weight2);
	}

	public Node getSourceNode()
	{
		return sourceNode;
	}

	public void setSourceNode(Node source)
	{
		this.sourceNode = source;
	}

	public Node getDestNode()
	{
		return destNode;
	}

	public void setDestNode(Node destination)
	{
		this.destNode = destination;
	}
}
