import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

	/**
	 * @param args
	 */
	static int soldierCounts;
	static int sumA;
	static int sumB;
	static int sumC;
	static ArrayList<Soldier> mainArray = new ArrayList<Soldier>();
	static ArrayList<Soldier> gAArray = new ArrayList<Soldier>();
	static ArrayList<Soldier> gBArray = new ArrayList<Soldier>();
	static ArrayList<Soldier> gCArray = new ArrayList<Soldier>();

	public static void main(String[] args) {

		fillArray();
		groupMarking();

		// has to commented in future
		printing();

	}

	private static void fillArray() {

		ArrayList<Integer> testArray = new ArrayList<Integer>();

		int soldierID = 1;
		int maxIndex = -1;
		int maxVal = -1;
		int maxGroupVal = -1;
		int maxGroupIndex = -1;
		int swap;

		try (Scanner scanner = new Scanner(System.in)) {
			soldierCounts = scanner.nextInt();

			for (int i = 0; i < soldierCounts; i++) {
				for (int j = 0; j < soldierCounts; j++) {
					swap = scanner.nextInt();
					testArray.add(swap);
					if (swap > maxVal) {
						maxVal = swap;
						maxIndex = j;
					}
				}
				for (int k = 0; k < 3; k++) {
					swap = scanner.nextInt();
					testArray.add(swap);
					if (swap > maxGroupVal) {
						maxGroupVal = swap;
						maxGroupIndex = soldierCounts + k;
					}
				}
				Soldier soldier = new Soldier(testArray, soldierID, maxIndex, maxGroupIndex);
				mainArray.add(soldier);
				soldierID++;

				// another Strategy for firstly fast grouping
				// if (maxGroupIndex == 601) {
				// gAArray.add(soldier);
				// } else if (maxGroupIndex == 602) {
				// gBArray.add(soldier);
				// } else {
				// gCArray.add(soldier);
				// }

			}
		}
	}

	private static void groupMarking() {

		ArrayList<Soldier> noGroup = new ArrayList<Soldier>();

		for (Soldier test : mainArray) {
			if (test.getGroupNum() == 0) {
				Soldier test2 = mainArray.get(test.getBestIndex());
				if (test2.getGroupNum() == 0 && test2.getBestGroupIndex() == test.getBestGroupIndex()) {
					if (test2.getBestGroupIndex() == soldierCounts) {
						gAArray.add(test);
						gAArray.add(test2);


					} else if (test2.getBestGroupIndex() == soldierCounts+1) {
						gBArray.add(test);
						gBArray.add(test2);
						
					} else {
						gCArray.add(test);
						gCArray.add(test2);
					}

					test.setGroupNum(test.getBestGroupIndex());
					test2.setGroupNum(test2.getBestGroupIndex());

				} else
					noGroup.add(test);
			}
		}

		sumGeneration();
		noGroupAnalysis(noGroup);

	}

	private static void noGroupAnalysis(ArrayList<Soldier> noGroup) {
		int swapA = 0;
		int swapB = 0;
		int swapC = 0;
		for (Soldier test : noGroup) {
			for (Soldier testA : gAArray) {
				swapA = swapA
						+ test.getScores().get(testA.getSoldierID() - 1) * test.getScores().get(testA.getGroupNum());
			}
			for (Soldier testA : gAArray) {
				swapB = swapB
						+ test.getScores().get(testA.getSoldierID() - 1) * test.getScores().get(testA.getGroupNum());
			}
			for (Soldier testA : gAArray) {
				swapC = swapC
						+ test.getScores().get(testA.getSoldierID() - 1) * test.getScores().get(testA.getGroupNum());
			}
			if (swapA > swapB && swapA > swapC) {
				test.setGroupNum(test.getScores().size() - 2);
				sumA = swapA + sumA;
			}
			if (swapB > swapA && swapB > swapC) {
				test.setGroupNum(test.getScores().size() - 1);
				sumB = swapB + sumB;
			}
			if (swapC > swapA && swapC > swapB) {
				test.setGroupNum(test.getScores().size());
				sumC = swapC + sumC;
			}
		}

	}

	private static void sumGeneration() {

		int sumtesti = 0;

		for (Soldier aA : gAArray) {
			for (Soldier aTest : gAArray) {
				sumA = sumA + aA.getScores().get(aTest.getSoldierID() - 1) * aA.getScores().get(aA.getGroupNum());
			}
		}
		for (Soldier aB : gBArray) {
			for (Soldier aTest : gBArray) {
				sumB = sumB + aB.getScores().get(aTest.getSoldierID() - 1) * aB.getScores().get(aB.getGroupNum());
			}
		}
		for (Soldier aC : gCArray) {
			for (Soldier aTest : gCArray) {
				sumC = sumC + aC.getScores().get(aTest.getSoldierID() - 1) * aC.getScores().get(aC.getGroupNum());
			}
		}

	}

	private static void printing() {

		System.out.println("A : " + sumA);
		System.out.println("B : " + sumB);
		System.out.println("C : " + sumC);

		for (Soldier printSol : mainArray) {
			System.out.println(printSol.getSoldierID());
			for (int printScore : printSol.getScores()) {
				System.out.println(printScore);
			}
			System.out.println("\n");
		}

	}
	// private static void newDA(ArrayList<Soldier> mainArray,ArrayList<Soldier>
	// gAArray,ArrayList<Soldier>gBArray,ArrayList<Soldier>gCArray) {
	//
	// ArrayList<Soldier> noGroup = new ArrayList<Soldier>();
	//
	// for (Soldier test : mainArray) {
	// if (test.getGroupNum() != 0)
	// continue;
	// Soldier test2 = mainArray.get(test.getBestIndex() + 1);
	// if (test2.getGroupNum() != 0 && test2.getBestGroupIndex() ==
	// test.getBestGroupIndex()) {
	// test.setGroupNum(test2.getBestGroupIndex());
	// test2.setGroupNum(test2.getBestGroupIndex());
	// }
	// else
	// noGroup.add(test);
	// }
	// for (Soldier test : noGroup) {
	// if (test.get)
	// }
	// }
}
