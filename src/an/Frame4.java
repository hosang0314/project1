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
import java.sql.SQLException;
import java.util.ArrayList;

import com.biz.UserBiz;
import com.vo.MovieVO;
import com.vo.TimetableVO;
import com.vo.UserVO;

public class Frame4 implements ActionListener {
	Frame frame;
	Panel panel1, panel2;
	Button button1;
	Label label1, label2;
	List list, movieidlist;
	static ArrayList<MovieVO> movies;
	String gname;
	int num;
	
	
	public ArrayList<MovieVO> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<MovieVO> movies) {
		this.movies = movies;
	}

	public Frame4() {
		frame = new Frame();
		panel1 = new Panel();
		panel2 = new Panel();
		button1 = new Button("선택");	
		label1 = new Label("관람하실 영화를 선택하세요.");
		//label2 = new Label("현재 @@ 등급 @@ 장르 상영중인 영화 입니다.");
		list = new List();
		movieidlist = new List();
		
	}

	public void makeUi() {
		
		for(MovieVO m : movies) {
			String m1 = m.getTitle();
			String m2 = m.getId();
			list.add(m1);			
			movieidlist.add(m2);
		}
		Frame5 fr5 = new Frame5();
		/*num = movieidlist.getSelectedIndex();
		fr5.setTitle(movies.get(num).getTitle());*/
		gname = getMovies().get(0).getGenre();
		label2 = new Label("현재 장르 <"+gname+"> 상영중인 영화 입니다.");
		
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
		panel2.add(label1);
		label1.setBounds(10, 12, 300, 20);
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
			UserBiz biz = null;
			Frame5 fr5 = null;
			ArrayList<TimetableVO> times;	
			try {
				biz = new UserBiz();
				fr5 = new Frame5();
				int num = list.getSelectedIndex();
				//선택된 영화VO의 영화 ID를 가져와서 times에 넣습니다
				times = biz.SelectMoiveTime(movieidlist.getItem(num));
				fr5.setLink(getMovies().get(num).getHyperLink());
				fr5.setTimes(times);
				frame.dispose();
				fr5.makeUi();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
						
			
			
			
		} 
	}
}
