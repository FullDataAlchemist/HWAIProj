
public class Node{
	private int nodeID;
	private int nodeType;
	private boolean nodeVisited;
	private String nodeName;

	public Node() {

	}

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}

	public int getNodeType() {
		return nodeType;
	}

	public void setNodeType(int nodeType) {
		this.nodeType = nodeType;
	}

	public boolean isNodeVisited() {
		return nodeVisited;
	}

	public void setNodeVisited(boolean nodeVisited) {
		this.nodeVisited = nodeVisited;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public String toString() {
		return "Node Name=" + nodeName;
	}

}
