package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
//import java.applet.*;
import javax.swing.*;
import java.util.*;

public class Help extends JFrame implements ActionListener {
	public JPanel pane;
	public JButton b1, b2, b3;
	public TextArea t;

	public Help() {
		setTitle("Help");
		pane = (JPanel) getContentPane();
		pane.setLayout(null);

		JLabel j = new JLabel(" HELP FILE ");
		j.setFont(new Font("monotype corsiva", Font.ITALIC, 30));
		j.setBounds(300, 20, 250, 50);
		pane.add(j);

		String val = 
				" \nProject Title: HRMS Automation" +

						"\nIntroduction:"

						+ "\nThe presented project here is made in view overcoming the problems faced by the any Export firm regarding Maintenance, Recording and keeping of Data base, Employee information, Financial transactions, Payroll system, Training, Recruitment etc. i.e. 'General HRMS Automation'."
						+ "\nThis project is an Application Project i.e. HRMS Automation System."
						+ "\nApplication run in a local area network of client where as web site run in wide area networks i.e. World Wide Web. Application run on user defined window where as website works in a browser.Hence this project is an Application and not a portal/website."
						+

						"\nThis project can be widely used in any Export firm which contain different departments with various employees having different designations, salary profiles etc. Beside these it is very useful for the organizations having number of branches with a Head Branch connected by a LAN system through its other branches. These networks need a special kind of security feature. "
						+

						"\nObjective and Scope of the study: -"
						+ "\nObjective of doing this project is to enhance my knowledge in the field of Distributed technology using J2EE and Oracle 8i. Some of the client requirement and objectives of this project is as under: -"

						+ "\nThe main objective of study: -" +

						"\n* It should contain all the information of Company."
						+ "\n* It should contain all the information of Company Infrastructure."
						+ "\n* It should contain all the information of Company Employees."
						+ "\n* It should contain all the information of Orders."
						+ "\n* It should contain all the information of Item in stock."

						+ "\n\nPURPOSE: -" +

						"\nComputerized HRMS Automation System is developed to facilitate the general administration system to manage the various"
						+ "\ninformation of the employees and the processes involved in an export firm. So, that organization can access accurate information"
						+ "\nquickly and easily as and when required, thereby improving its operational efficiency & effectiveness."

						+ "\n\nModule Description :-" + "\nHRMS Automation comprises with the following modules:" +

						"\n\n1)	Manpower Planning System." + "\n\n2)	Training  & Planning System."
						+ "\n\n3)	Employee Information System" + "\n\n4)	Salary processing system "
						+ "\n\n5)	Attendance recording system.";

		t = new TextArea(val, 15, 20);
		t.setBounds(50, 70, 700, 400);
		t.setBackground(new java.awt.Color(204, 230, 255));
		t.setForeground(Color.gray);
		Font f2 = new Font("Arial", Font.ITALIC, 12);
		t.setFont(f2);
		t.setEnabled(true);
		b1 = new JButton("Project Contents");
		b3 = new JButton("Cancel");

		pane.add(b1);
		pane.add(b3);

		b1.setBounds(100, 500, 200, 30);
		b3.setBounds(320, 500, 200, 30);
		b1.setFont(f2);
		b3.setFont(f2);
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b3.setBackground(Color.blue);
		b3.setForeground(Color.white);
		pane.add(t);
		b1.addActionListener(this);
		b3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent a) {
		String s1 = "Project Contents";
		String s2 = "Shortcut Keys";
		String s3 = "Cancel";
		String str = a.getActionCommand();
		if (s1.equals(str)) {
			Help1 f = new Help1();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}

		if (s3.equals(str)) {
			Menu1 p = new Menu1();
		}
	}

	public static void main(String args[]) {
		Help f = new Help();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}