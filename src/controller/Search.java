package controller;

import java.util.ArrayList;

public class Search {

	private ArrayList<Integer> ciList = new ArrayList<Integer>();
	private ArrayList<Integer> rnList = new ArrayList<Integer>();
	int ballCount = 0;
	int strikeCount = 0;
	
	public Search() {}
	public Search(ArrayList<Integer> rn, ArrayList<Integer> ci) {
		this.ciList = ci;
		this.rnList = rn;
	}
	
	public ArrayList<Integer> getCiList() {
		return ciList;
	}
	public void setCiList(ArrayList<Integer> ciList) {
		this.ciList = ciList;
	}
	public ArrayList<Integer> getRnList() {
		return rnList;
	}
	public void setRnList(ArrayList<Integer> rnList) {
		this.rnList = rnList;
	}
	public int getBallCount() {
		return ballCount;
	}
	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}
	public int getStrikeCount() {
		return strikeCount;
	}
	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}
	
	public void clear() {
		this.strikeCount = 0;
		this.ballCount = 0;
		this.ciList.clear();
	}
	
	public String search() {
		
		for(int i = 0; i < rnList.size(); i++) {
			if(ciList.get(i).equals(rnList.get(i))) {
				this.strikeCount++;
				continue;
			}
			for(int j = 0; j < ciList.size(); j++) {
				if(ciList.get(j).equals(rnList.get(i))) {
					this.ballCount++;
				}
			}
		}
		
		if(strikeCount == this.rnList.size()) {
			return "\nHOMERUN!!!!!";
		}else if(strikeCount > 0 && ballCount > 0) {
			return "\n" + strikeCount + "스트라이크  " + ballCount + "볼!!";
		}else if(strikeCount == 0 && ballCount > 0) {
			return "\n" + ballCount + "볼!!";
		}else if(strikeCount > 0 && ballCount == 0){
			return "\n" + strikeCount + "스트라이크!!";
		}else {
			return "\n아웃~~~!!!";
		}

	}
	
}
