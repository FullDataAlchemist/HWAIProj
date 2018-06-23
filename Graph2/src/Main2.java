import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		ArrayList<Soldier> mainArray = new ArrayList<Soldier>();
		fillArray(mainArray);
		groupMarking(mainArray);
	}

	private static void fillArray(ArrayList<Soldier> mainArray) {

		ArrayList<Integer> testArray = new ArrayList<Integer>();

		int soldierID = 1;
		int maxIndex = 0;

		try (Scanner scanner = new Scanner(System.in)) {
			int soldierCounts = scanner.nextInt();
			int soldierScores = soldierCounts + 3;

			for (int i = 0; i < soldierCounts; i++) {
				for (int j = 0; j < soldierScores; j++) {
					testArray.add(j, scanner.nextInt());
					if (testArray.get(j)>maxIndex)
						maxIndex = testArray.get(j);
				}
				Soldier soldier = new Soldier(testArray, soldierID, maxIndex);
				mainArray.add(soldierID, soldier);
				soldierID++;
			}
		}
	}

	private static void groupMarking(ArrayList<Soldier> mainArray) {
		for (Soldier test : mainArray) {
			
		}
	}
}
