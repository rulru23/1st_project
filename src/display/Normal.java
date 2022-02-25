package display;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ball.RandomNum;
import client.ButtonControll;
import client.ClientInput;
import controller.Music;
import controller.Search;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Normal extends JFrame {

	private JPanel contentPane;
	// 과거 결과값
	private JTextArea txt_scl;
	// 입력 값 라벨
	public JLabel ba1, ba2, ba3, ba4, textField;
	// 입력 버튼
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_result;
	
	private ArrayList<JLabel> list = new ArrayList<JLabel>();
	private JButton[] btn = new JButton[10];
	
	private int cnt = 0, diff = 0;
	private String str = "";
	
	private ButtonControll ts;
	private RandomNum rn = new RandomNum("normal");
	private ClientInput cl = new ClientInput();
	private Search s1 = new Search(rn.getListNum(), cl.getList());
	private JLabel homerun;
	private JLabel homerun2;
	
	private Music clikSound;
	private Music homerunSound;
	
	public void clikSound() {
		clikSound = new Music("534103_pbimal_mouse-click-single-00.wav", 0);
	}
	
	public void homerumSound() {
		homerunSound = new Music("413203_joepayne_clean-and-pompous-fanfare-trumpet.wav", 0);
	}


	public void insertLabel() {
		list.add(ba1);
		list.add(ba2);
		list.add(ba3);
		list.add(ba4);
	}
	
	public void insertButton() {
		btn[0] = btn1;
		btn[1] = btn2;
		btn[2] = btn3;
		btn[3] = btn4;
		btn[4] = btn5;
		btn[5] = btn6;
		btn[6] = btn7;
		btn[7] = btn8;
		btn[8] = btn9;
		btn[9] = btn_result;
	}
	
	public void pressControll(ImageIcon img, int num) {
		System.out.println("눌림");
		if (cnt < diff + 1) {
			if (cl.setList(num) == 0){
				JOptionPane.showMessageDialog(null, "중복값은 불가능 합니다.", "Error", JOptionPane.INFORMATION_MESSAGE);
			}else {
				ts.insertImage(img);
				cnt++;
			}
		}
		if (cnt == diff) {
			ts.disableButton();
			cnt++;
		}
	}

	public static void main(String[] args) {
		
		new Normal();
		
	}


	public Normal() {
		rn.setRandomNum();

		//이미지
		ImageIcon img5 = new ImageIcon("image/page3.png");
		ImageIcon img6 = new ImageIcon("image/homerun.png");
		
		ImageIcon b1 = new ImageIcon("btn/001.png");
		ImageIcon b2 = new ImageIcon("btn/002.png");
		ImageIcon b3 = new ImageIcon("btn/003.png");
		ImageIcon b4 = new ImageIcon("btn/004.png");
		ImageIcon b5 = new ImageIcon("btn/005.png");
		ImageIcon b6 = new ImageIcon("btn/006.png");
		ImageIcon b7 = new ImageIcon("btn/007.png");
		ImageIcon b8 = new ImageIcon("btn/008.png");
		ImageIcon b9 = new ImageIcon("btn/009.png");
		ImageIcon b_result = new ImageIcon("btn/result.png");
		ImageIcon b_restart = new ImageIcon("btn/restart.png");
		ImageIcon b_game = new ImageIcon("btn/game.png");
		ImageIcon b_back = new ImageIcon("btn/back.png");
		ImageIcon b_end = new ImageIcon("btn/end.png");
		getContentPane().setLayout(null);
		
		
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container aa= getContentPane();
		
		
		//자동생성값
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		homerun2 = new JLabel("Click Image to Restart");
		homerun2.setVisible(false);
		homerun2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		homerun2.setBounds(355, 515, 345, 64);
		contentPane.add(homerun2);
		
		homerun = new JLabel("");
		homerun.setIcon(img6);
		homerun.setVisible(false);
		homerun.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		s1.clear();
	        		str = "";
	              textField.setText("");
	              txt_scl.setText(str);
	        		homerun.setVisible(false);
	        		homerun2.setVisible(false);

	              rn.clear();
	              rn.setRandomNum();
	        	}
	       });
		homerun.setBounds(-2, 0, 1196, 791);
		contentPane.add(homerun);
		
		
		//숫자 4자리 
		ba1 = new JLabel();
		ba1.setBounds(48, 74, 150, 150);
		ba1.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(ba1);
		
		ba2 = new JLabel();
		ba2.setBounds(242, 74, 150, 150);
		ba2.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(ba2);
		
		ba3 = new JLabel();
		ba3.setBounds(438, 74, 150, 150);
		ba3.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(ba3);
		
		ba4 = new JLabel();
		ba4.setBounds(634, 74, 150, 150);
		ba4.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(ba4);
		
		
		// 1~9 버튼 
		btn1 = new JButton(b1);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b1, 1);
			}
		});
		btn1.setBounds(60, 607, 80, 75);
		ImageIcon rolloverIcon1 = new ImageIcon("btn/p001.png");
		btn1.setRolloverIcon(rolloverIcon1);
		contentPane.add(btn1);
		
		btn2 = new JButton(b2);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b2, 2);
			}
		});
		btn2.setBounds(140, 607, 80, 75);
		ImageIcon rolloverIcon2 = new ImageIcon("btn/p002.png");
		btn2.setRolloverIcon(rolloverIcon2);
		contentPane.add(btn2);
		
		btn3 = new JButton(b3);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b3, 3);
			}
		});
		btn3.setBounds(220, 607, 80, 75);
		ImageIcon rolloverIcon3 = new ImageIcon("btn/p003.png");
		btn3.setRolloverIcon(rolloverIcon3);
		contentPane.add(btn3);
		
		btn4 = new JButton(b4);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b4, 4);
			}
		});
		btn4.setBounds(300, 607, 80, 75);
		ImageIcon rolloverIcon4 = new ImageIcon("btn/p004.png");
		btn4.setRolloverIcon(rolloverIcon4);
		contentPane.add(btn4);
		
		btn5 = new JButton(b5);
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b5, 5);
			}
		});
		btn5.setBounds(380, 607, 80, 75);
		ImageIcon rolloverIcon5 = new ImageIcon("btn/p005.png");
		btn5.setRolloverIcon(rolloverIcon5);
		contentPane.add(btn5);
		
		btn6 = new JButton(b6);
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b6, 6);
			}
		});
		btn6.setBounds(460, 607, 80, 75);
		ImageIcon rolloverIcon6 = new ImageIcon("btn/p006.png");
		btn6.setRolloverIcon(rolloverIcon6);
		contentPane.add(btn6);
		
		btn7 = new JButton(b7);
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b7, 7);
			}
		});
		btn7.setBounds(540, 607, 80, 75);
		ImageIcon rolloverIcon7 = new ImageIcon("btn/p007.png");
		btn7.setRolloverIcon(rolloverIcon7);
		contentPane.add(btn7);
		
		btn8 = new JButton(b8);
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b8, 8);
			}
		});
		btn8.setBounds(620, 607, 80, 75);
		ImageIcon rolloverIcon8 = new ImageIcon("btn/p008.png");
		btn8.setRolloverIcon(rolloverIcon8);
		contentPane.add(btn8);
		
		btn9 = new JButton(b9);
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				pressControll(b9, 9);
			}
		});
		btn9.setBounds(700, 607, 80, 75);
		ImageIcon rolloverIcon9 = new ImageIcon("btn/p009.png");
		btn9.setRolloverIcon(rolloverIcon9);
		contentPane.add(btn9);
			

		
		// 결과보기 
		btn_result = new JButton(b_result);
		btn_result.setEnabled(false);
		btn_result.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

	            System.out.println("눌림");
	            String msg = "승리!";
	            
	            if (cl.getList().size() == s1.getRnList().size()) {
	
	            	clikSound();
	            	
	               String result = s1.search();
	               if(result.equals("\nHOMERUN!!!!!")) {
	            	   homerumSound();
	               }

	               str += s1.getCiList() + "\t" + result + "\n";
	               txt_scl.setText(str);
	               textField.setText(result);
	               
	               
	               
	               ts.enableAll();
	               btn_result.setEnabled(false);
	               cnt = 0;
	               
	               if (s1.getStrikeCount() == s1.getRnList().size()) {
	            	   
	                  System.out.println(txt_scl.getText());
	                  homerun.setVisible(true);
	                  homerun2.setVisible(true);
	                 
	               }s1.clear();
	            }
	            
	            
	            
	            System.out.println(s1.getRnList());
				
			}
		});
		btn_result.setBounds(339, 708, 159, 61);
		ImageIcon rolloverIcon_result = new ImageIcon("btn/p_result.png");
		
		
		// 스크롤 박스 
		txt_scl = new JTextArea();
		txt_scl.setFont(new Font("HY그래픽M", Font.BOLD, 17));
		txt_scl.setBounds(855, 67, 290, 430);
		txt_scl.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txt_scl);
		
		JScrollPane scrollPane = new JScrollPane(txt_scl);
		scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scrollPane.setBounds(855, 67, 290, 430);
		contentPane.add(scrollPane);
		
		
		// 한줄 텍스트 
		textField = new JLabel();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("HY그래픽M", Font.BOLD, 30));
		textField.setBounds(51, 355, 732, 143);
		contentPane.add(textField);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		
		//배경
		JLabel imageLabel2 = new JLabel(img5);
		imageLabel2.setBounds(-2, 0, 1186, 791);
		contentPane.add(imageLabel2);
		btn_result.setRolloverIcon(rolloverIcon_result);
		contentPane.add(btn_result);
		//btn_result.setOpaque(false);

		btn1.setBorderPainted(false); btn1.setFocusPainted(false);
		btn2.setBorderPainted(false); btn2.setFocusPainted(false);
		btn3.setBorderPainted(false); btn3.setFocusPainted(false);
		btn4.setBorderPainted(false); btn4.setFocusPainted(false);
		btn5.setBorderPainted(false); btn5.setFocusPainted(false);
		btn6.setBorderPainted(false); btn6.setFocusPainted(false);
		btn7.setBorderPainted(false); btn7.setFocusPainted(false);
		btn8.setBorderPainted(false); btn8.setFocusPainted(false);
		btn9.setBorderPainted(false); btn9.setFocusPainted(false);
		btn_result.setBorderPainted(false); btn_result.setFocusPainted(false);
	
		
		 
		// 다시시작 
		JButton restart = new JButton(b_restart);
		restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				System.out.println("눌림");
				ts.enableAll();
				cnt = 0;
				btn_result.setEnabled(false);
				s1.clear();
			}
		});
		restart.setBounds(817, 619, 153, 60);
		contentPane.add(restart);
		restart.setOpaque(false);
		
		
		// 게임설명
		JButton t_game = new JButton(b_game);
		t_game.setBounds(849, 12, 90, 30);
		t_game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				JOptionPane.showMessageDialog(null,"1. 볼 (Ball) : 숫자가 포함되어 있고, 위치가 다른 경우\n"
						+ "2. 스트라이크 (Strike) : 숫자가 포함되어 있고, 위치가 같은 경우\n"
						+ "3. 홈런 (HomeRun) : 모든 숫자와 위치가 같은 경우","게임설명",1,null);
			}
		});
		contentPane.add(t_game);
		t_game.setOpaque(false);
		
		
		// 뒤로가기 
		JButton btn_back = new JButton(b_back);
		btn_back.setBounds(959, 12, 90, 30);
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				dispose();
				setVisible(false);
				new Baseball().setVisible(true);
			}
		});
		contentPane.add(btn_back);
		btn_back.setOpaque(false);
		
		
		// 종료하기 
		JButton btn_end = new JButton(b_end);
		btn_end.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				int num = JOptionPane.showConfirmDialog(null, "종료 하시나요??", "종료", JOptionPane.YES_NO_OPTION);
				if (num == 0) {
					System.exit(0);
				}
			}
		});
		btn_end.setBounds(1065, 12, 90, 30);
		contentPane.add(btn_end);
		btn_end.setOpaque(false);
		
		this.setSize(1200,830);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Normal mode");
		
		setVisible(true);
		
		insertLabel();
		insertButton();
		
		ts = new ButtonControll(list, btn);
		diff = list.size();
		
	}
}
