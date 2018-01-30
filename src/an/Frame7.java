package an;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.HyperlinkEvent;

public class Frame7 implements ActionListener {
	Frame frame;
	Panel panel1, panel2;
	Button button1;
	Label label1, label2, label3;
	String link ;

	public Frame7() {
		frame = new Frame();
		panel1 = new Panel();
		panel2 = new Panel();
		button1 = new Button("나가");
		label1 = new Label("[영화. 보던지 말던지]를 이용해 주셔서 감사합니다.");
		label2 = new Label("앞으로도 좋은 정보와 서비스를 제공할 것을 약속 드리겠습니다.");
		label3 = new Label("= 유박정윤 일동 =");
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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
		frame.setTitle("New Waves~~~");
		frame.setVisible(true);
		frame.add(panel1);
		panel1.setLayout(null);
		panel1.setBackground(new Color(173, 64, 61));

		// panel.setLayout(new GridLayout(1, 5));
		panel1.add(panel2);
		panel2.setLayout(null);
		panel2.setBounds(45, 200, 600, 100);
		panel2.setBackground(new Color(221, 221, 221));
		panel2.add(label1);
		label1.setBounds(10, 12, 300, 20);
		panel2.add(label2);
		label2.setBounds(10, 41, 700, 20);
		panel2.add(label3);
		label3.setBounds(10, 70, 700, 20);

		// tf1.setPreferredSize(new Dimension(80, 30));

		panel1.add(button1);
		button1.setBounds(280, 360, 130, 40);
		button1.setBackground(new Color(221, 221, 221));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			
			frame.dispose();
		
	}}
}
