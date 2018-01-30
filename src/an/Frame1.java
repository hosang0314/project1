package an;


import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;

import com.biz.UserBiz;
import com.dao.UserDao;

public class Frame1 implements ActionListener{

	Frame frame;
	Panel panel1, panel2;
	Button button1, button2;
	Label label1, label2, label3, label4;
	TextField tf1;

	public Frame1() {
		frame = new Frame();
		panel1 = new Panel();
		panel2 = new Panel();
		button1 = new Button("로그인");
		button2 = new Button("회원가입");
		label1 = new Label("ID : ");
		label2 = new Label("[영화. 보던지 말던지] 에 접속하신 것을 환영합니다.");
		label3 = new Label("ID를 입력해 주세요");
		label4 = new Label("※주의! ID가 없는 경우 회원가입을 선택해 주세요.");
		tf1 = new TextField();
	}
	
	
	public void makeUi() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); // Frame 닫기 이벤트
			}
		});
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.setSize(700, 600);
		frame.setLocation(200, 200);
		frame.setTitle("New Waves");
		frame.setVisible(true);
		frame.add(panel1);
		
		panel1.setLayout(null);
		//panel.setLayout(new GridLayout(1, 5));
		//panel1.setBackground(new  Color(255, 21, 41));
		panel1.setBackground(new  Color(173, 64, 61));
		panel1.add(panel2);
		panel2.setLayout(null);
		panel2.setBounds(45, 35, 600, 100);
		panel2.setBackground(new Color(221, 221, 221));
		panel2.add(label2);
		label2.setBounds(10, 12, 300, 20);
		panel2.add(label3);
		label3.setBounds(10, 41, 300, 20);
		panel2.add(label4);
		label4.setBounds(10, 70, 300, 20);
		
		panel1.add(label1);
		label1.setBounds(205, 230, 30, 25);
		
		//tf1.setPreferredSize(new Dimension(80, 30));
		panel1.add(tf1);
		tf1.setBounds(250, 230, 130, 30);
		panel1.add(button1);
		button1.setBounds(405, 225, 130, 40);
		button1.setBackground(new Color(221, 221, 221));
		panel1.add(button2);
		button2.setBounds(520, 500, 130, 40);
		button2.setBackground(new Color(221, 221, 221));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {			
			try {
				UserBiz biz = new UserBiz();
				String id = biz.idCheck(tf1.getText());
				Frame3 f3 = new Frame3();
				f3.setId(id);
				app.login();
			} catch (Exception e1) {
				Frame2 f2 = new Frame2();
				f2.makeUi();
			} finally {
				
			}
			frame.dispose();
		}
		
		else if (e.getSource() == button2) {			
			app.join();
			frame.dispose();
		}
		
	}
}
