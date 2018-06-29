import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

	/**
	 * @param args
	 */
	static int soldierCounts;
	static float sumA;
	static float sumB;
	static float sumC;
	static long startTime;
	static ArrayList<Soldier> mainArray = new ArrayList<>();
	static ArrayList<Soldier> gAArray = new ArrayList<>();
	static ArrayList<Soldier> gBArray = new ArrayList<>();
	static ArrayList<Soldier> gCArray = new ArrayList<>();

	public static void main(String[] args) {

		fillArray();
		startTime = System.nanoTime();
		groupMarking();
		printing();
	}

	private static void fillArray() {
		ArrayList<Float> testArray = new ArrayList<>();

		int soldierID = 1;
		int maxIndex = -1;
		float maxVal = -1;
		float maxGroupVal = -1;
		int maxGroupIndex = -1;
		float swap;

		try (Scanner scanner = new Scanner(System.in)) {
			soldierCounts = scanner.nextInt();

			for (int i = 0; i < soldierCounts; i++) {
				testArray = new ArrayList<>();
				for (int j = 0; j < soldierCounts; j++) {
					swap = scanner.nextFloat();
					testArray.add(swap);
					// finding maximum value for each soldier
					if (swap > maxVal) {
						maxVal = swap;
						maxIndex = j;
					}
				}
				for (int k = 0; k < 3; k++) {
					swap = scanner.nextFloat();
					testArray.add(swap);
					if (swap > maxGroupVal) {
						maxGroupVal = swap;
						maxGroupIndex = soldierCounts + k;
					}
				}
				Soldier soldier = new Soldier(testArray, soldierID, maxIndex, maxGroupIndex);
				mainArray.add(soldier);
				soldierID++;
			}

		}
	}

	private static void groupMarking() {

		ArrayList<Soldier> noGroup = new ArrayList<>();
		Soldier test2 = null;

		for (Soldier test : mainArray) {
			if (test.getGroupNum() == 0) {
				test2 = mainArray.get(test.getBestIndex());
				if (test2.getGroupNum() == 0 && test2.getBestGroupIndex() == test.getBestGroupIndex()) {
					if (test2.getBestGroupIndex() == soldierCounts) {
						gAArray.add(test);
						gAArray.add(test2);
					} else if (test2.getBestGroupIndex() == soldierCounts + 1) {
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
		float swapA = 0;
		float swapB = 0;
		float swapC = 0;
		int itrator = 0;
		for (Soldier test : noGroup) {
			itrator++;
			for (Soldier testA : gAArray) {
				swapA = swapA + test.getScores().get(testA.getSoldierID() - 1)
						* test.getScores().get(testA.getBestGroupIndex());
			}
			for (Soldier testB : gBArray) {
				swapB = swapB + test.getScores().get(testB.getSoldierID() - 1)
						* test.getScores().get(testB.getBestGroupIndex());
			}
			for (Soldier testC : gCArray) {
				swapC = swapC + test.getScores().get(testC.getSoldierID() - 1)
						* test.getScores().get(testC.getBestGroupIndex());
			}
			scoreAnalysis(swapA, swapB, swapC, test, noGroup.size() - itrator);
		}
	}

	private static void scoreAnalysis(float swapA, float swapB, float swapC, Soldier test, int counter) {
		if (counter > 5) {
			if (swapA > swapB && swapA > swapC) {
				test.setGroupNum(test.getScores().size() - 2);
				test.setBestGroupIndex(test.getScores().size() - 2);
				sumA = swapA + sumA;
				gAArray.add(test);
			} else if (swapB > swapA && swapB > swapC) {
				test.setGroupNum(test.getScores().size() - 1);
				test.setBestGroupIndex(test.getScores().size() - 1);
				sumB = swapB + sumB;
				gBArray.add(test);
			} else if (swapC > swapA && swapC > swapB) {
				test.setGroupNum(test.getScores().size());
				test.setBestGroupIndex(test.getScores().size());
				sumC = swapC + sumC;
				gCArray.add(test);
			} else if (test.getBestGroupIndex() == test.getScores().size() - 2) {
				test.setGroupNum(test.getBestGroupIndex());
				sumA += swapA;
				gAArray.add(test);
			} else if (test.getBestGroupIndex() == test.getScores().size() - 1) {
				test.setGroupNum(test.getBestGroupIndex());
				sumB += swapB;
				gBArray.add(test);

			} else if (test.getBestGroupIndex() == test.getScores().size()) {
				test.setGroupNum(test.getBestGroupIndex());
				sumC += swapC;
				gCArray.add(test);
			}
		} else {
			if (swapA >= swapB && swapA >= swapC) {
				if (gAArray.size() % 6 != 0) {
					test.setGroupNum(test.getScores().size() - 2);
					test.setBestGroupIndex(test.getScores().size() - 2);
					sumA = swapA + sumA;
					gAArray.add(test);
				} else
					swapA = 0;
			} else if (swapB >= swapA && swapB >= swapC) {
				if (gBArray.size() % 6 != 0) {
					test.setGroupNum(test.getScores().size() - 1);
					test.setBestGroupIndex(test.getScores().size() - 1);
					sumB = swapB + sumB;
					gBArray.add(test);
				} else
					swapB = 0;
			} else if (swapC >= swapA && swapC >= swapB) {
				if (gCArray.size() % 6 != 0) {
					test.setGroupNum(test.getScores().size());
					test.setBestGroupIndex(test.getScores().size());
					sumC = swapC + sumC;
					gCArray.add(test);
				}
			}
		}
	}

	private static void sumGeneration() {
		for (Soldier aA : gAArray)
			for (Soldier aTest : gAArray)
				sumA = sumA + aA.getScores().get(aTest.getSoldierID() - 1) * aA.getScores().get(aA.getBestGroupIndex());

		for (Soldier aB : gBArray)
			for (Soldier aTest : gBArray)
				sumB = sumB + aB.getScores().get(aTest.getSoldierID() - 1) * aB.getScores().get(aB.getBestGroupIndex());

		for (Soldier aC : gCArray)
			for (Soldier aTest : gCArray)
				sumC = sumC + aC.getScores().get(aTest.getSoldierID() - 1) * aC.getScores().get(aC.getBestGroupIndex());

	}
	

	private static void printing() {
		System.out.println("A : " + (gAArray.size() / 6) + " : " + sumA / 2);
		System.out.println("B : " + (gBArray.size() / 6) + " : " + sumB / 2);
		System.out.println("C : " + (gCArray.size() / 6) + " : " + sumC / 2);

		// System.out.print("GAArray : \n");
		// for (Soldier printSol : gAArray) {
		// System.out.print(printSol.getSoldierID() + "\t");
		// for (float printScore : printSol.getScores())
		// System.out.print(printScore + "\t");
		//
		// System.out.println("\n");
		// }

		// System.out.print("GBArray : \n");
		// for (Soldier printSol : gBArray) {
		// System.out.print(printSol.getSoldierID() + "\t");
		// for (float printScore : printSol.getScores())
		// System.out.print(printScore + "\t");
		//
		// System.out.println("\n");
		// }

		// System.out.print("GCArray : \n");
		// for (Soldier printSol : gCArray) {
		// System.out.print(printSol.getSoldierID() + "\t");
		// for (float printScore : printSol.getScores())
		// System.out.print(printScore + "\t");
		//
		// System.out.println("\n");
		// }
		// long endTime = System.nanoTime();
		// long totalTime = endTime - startTime;
		// System.out.println(totalTime);
	}
}
