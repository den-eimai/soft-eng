package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;

public class Report extends JFrame implements ActionListener {

	JButton exit;

	public Report() {
		super("Training Department Information");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		Object[][] data = new Object[52][7];
		DBCon con = new DBCon();
		int i = 0;

		try {
			String sql = "SELECT * FROM master";
			con.rs1 = con.st1.executeQuery(sql);
			while (con.rs1.next()) {
				data[i][0] = con.rs1.getString("dept_name");
				data[i][1] = con.rs1.getInt("cand_regno");
				data[i][2] = con.rs1.getString("post");
				data[i][3] = con.rs1.getString("tr_prg");
				data[i][4] = con.rs1.getString("duration");
				data[i][5] = con.rs1.getString("cost");
				data[i][6] = con.rs1.getString("personassign");

				i++;
			}
		} catch (Exception e1) {
			System.out.println("\n SQL Error:" + e1.getMessage());
		}

		final String[] colHeads = { "Dept.Named", "Candidate Reg.No", "Post", "Training Program", "Duration", "Cost",
				"No.Person" };
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
			Masterdetails01 m1 = new Masterdetails01();
			m1.setSize(790, 580);
			m1.setVisible(true);
			m1.show();
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Report j2 = new Report();
	}
}
