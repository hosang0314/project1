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
import java.sql.SQLException;

import com.biz.UserBiz;

public class Frame2 implements ActionListener {
	Frame frame;
	Panel panel1, panel2, panel3;
	Button button1;
	Label label1, label2, label3, label4, label5, label6, label7;
	TextField tf1, tf2;

	public Frame2() {
		frame = new Frame();
		panel1 = new Panel();
		panel2 = new Panel();
		panel3 = new Panel();
		button1 = new Button("회원가입");
		label1 = new Label("[영화. 보던지 말던지]에 접속하신 것을 환영합니다.");
		label2 = new Label("입력하신 ID는 없습니다. < 가입할 ID와 나이를 입력해 주세요. >");
		label3 = new Label("※주의 ! 사용자 부주의로 인한 피해는 전적으로 사용자가 해결해야 합니다.!");
		label4 = new Label("가입할 ID : ");
		label5 = new Label("  나  이    : ");
		label6 = new Label("@@ ID로 가입되셨습니다.");
		//label7 = new Label("또는 해당 아이디는 존재합니다.");
		tf1 = new TextField();
		tf2 = new TextField();
	}

	public void makeUi() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); // Frame 닫기 이벤트
			}
		});
		button1.addActionListener(this);

		frame.setSize(700, 600);
		frame.setLocation(200, 200);
		frame.setTitle("New Waves~");
		frame.setVisible(true);
		frame.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(new Color(173, 64, 61));

		// panel.setLayout(new GridLayout(1, 5));
		panel1.add(panel2);
		panel2.setLayout(null);
		panel2.setBounds(45, 35, 600, 100);
		panel2.setBackground(new Color(221, 221, 221));
		panel2.add(label1);
		label1.setBounds(10, 12, 300, 20);
		panel2.add(label2);
		label2.setBounds(10, 41, 600, 20);
		panel2.add(label3);
		label3.setBounds(10, 70, 700, 20);

		panel1.add(tf1);
		tf1.setBounds(280, 185, 130, 40);
		panel1.add(tf2);
		tf2.setBounds(280, 275, 130, 40);
		// tf1.setPreferredSize(new Dimension(80, 30));

		panel1.add(button1);
		button1.setBounds(450, 185, 130, 40);
		panel1.add(label4);
		label4.setBounds(175, 190, 130, 20);
		panel1.add(label5);
		label5.setBounds(175, 280, 130, 20);
		button1.setBackground(new Color(221, 221, 221));
		
		//
		panel1.add(panel3);
//		panel3.setBounds(45, 365, 600, 100);
//		panel3.setBackground(new Color(100, 100, 100));
		panel3.add(label6);
//		label6.setBounds(10, 12, 300, 20);
//		panel3.add(label7);
//		label7.setBounds(10, 41, 300, 20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame1 fr1 = new Frame1();
		if (e.getSource() == button1) {
			try {
				UserBiz biz = new UserBiz();
				biz.registerUser(tf1.getText(), Integer.parseInt(tf2.getText()));
				label6.setText("ID로 가입되셨습니다.");
			} catch (Exception f) {
				label6.setText("이미 가입된 ID 입니다.");
				f.getMessage();
			} 
			frame.dispose();
			fr1.makeUi();
		}
	}
}
