package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import java.awt.print.PrinterException;
import java.beans.PropertyVetoException;
import java.text.MessageFormat;
import java.util.Date;

public class Excellentr extends JFrame implements ActionListener {

	JButton exit, print;
	public JTable table;

	public Excellentr() {
		super("Excllent Candidates");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		Object[][] data = new Object[52][7];
		DBCon con = new DBCon();
		int i = 0;

		try {
			String sql = "SELECT * FROM Tr_reg where discription ='Excellent'";
			con.rs1 = con.st1.executeQuery(sql);
			while (con.rs1.next()) {
				data[i][0] = con.rs1.getInt("candi_id");
				data[i][1] = con.rs1.getString("candi_name");
				data[i][2] = con.rs1.getString("qualification");
				data[i][3] = con.rs1.getInt("phone_no");
				data[i][4] = con.rs1.getInt("initial_interview");
				data[i][5] = con.rs1.getInt("written");
				data[i][6] = con.rs1.getInt("final_interview");
				i++;
			}
		} catch (Exception e1) {
			System.out.println("\n SQL Error:" + e1.getMessage());
		}

		final String[] colHeads = { "Candidate Id", "Candidate Name", "Qualification", "Phone No", "Intial_Interview",
				"Written", "Final_Interview" };
		JTable table = new JTable(data, colHeads);
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(table, v, h);
		contentPane.add(jsp, "Center");
		exit = new JButton("EXIT");
		print = new JButton("Print");
		exit.addActionListener(this);
		JPanel jp1 = new JPanel();
		jp1.add(exit);
		jp1.add(print);
		contentPane.add(jp1, "South");
		setVisible(true);
		setSize(800, 570);
		show();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane jsp12;
		table = new JTable(data, colHeads);
		jsp12 = new JScrollPane(table);
		jsp12.setBounds(450, 50, 350, 240);

		add(jsp12);

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
		Excellentr j2 = new Excellentr();
	}
}
