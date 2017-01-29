package org.teipir.softeng.hrms;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Help1 extends JFrame implements ActionListener {
	public TextArea t;
	public Font g;
	public JButton b;
	public JLabel l1;
	public JPanel panel;

	public Help1() {
		g = new Font("", Font.BOLD, 24);
		String str = "\n\nMain Requirements of Project:- "

				+ "\n\nComputerized HRMS Automation System is developed to facilitate the general administration system to manage the various"
				+ "\n\ninformation of the employees and the processes involved in an export firm. So, that organization can access accurate information"
				+ "\n\nquickly and easily as and when required, thereby improving its operational efficiency & effectiveness."

				+ "\n\nModule Description :-" + "\n\nHRMS Automation comprises with the following modules:" +

				"\n\n1)	Manpower Planning System." + "\n\n2)	Training  & Planning System."
				+ "\n\n3)	Employee Information System" + "\n\n4)	Salary processing system "
				+ "\n\n5)	Attendance recording system.";

		getContentPane().setBackground(Color.gray);
		panel = (JPanel) getContentPane();
		panel.setLayout(null);

		t = new TextArea(str, 600, 500);
		panel.add(t);
		t.setBounds(50, 50, 700, 500);
		l1 = new JLabel("About Project Requriments");
		panel.add(l1);
		l1.setBounds(250, 5, 400, 40);
		l1.setFont(g);
		l1.setForeground(Color.red);
		b = new JButton("BACK");
		panel.add(b);
		b.setBounds(650, 5, 100, 30);
		b.setBackground

		(Color.blue);
		b.setFont(new Font("", Font.BOLD, 18));
		b.setForeground(Color.pink);
		b.addActionListener(this);

	}

	public void actionPerformed(ActionEvent a) {
		String s1 = "BACK";
		String str = a.getActionCommand();
		if (s1.equals(str)) {
			Help f = new Help();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}
	}

	public static void main(String args[]) {
		Help1 f = new Help1();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}
