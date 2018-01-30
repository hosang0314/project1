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
import java.sql.SQLException;
import java.util.ArrayList;

import com.biz.UserBiz;
import com.vo.MovieVO;

public class Frame3 implements ActionListener{
	
	Frame frame;
	Panel panel1, panel2;
	Button button1, button2, button3, button4, button5, button6;
	Label label1, label2, label3;
	static String id ;

	public Frame3() {
		frame = new Frame();
		panel1 = new Panel();
		panel2 = new Panel();
		button1 = new Button("�ִϸ��̼�");
		button3 = new Button("�׼�");
		button5 = new Button("��庥ó");
		button2 = new Button("���");
		button4 = new Button("��ť���͸�");
		button6 = new Button("�θǽ�");
		//label1 = new Label("�Է��Ͻ� ���̵�� �̴̰ϴ� -- �Լ��� �츰������.");
		label2 = new Label("�����Ͻ� �帣�� �������ּ���.");
		label3 = new Label("������ ! �ɽ��� ���� ������ 4D��ȭ ������ �ﰡ�ּ���.");
		id = this.getId();
		label1 = new Label(id+" ���̵�� �α��� �Ǽ̽��ϴ� ");
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void makeUi() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose(); // Frame �ݱ� �̺�Ʈ
			}
		});
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);

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
		label2.setBounds(10, 40, 300, 20);
		panel2.add(label3);
		label3.setBounds(10, 68, 600, 20);
		// tf1.setPreferredSize(new Dimension(80, 30));

		panel1.add(button1);
		button1.setBounds(60, 170, 240, 75);
		panel1.add(button3);
		button3.setBounds(60, 270, 240, 75);
		panel1.add(button5);
		button5.setBounds(60, 370, 240, 75);
		panel1.add(button2);
		button2.setBounds(385, 170, 240, 75);
		panel1.add(button4);
		button4.setBounds(385, 270, 240, 75);
		panel1.add(button6);
		button6.setBounds(385, 370, 240, 75);
		button1.setBackground(new Color(221, 221, 221));
		button2.setBackground(new Color(221, 221, 221));
		button3.setBackground(new Color(221, 221, 221));
		button4.setBackground(new Color(221, 221, 221));
		button5.setBackground(new Color(221, 221, 221));
		button6.setBackground(new Color(221, 221, 221));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UserBiz biz;
		Frame4 fr4 = new Frame4();
		
		 ArrayList<MovieVO> movies;
		if (e.getSource() == button1) {
			try {
				biz = new UserBiz();
				try {
					movies = biz.ganreSelectMoives("�ִϸ��̼�");
					fr4.setMovies(movies);					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			frame.dispose();
			fr4.makeUi();
		} else if (e.getSource() == button2) {
			try {
				biz = new UserBiz();
				try {
					movies =  biz.ganreSelectMoives("���");
					fr4.setMovies(movies);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
			fr4.makeUi();
		} else if (e.getSource() == button3) {
			try {
				biz = new UserBiz();
				try {
					movies = biz.ganreSelectMoives("�׼�");
					fr4.setMovies(movies);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
			fr4.makeUi();
		} else if (e.getSource() == button4) {
			try {
				biz = new UserBiz();
				try {
					movies =  biz.ganreSelectMoives("��ť���͸�");
					fr4.setMovies(movies);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
			fr4.makeUi();
		} else if (e.getSource() == button5) {
			try {
				biz = new UserBiz();
				try {
					movies = biz.ganreSelectMoives("��庥��");
					fr4.setMovies(movies);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
			fr4.makeUi();
		} else if (e.getSource() == button6) {
			try {
				biz = new UserBiz();
				try {
					movies = biz.ganreSelectMoives("�θǽ�");
					fr4.setMovies(movies);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
			fr4.makeUi();
		}
	}

}

