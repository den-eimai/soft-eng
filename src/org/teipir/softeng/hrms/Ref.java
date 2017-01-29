package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
//import java.applet.*;
import javax.swing.*;
import java.util.*;

public class Ref extends JFrame implements ActionListener {
	public JPanel pane;
	public JButton b1;
	public TextArea t;
	String val;

	public Ref() {
		setTitle("References prefered");
		pane = (JPanel) getContentPane();
		pane.setLayout(null);

		JLabel j = new JLabel(" REFERENCES  ");
		j.setFont(new Font("monospaced", Font.BOLD, 16));
		j.setBounds(300, 15, 250, 50);
		pane.add(j);

		String val = /*
						 * "   		" + "			" + "			" +
						 */ "	" + "			" + " Project Title: HRMS Automation"

				+

				"References\n\n"

				+

				"\n\t1.  Java Swing Programming Published by : Rock's Publication "

				+

				"\n\n\t2.  SQL Server 7.0  Published by : TMH Publications"

				+

				"\n\n\t3.  Java2 Complete Refference   Published by : Techmedia    Author : Arman Danesh"

				+

				"\n\n\t4. The Complete Reference of Java2  Published by : Tata McGraw HillAuthor : Patric Naughton, Herbert Schildt "

				+

				"\n\n\t5.  HTML4.0  Published by : BPB Publications"

				+

				"\n\n\n\n\tFOR MORE INFORMATION EMAIL US :" +

				"\n\n\t hrms_santosh@gmail.com"

				+

				"\n\n\n\tWEB REFERENCES:"

				+

				"\n\n\thttp:www.sun.com" + "\n\n\thttp:www.jsptut.com";

		t = new TextArea(10, 6);
		t.setText(val);
		t.setBounds(30, 50, 700, 450);
		t.setBackground(new java.awt.Color(204, 230, 255));
		t.setForeground(Color.black);
		Font f2 = new Font("Arial", Font.BOLD, 12);
		t.setFont(f2);
		t.setEnabled(true);

		b1 = new JButton("Cancel");
		pane.add(b1);
		b1.setBounds(600, 10, 100, 30);
		b1.setFont(f2);
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		pane.add(t);
		b1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent a) {
		String s3 = "Cancel";
		String str = a.getActionCommand();

		if (s3.equals(str)) {
			Menu1 p = new Menu1();
		}
	}

	public static void main(String args[]) {
		Ref f = new Ref();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}
