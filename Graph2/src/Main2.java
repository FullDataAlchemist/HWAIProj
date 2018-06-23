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

	public static void main(String[] args) {

		ArrayList<Soldier> mainArray = new ArrayList<Soldier>();
		ArrayList<Soldier> gAArray = new ArrayList<Soldier>();
		ArrayList<Soldier> gBArray = new ArrayList<Soldier>();
		ArrayList<Soldier> gCArray = new ArrayList<Soldier>();

		fillArray(mainArray, gAArray, gBArray, gCArray);
		groupMarking(mainArray, gAArray, gBArray, gCArray);
		System.out.println("A : " + sumA);
		System.out.println("B : " + sumB);
		System.out.println("C : " + sumC);

	}

	private static void fillArray(ArrayList<Soldier> mainArray, ArrayList<Soldier> gAArray, ArrayList<Soldier> gBArray,
			ArrayList<Soldier> gCArray) {

		ArrayList<Integer> testArray = new ArrayList<Integer>();

		int soldierID = 1;
		int maxIndex = -1;
		int maxVal = -1;
		int maxGroupVal = -1;
		int maxGroupIndex = -1;
		try (Scanner scanner = new Scanner(System.in)) {
			soldierCounts = scanner.nextInt();

			for (int i = 0; i < soldierCounts; i++) {
				for (int j = 0; j < soldierCounts; j++) {
					int swap = scanner.nextInt();
					testArray.add(swap);
					if (swap > maxVal) {
						maxVal = swap;
						maxIndex = j;
					}
				}
				for (int k = 0; k < 3; k++) {
					int swap = scanner.nextInt();
					testArray.add(swap);
					if (swap > maxGroupVal) {
						maxGroupVal = swap;
						maxGroupIndex = soldierCounts + k;
					}
				}
				Soldier soldier = new Soldier(testArray, soldierID, maxIndex, maxGroupIndex);
				// if (maxGroupIndex == 601) {
				// gAArray.add(soldier);
				// } else if (maxGroupIndex == 602) {
				// gBArray.add(soldier);
				// } else {
				// gCArray.add(soldier);
				// }
				mainArray.add(soldier);
				soldierID++;
			}
		}
	}

	private static void groupMarking(ArrayList<Soldier> mainArray, ArrayList<Soldier> gAArray,
			ArrayList<Soldier> gBArray, ArrayList<Soldier> gCArray) {
		int sumtesti = 0;
		int swapA = 0;
		int swapB = 0;
		int swapC = 0;
		ArrayList<Soldier> noGroup = new ArrayList<Soldier>();

		for (Soldier test : mainArray) {
			if (test.getGroupNum() != 0)
				continue;
			Soldier test2 = mainArray.get(test.getBestIndex() + 1);
			if (test2.getGroupNum() != 0 && test2.getBestGroupIndex() == test.getBestGroupIndex()) {
				if (test2.getBestGroupIndex() == 601) {
					gAArray.add(test);
					gAArray.add(test2);

				} else if (test2.getBestGroupIndex() == 602) {
					gBArray.add(test);
					gBArray.add(test2);
				} else {
					gCArray.add(test);
					gCArray.add(test2);
				}

				test.setGroupNum(test2.getBestGroupIndex());
				test2.setGroupNum(test2.getBestGroupIndex());

			} else
				noGroup.add(test);
		}
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
