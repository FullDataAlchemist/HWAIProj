import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

	/**
	 * @param args
	 */
	private static int typeColorCount = 0;

	public static void main(String[] args) {
	}

	private static void fillGraph(MyGraph testGraph) {
		int soldierID = 1;
		Edge newEdge;
		// String[] sourceDest;

		try (Scanner scanner = new Scanner(System.in)) {
			int soldierCounts = scanner.nextInt();

			while (soldierCounts > 0) {

				soldierID++;
				soldierCounts--;
			}

			// System.out.println("\nHow many Edges?");
			int soldierScores = soldierCounts + 3;
			for (int j = 0; j < soldierCounts; j++) {
				for (int i = 0; i < soldierScores; i++) {
				}
			}
		}
	}
}
