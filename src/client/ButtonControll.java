package client;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonControll {
	private ArrayList<JLabel> list;
	private ArrayList<JLabel> tmpList;
	private JButton[] btn;
	
	public ButtonControll() {}
	public ButtonControll(ArrayList<JLabel> list, JButton[] btn) {
		this.list = list;
		this.btn = btn;
		tmpList = new ArrayList<JLabel>();
	}
	
	public ArrayList<JLabel> getTmpList() {
		return tmpList;
	}
	public void setTmpList(ArrayList<JLabel> tmpList) {
		this.tmpList = tmpList;
	}
	public ArrayList<JLabel> getList() {
		return list;
	}
	public void setList(ArrayList<JLabel> list) {
		this.list = list;
	}
	public JButton[] getBtn() {
		return btn;
	}
	public void setBtn(JButton[] btn) {
		this.btn = btn;
	}
	
	public void disableButton() {
		btn[9].setEnabled(true);
		//System.out.println(btn[9]);
		for (int i = 0; i < btn.length - 1; i++) {
			btn[i].setEnabled(false);
		}
	}
	
	public void enableAll() {
		int size = tmpList.size();
		//System.out.println(btn[9]);
		for (int i = 0; i < btn.length; i++) {
			btn[i].setEnabled(true);
			if (i < size) {
				tmpList.get(0).setIcon(null);
				list.add(i, tmpList.remove(0));
			}
		}
	} 
	
	public void insertImage(ImageIcon icon) {
		if (list.get(0).getIcon() == null) {
			list.get(0).setIcon(icon);
			tmpList.add(list.remove(0));
		}  
		
	}
	
	
	

}
