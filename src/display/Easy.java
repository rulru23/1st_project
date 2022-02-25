package display;

import java.awt.Color;
import javax.swing.border.Border;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ball.RandomNum;
import client.ButtonControll;
import client.ClientInput;
import controller.Music;
import controller.Search;


public class Easy extends JFrame {
	
	private JPanel contentPane;
	// ���� �����
	private JTextArea txt_scl;
	// �Է� �� ��
	public JLabel ba1, ba2, ba3, textField, homerun, homerun2;
	// �Է� ��ư
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_result;
	
	private ArrayList<JLabel> list = new ArrayList<JLabel>();
	private JButton[] btn = new JButton[10];
	
	private int cnt = 0, diff = 0;
	private String str = "";
	
	private ButtonControll ts;
	private RandomNum rn = new RandomNum("easy");
	private ClientInput cl = new ClientInput();
	private Search s1 = new Search(rn.getListNum(), cl.getList());
	
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
		System.out.println("����");
		if (cnt < diff + 1) {
			if (cl.setList(num) == 0){
				JOptionPane.showMessageDialog(null, "�ߺ����� �Ұ��� �մϴ�.", "Error", JOptionPane.INFORMATION_MESSAGE);
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
		
		new Easy();
		
		}

	/**
	 * Create the frame.
	 */
	public Easy() {
		rn.setRandomNum();

		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		Container a = getContentPane();
		
		//�̹���
		ImageIcon img4 = new ImageIcon("image/page2.png");	
		ImageIcon img5 = new ImageIcon("image/homerun.png");
		
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
		
		//�ڵ�������
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
		homerun.setIcon(img5);
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
		homerun.setBounds(0, 0, 1194, 791);
		contentPane.add(homerun);
		
		
		//���ڸ�����		
		ba1 = new JLabel("");
		ba1.setBounds(113, 50, 217, 217);
		contentPane.add(ba1);
		
		ba3 = new JLabel("");
		ba3.setBounds(640, 50, 217, 217);
		contentPane.add(ba3);
		
		ba2 = new JLabel("");
		ba2.setBounds(380, 50, 217, 217);
		contentPane.add(ba2);
		
		//1~9 ��ư 
		
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
		
		
		//������� (Enter)
		btn_result = new JButton(b_result);
		btn_result.setEnabled(false);
		btn_result.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

	            System.out.println("����");
	            String msg = "�¸�!";
	            
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
		btn_result.setBounds(340, 707, 159, 61);
		ImageIcon rolloverIcon_result = new ImageIcon("btn/p_result.png");
		

		//��ũ�ѹڽ� : ���� ���
		txt_scl = new JTextArea();
		txt_scl.setFont(new Font("HY�׷���M", Font.BOLD, 17));
		txt_scl.setBounds(855, 60, 290, 440);
		txt_scl.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JScrollPane scrollPane = new JScrollPane(txt_scl);
		scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scrollPane.setBounds(855, 60, 290, 440);
		contentPane.add(scrollPane);
		

		
		//���� �ؽ�Ʈ : ���� �� Result
		textField = new JLabel();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("HY�׷���M", Font.BOLD, 30));
		textField.setBounds(52, 360, 732, 143);
		contentPane.add(textField);
		//textField.setColumns(10);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		
		
		//��� 
		JLabel imageLabel1 = new JLabel(img4);		
		imageLabel1.setBounds(0, 0, 1184, 791);
		contentPane.add(imageLabel1);		
		btn_result.setRolloverIcon(rolloverIcon_result);
		contentPane.add(btn_result);
		
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
		
		
		//�ٽý��� (�ʱ�ȭ)
		JButton restart = new JButton(b_restart);
		restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				System.out.println("����");
				ts.enableAll();
				cnt = 0;
				btn_result.setEnabled(false);
				s1.clear();
				
			}
		});
		restart.setBounds(825, 613, 153, 60);
		
		contentPane.add(restart);
		restart.setOpaque(false);
		
		
		//���Ӽ���
		JButton game = new JButton(b_game);		
		game.setBounds(855, 6, 90, 30);
		contentPane.add(game);
		game.setOpaque(false);
		game.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				JOptionPane.showMessageDialog(null,"1. �� (Ball) : ���ڰ� ���ԵǾ� �ְ�, ��ġ�� �ٸ� ���\n"
						+ "2. ��Ʈ����ũ (Strike) : ���ڰ� ���ԵǾ� �ְ�, ��ġ�� ���� ���\n"
						+ "3. Ȩ�� (HomeRun) : ��� ���ڿ� ��ġ�� ���� ���","���Ӽ���",1,null);
				
			}			
		});
		
		
		
		//�ڷΰ���
		JButton back = new JButton(b_back);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clikSound();
				dispose();
				setVisible(false);
				new Baseball().setVisible(true);
			}
		});
		back.setBounds(959, 6, 90, 30);
		contentPane.add(back);
		back.setOpaque(false);
		
		
		//�����ϱ�
		JButton end = new JButton(b_end);
		end.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clikSound();
				
				int num = JOptionPane.showConfirmDialog(null, "���� �Ͻó���??", "����", JOptionPane.YES_NO_OPTION);
				if (num == 0) {
					num = JOptionPane.showConfirmDialog(null, "������ ������ ���� �Ͻó���???", "����2", JOptionPane.YES_NO_OPTION);
					if (num == 0) {
						JOptionPane.showMessageDialog(null,"�ȳ��� ������" , "�ȳ��� ������", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				}
				JOptionPane.showMessageDialog(null,"�� �����ؼ̽��ϴ�!" , "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		end.setBounds(1066, 6, 90, 30);
		contentPane.add(end);
		end.setOpaque(false);		
		
		this.setSize(1200,830);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Easy mode");
		
		setVisible(true);
		
		insertLabel();
		insertButton();
		
		ts = new ButtonControll(list, btn);
		diff = list.size();
		
		
	}
}
