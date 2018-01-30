package an;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import com.dao.MovieDao;
import com.vo.MovieVO;
import com.vo.TimetableVO;

public class Frame5 implements ActionListener{
	Frame frame;
	Panel panel1, panel2;
	Button button1;
	Label label1, label2;
	List list;
	ArrayList<TimetableVO> times;
	static String mname;
	static String title;
	String link;

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Frame5.title = title;
	}

	public ArrayList<TimetableVO> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<TimetableVO> times) {
		this.times = times;
	}
	
	
	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Frame5() {
		frame = new Frame();
		panel1 = new Panel();
		panel2 = new Panel();
		button1 = new Button("예약");
		//label1 = new Label("현재 선택하신 영화는 @@@입니다.");
		label2 = new Label("관람하실 시간을 선택해 주세요");
		list = new List();
	}

	public void makeUi() {		
		
		for(TimetableVO t: times) {
			String m1 = t.getTime();
			String m2 = m1.substring(0, 4)+"년 "+m1.substring(4, 6)+"월 "+m1.substring(6, 8)+"일 "+
					    m1.substring(8, 10)+"시 "+m1.substring(10, 12)+"분 ";
			list.add(m2);			
		}
		
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
		panel2.setBounds(45, 35, 600, 100);
		panel2.setBackground(new Color(221, 221, 221));
		//panel2.add(label1);
		//label1.setBounds(10, 12, 300, 20);
		panel2.add(label2);
		label2.setBounds(10, 41, 300, 20);

		// tf1.setPreferredSize(new Dimension(80, 30));

		panel1.add(button1);
		button1.setBounds(50, 160, 130, 40);
		button1.setBackground(new Color(221, 221, 221));
		
		panel1.add(list);
		list.setBounds(45, 220, 600, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			Frame6 fr6 = new Frame6();
			fr6.setLink(getLink());
			fr6.setMoviename(list.getSelectedItem());
			fr6.makeUi();
			frame.dispose();
		
	}}
}
