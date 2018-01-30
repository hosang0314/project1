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

public class Frame6 implements ActionListener {
	Frame frame;
	Panel panel1, panel2;
	Button button1;
	Label label1, label2;
	String moviename;
	String link;
	
	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Frame6() {
		frame = new Frame();
		panel1 = new Panel();
		panel2 = new Panel();
		button1 = new Button("확인");
		label1 = new Label("@@@영화 날짜 : ???, 시간 : ??? 으로 예약되셨습니다.");
		label2 = new Label("즐거운 관람 되세요!");
		String moviename= this.getMoviename();
		
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
		label1.setText(moviename+"으로 예약되셨습니다.");
		panel2.add(label1);
		label1.setBounds(10, 12, 300, 20);
		panel2.add(label2);
		label2.setBounds(10, 70, 700, 20);

		// tf1.setPreferredSize(new Dimension(80, 30));

		panel1.add(button1);
		button1.setBounds(280, 360, 130, 40);
		button1.setBackground(new Color(221, 221, 221));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			Frame7 fr7 = new Frame7();
			fr7.setLink(getLink());
			fr7.makeUi();
			frame.dispose();
		
	}}
}
