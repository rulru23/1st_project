package ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNum {

	private ArrayList<Integer> listNum = new ArrayList<Integer>();
	private int ballCount = 0;
	
	public RandomNum() {}
	
	public RandomNum(String level) {
		switch (level) {
		case "easy":
			this.ballCount = 3;
			break;
		case "normal":
			this.ballCount = 4;
			break;
		case "hard":
			this.ballCount = 5;
			break;
		default:
			this.ballCount = 0;
			break;
		}
	}

	public ArrayList<Integer> getListNum() {
		return listNum;
	}

	public void setListNum(ArrayList<Integer> listNum) {
		this.listNum = listNum;
	}
	
	public void clear() {
		listNum.clear();
	}
	
	public void setRandomNum() {
		
		int i = 0;
		while(i < this.ballCount) {
			int num = (int) (Math.random() * 9 + 1);
			
			if(!listNum.contains(num)) {
				listNum.add(num);
				i++;
			}
		}
	}

	@Override
	public String toString() {
		return "RandomNum [listNum=" + listNum + "]";
	}

	
}
