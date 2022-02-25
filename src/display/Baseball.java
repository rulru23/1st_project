package display;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Baseball extends JFrame {

	private Music introMusic;
	
	public static void main(String[] args) {

		new Baseball();
		
	}


	public Baseball() {
		
	//음악 시작
	introMusic = new Music("596556_davejf_melody-loop-130-bpm.wav", 10);
		
	this.getContentPane().setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c= getContentPane();
	
	//이미지
	ImageIcon img = new ImageIcon("image/page1.png");
	ImageIcon img1 = new ImageIcon("image/easy.png");
	ImageIcon img2 = new ImageIcon("image/normal.png");
	ImageIcon img3 = new ImageIcon("image/hard.png");
	getContentPane().setLayout(null);	
	

	
	
	//Easy
	JButton btnNewButton = new JButton(img1);	
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			introMusic.close();
			dispose();
			setVisible(false);
			new Easy().setVisible(true);			
		}
	});	
	
	getContentPane().add(btnNewButton);
	btnNewButton.setBounds(450,320,300,100);
	btnNewButton.setBorderPainted(false);
	btnNewButton.setContentAreaFilled(false);
	btnNewButton.setFocusPainted(false);
	
	
	//Normal
	JButton btnNewButton1 = new JButton(img2);
	btnNewButton1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			introMusic.close();
			dispose();
			setVisible(false);
			new Normal().setVisible(true);
			
		}
	});	
	
	getContentPane().add(btnNewButton1);
	btnNewButton1.setBounds(450,447,300,100);
	btnNewButton1.setBorderPainted(false);
	btnNewButton1.setContentAreaFilled(false);
	btnNewButton1.setFocusPainted(false);
	
	
	//Hard
	JButton btnNewButton2 = new JButton(img3);
	btnNewButton2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			introMusic.close();
			dispose();
			setVisible(false);
			new Hard().setVisible(true);
			
		}
	});
	
	getContentPane().add(btnNewButton2);
	btnNewButton2.setBounds(450,573,300,100);
	btnNewButton2.setBorderPainted(false);
	btnNewButton2.setContentAreaFilled(false);
	btnNewButton2.setFocusPainted(false);
	
	
	//배경
	JLabel imageLabel = new JLabel(img);
	imageLabel.setLocation(0, 0);

	c.add(imageLabel);
	imageLabel.setSize(1200,800);
	

	setSize(1200,830);
	this.setLocationRelativeTo(null); //화면 중간에서 뜨게하기 
	this.setResizable(false); //화면 고정크기
	this.setTitle("6조_숫자야구게임");
	
	setVisible(true);
	}

}