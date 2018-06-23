import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		ArrayList<Integer> mainArray = new ArrayList<Integer>();
		mainArray = fillArray();
	}

	private static ArrayList fillArray() {
		ArrayList<ArrayList<Integer>> testArray = new ArrayList<ArrayList<Integer>>();

		// int soldierID = 1;

		try (Scanner scanner = new Scanner(System.in)) {
			int soldierCounts = scanner.nextInt();
			int soldierScores = soldierCounts + 3;
			
			// while (soldierCounts > 0) {
			// soldierID++;
			// soldierCounts--;
			// }

			for (int i = 0; i < soldierCounts; i++) {
				for (int j = 0; j < soldierScores; j++) {
					//testArray<i<j>> = scanner.nextInt();
				}
			}
		}
		return testArray;
	}
}
