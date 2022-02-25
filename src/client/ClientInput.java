package client;

import java.util.ArrayList;

public class ClientInput {
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	public ClientInput() {}

	public ArrayList<Integer> getList() {
		return list;
	}

	public int setList(int num) {
		if (list.contains(num)) {
			return 0;
		}else {
			list.add(num);
			return 1;
		}
	}
	
	public void clearList() {
		list.clear();
	}

	@Override
	public String toString() {
		return "ClientInput [list=" + list + "]";
	}
	
	
}
