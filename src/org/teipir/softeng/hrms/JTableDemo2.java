package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;

public class JTableDemo2 extends JFrame implements ActionListener {

	JButton exit;

	public JTableDemo2() {
		super("TABLE");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		Object[][] data = new Object[52][5];
		DBCon con = new DBCon();
		int i = 0;

		try {
			String sql = "SELECT * FROM perf where Description ='Good'";
			con.rs1 = con.st1.executeQuery(sql);
			while (con.rs1.next()) {
				data[i][0] = con.rs1.getInt("Candidate_Id");
				data[i][1] = con.rs1.getInt("Initial_Interview");
				data[i][2] = con.rs1.getInt("Written");
				data[i][3] = con.rs1.getInt("Final_Interview");
				data[i][4] = con.rs1.getString("Description");
				i++;
			}
		} catch (Exception e1) {
			System.out.println("\n SQL Error:" + e1.getMessage());
		}

		final String[] colHeads = { "Candidate Id", "Intial_Interview", "Written", "Final_Interview", "Description" };
		JTable table = new JTable(data, colHeads);
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(table, v, h);
		contentPane.add(jsp, "Center");
		exit = new JButton("EXIT");
		exit.addActionListener(this);
		JPanel jp1 = new JPanel();
		jp1.add(exit);
		contentPane.add(jp1, "South");
		setVisible(true);
		setSize(800, 570);
		show();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("EXIT")) {
			Cd_per m1 = new Cd_per();
			m1.setSize(790, 580);
			m1.setVisible(true);
			m1.show();
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JTableDemo2 j2 = new JTableDemo2();
	}
}
