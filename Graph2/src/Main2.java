import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

	/**
	 * @param args
	 */
	private static int typeColorCount = 0;
	
	public static void main(String[] args) {
		MyGraph testGraph = new MyGraph();
		fillGraph(testGraph);
		for (Node outnode : testGraph.getVertices()) {
			outnode.setNodeType(typeColorCount+1);
		}
		Node bnode = null;
//		Set<Node> countOne = new HashSet<>();
//		Set<Node> countTwo = new HashSet<>();
		bnode = findBestNode(testGraph);
		bnode.setNodeType(1);
		bnode.setNodeVisited(true);
		try {
			Coloring(bnode, testGraph);
		} catch (Exception e) {
			System.out.println("Not Possible");
			e.printStackTrace();
			return;
		}
//		for (Node outnode : testGraph.getVertices()) {
//			if (outnode.getNodeType() == 1)
//				countOne.add(outnode);
//
//			if (outnode.getNodeType() == 2)
//				countTwo.add(outnode);
//		}
//		System.out.println("\n" + countOne.size());
//		for (Node outnode : countOne) {
//			System.out.println(outnode.getNodeName());
//		}
//		System.out.println("\n" + countTwo.size());
//		for (Node outnode : countTwo) {
//			System.out.println(outnode.getNodeName());
//		}
		for (Node outnode : testGraph.getVertices()) {
			System.out.println("\n" + outnode.getNodeType());
		}
	}

	private static void fillGraph(MyGraph testGraph) {
		Node node;
		int nodeID = 1;
		int edgeID = 1;
		Edge newEdge;
		// String[] sourceDest;

		try (Scanner scanner = new Scanner(System.in)) {
			int nodeCounts = scanner.nextInt();

			while (nodeCounts > 0) {
				node = new Node();
				node.setNodeID(nodeID);
				node.setNodeName(String.valueOf(node.getNodeID()));
				testGraph.addNode(node);
				nodeID++;
				nodeCounts--;
			}

			// System.out.println("\nHow many Edges?");
			int eCount = scanner.nextInt();

			typeColorCount = scanner.nextInt();

			// String[] edges = new String[eCount];
			int edgesSource = 0;
			int edgesDest = 0;
			for (int i = 0; i < eCount; i++) {
				edgesSource = scanner.nextInt();
				edgesDest = scanner.nextInt();
				// for (String edge : edges) {
				// sourceDest = edge.split("\\s");
				newEdge = new Edge(edgeID, testGraph.getNodeByName(edgesSource), testGraph.getNodeByName(edgesDest));
				edgeID++;
				testGraph.addEdge(newEdge);
				// }
			}
		}
	}

	private static Node findBestNode(MyGraph graph) {
		Node bnode = null;
		int max = -1;
		for (Node node : graph.getVertices()) {
			if (graph.getNodeDegree(node) > max && node.getNodeType() == typeColorCount+1) {
				max = graph.getNodeDegree(node);
				bnode = node;
			}
		}
		return bnode;
	}

	// private static void Consistancy(Node node, MyGraph graph) throws Exception {
	// // child haro peida kon Domain o mahdod kon
	// Set<Node> neighbours = graph.getNeighbours(node);
	// for (Node newnode : neighbours) {
	// if (newnode.getNodeDomain() == 3)
	// newnode.setNodeDomain(node.getNodeDomain() - node.getNodeType());
	// if (newnode.getNodeDomain() == node.getNodeType())
	// throw new Exception();
	// }
	//
	// }

	private static void Coloring(Node node, MyGraph graph) throws Exception {

		Set<Node> neighbours = graph.getNeighbours(node);
		for (Node newnode : neighbours) {
			if (!newnode.isNodeVisited()) {
				newnode.setNodeVisited(true);
				if (newnode.getNodeType() == typeColorCount+1)
					newnode.setNodeType(newnode.getNodeType() - node.getNodeType());
				Coloring(newnode, graph);
				for (Node newnewnode : neighbours) {
					if (newnewnode.getNodeType() == node.getNodeType())
						// if (neighbours.stream().anyMatch(a -> (a.getNodeType() ==
						// newnode.getNodeType() && (a.getNodeID() != newnode.getNodeID()))))
						throw new Exception();
				}
			}
		}
	}
}
