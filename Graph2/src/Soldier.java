import java.util.ArrayList;

public class Soldier {
	
	
	private int groupNum;
	private int groupACount;
	private int groupBCount;
	private int groupCCount;
	private int groupARemain;
	private int groupBRemain;
	private int groupCRemain;
	
	private ArrayList<Integer> scores;

	Soldier(ArrayList<Integer> scores) {
		this.setScores(scores);
	}

	public ArrayList<Integer> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Integer> scores) {
		this.scores = scores;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}
	
	public int getGroupACount() {
		return groupACount;
	}

	public void setGroupACount(int groupACount) {
		this.groupACount = groupACount;
	}

	public int getGroupBCount() {
		return groupBCount;
	}

	public void setGroupBCount(int groupBCount) {
		this.groupBCount = groupBCount;
	}

	public int getGroupCCount() {
		return groupCCount;
	}

	public void setGroupCCount(int groupCCount) {
		this.groupCCount = groupCCount;
	}

	public int getGroupARemain() {
		return groupARemain;
	}

	public void setGroupARemain(int groupARemain) {
		this.groupARemain = groupARemain;
	}

	public int getGroupBRemain() {
		return groupBRemain;
	}

	public void setGroupBRemain(int groupBRemain) {
		this.groupBRemain = groupBRemain;
	}

	public int getGroupCRemain() {
		return groupCRemain;
	}

	public void setGroupCRemain(int groupCRemain) {
		this.groupCRemain = groupCRemain;
	}


}
