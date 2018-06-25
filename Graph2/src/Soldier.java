import java.util.ArrayList;

public class Soldier {
	
	
	private int groupNum = 0;
//	private int groupACount;
//	private int groupBCount;
//	private int groupCCount;
//	private int groupARemain;
//	private int groupBRemain;
//	private int groupCRemain;
	private int soldierID;
	private int bestIndex;
	private int bestGroupIndex;

	private ArrayList<Float> scores;

	public Soldier(ArrayList<Float> scores, int soldierID, int bestIndex, int bestGroupIndex ) {
		this.setScores(scores);
		this.setSoldierID(soldierID);
		this.setBestIndex(bestIndex);
		this.setBestGroupIndex(bestGroupIndex);
		// this is for newDA
		//this.setGroupNum(bestGroupIndex);
	}

	public ArrayList<Float> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Float> scores) {
		this.scores = scores;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public int getSoldierID() {
		return soldierID;
	}

	public void setSoldierID(int soldierID) {
		this.soldierID = soldierID;
	}

	public int getBestIndex() {
		return bestIndex;
	}

	public void setBestIndex(int bestScore) {
		this.bestIndex = bestScore;
	}

	public int getBestGroupIndex() {
		return bestGroupIndex;
	}

	public void setBestGroupIndex(int bestGroupIndex) {
		this.bestGroupIndex = bestGroupIndex;
	}


}
