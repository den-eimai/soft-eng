package org.teipir.softeng.hrms;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Cd_per extends JFrame implements ActionListener {
	public JLabel l, l1, l2, l3, l4, l5, l6, dtx;
	public JTextField t4, t1, t2, t3, t5, t6, dtxt;
	public String ts1, ts2, ts3, ts4, ts5;
	public JPanel panel;
	public Font g, g1;
	public JButton b1, b2, b3, b4, b5, b6;
	public JMenu jb1;
	public Statement stmt, stmt2;
	public ResultSet rs;

	public Cd_per() {
		g = new Font("Georgia", Font.BOLD, 22);
		g1 = new Font("Georgia", Font.BOLD, 16);

		panel = (JPanel) getContentPane();
		panel.setLayout(null);

		panel.setBackground(new java.awt.Color(204, 230, 255));

		panel = (JPanel) getContentPane();
		panel.setLayout(null);

		// ------ Displaying Current System Date ....

		dtx = new JLabel(" Date :- ");
		dtx.setBounds(585, 20, 100, 20);
		dtx.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(dtx);

		dtxt = new JTextField();
		dtxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		dtxt.setBackground(Color.WHITE);
		dtxt.setBounds(660, 20, 100, 20);
		dtxt.setEditable(false);

		String str = String.format("%1$td-%1$tb-%1$ty", new Date());
		dtxt.setText(str);
		panel.add(dtxt);

		// ---------------------------------------------------

		JMenuBar me = new JMenuBar();
		setJMenuBar(me);
		jb1 = new JMenu("Report");
		me.add(jb1);
		JMenuItem jm1 = new JMenuItem("Excellent");
		jb1.add(jm1);
		JMenuItem jm2 = new JMenuItem("Good");
		jb1.add(jm2);
		JMenuItem jm3 = new JMenuItem("Average");
		jb1.add(jm3);
		JMenuItem jm4 = new JMenuItem("Poor");
		jb1.add(jm4);

		jm1.addActionListener(this);
		jm2.addActionListener(this);
		jm3.addActionListener(this);
		jm4.addActionListener(this);

		l = new JLabel("Candidate Performnace ");
		l1 = new JLabel("Candidate Id");
		l2 = new JLabel("Initial Interview");
		l3 = new JLabel("Written");
		l4 = new JLabel("Final interview");
		l5 = new JLabel("Description");
		l6 = new JLabel("Total");

		l1.setFont(g1);
		l2.setFont(g1);
		l3.setFont(g1);
		l4.setFont(g1);
		l5.setFont(g1);
		l6.setFont(g1);

		ImageIcon img = new ImageIcon("n.gif");
		ImageIcon img1 = new ImageIcon("b.gif");

		b1 = new JButton("Submit");
		b2 = new JButton(img);
		b3 = new JButton("Search");
		b4 = new JButton(img1);
		
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		t5.setEditable(false);
		t6 = new JTextField(20);
		t6.setEditable(false);

		t1.setBounds(320, 100, 150, 30);
		t2.setBounds(320, 150, 150, 30);
		t3.setBounds(320, 200, 150, 30);
		t4.setBounds(320, 250, 150, 30);
		t6.setBounds(320, 300, 150, 30);
		t5.setBounds(320, 350, 150, 30);

		panel.add(b1);
		b4.setBounds(200, 450, 80, 30);
		panel.add(b2);
		b2.setBounds(500, 450, 80, 30);
		panel.add(b3);
		b1.setBounds(300, 450, 80, 30);
		panel.add(b4);
		b3.setBounds(400, 450, 80, 30);

		panel.add(l);
		l.setBounds(240, 25, 300, 35);
		l.setFont(g);

		panel.add(l1);
		l1.setBounds(150, 100, 150, 30);
		panel.add(l2);
		l2.setBounds(150, 150, 150, 30);
		panel.add(l3);
		l3.setBounds(150, 200, 150, 30);
		l4.setBounds(150, 250, 150, 30);
		panel.add(l4);
		l6.setBounds(150, 300, 150, 30);
		panel.add(l6);
		l5.setBounds(150, 350, 150, 30);
		panel.add(l5);

		panel.add(t1);
		panel.add(t2);
		panel.add(t3);
		panel.add(t4);
		panel.add(t5);
		panel.add(t6);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String str1 = ae.getActionCommand();
		if (ae.getSource() == b2) {
			Masterdetails01 f = new Masterdetails01();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}
		if (ae.getSource() == b4) {
			Tr_reg f = new Tr_reg();

			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}
		if (str1 == "Excellent") {
			Ex j2 = new Ex();
			j2.setVisible(true);
			this.setVisible(false);
		}
		if (str1 == "Good") {
			Goodr j2 = new Goodr();
			j2.setVisible(true);
			this.setVisible(false);

		}
		if (str1 == "Average") {
			Avgr j2 = new Avgr();
			j2.setVisible(true);
			this.setVisible(false);
		}
		if (str1 == "Poor") {
			Poorr j2 = new Poorr();
			j2.setVisible(true);
			this.setVisible(false);

		}
		if (str1 == "Submit") {
			int total = 0;
			int int1 = Integer.parseInt(t2.getText());
			int writ = Integer.parseInt(t3.getText());
			int fin = Integer.parseInt(t4.getText());
			total = int1 + writ + fin;
			t6.setText("" + total);
			if (total >= 275)
				t5.setText("Excellent");
			else if (total >= 240)
				t5.setText("Good");
			else if (total >= 180)
				t5.setText("Average");
			else
				t5.setText("Poor");

			int flag = 0;
			ts1 = t1.getText();
			int a1 = Integer.parseInt(ts1);
			ts2 = t2.getText();
			int a2 = Integer.parseInt(ts2);
			ts3 = t3.getText();
			int a3 = Integer.parseInt(ts3);
			ts4 = t4.getText();
			int a4 = Integer.parseInt(ts4);
			ts5 = t5.getText();
			if ((0 > a2) || (a2 > 100) || (0 > a3) || (a3 > 100) || (0 > a4) || (a4 > 100)) {
				int dialogtype = JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog(null, " Invalid Entery...", "MESSAGE", dialogtype);
				flag = 1;
			} //
			
			if (flag == 0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
					System.out.println("\n Congrats.......\n DBCon Successfull.\n");

					Statement st1 = c1.createStatement();

					String q = "select * from Tr_reg where candi_id= " + a1 + ";";

					ResultSet rs = st1.executeQuery(q);

					if (rs.next()) {
						q = "update Tr_reg set initial_interview = " + a2 + "  where candi_id= " + a1 + ";";
						int r = st1.executeUpdate(q);

						q = "update Tr_reg set written = " + a3 + "  where candi_id= " + a1 + ";";

						int r1 = st1.executeUpdate(q);

						q = "update Tr_reg set final_interview = " + a4 + "  where candi_id= " + a1 + ";";

						int r2 = st1.executeUpdate(q);

						q = "update Tr_reg set discription = '" + ts5 + "'  where candi_id= " + a1 + ";";

						int r3 = st1.executeUpdate(q);

						q = "update Tr_reg set total = '" + total + "'  where candi_id= " + a1 + ";";

						int r4 = st1.executeUpdate(q);

						if (r != 0 && r1 != 0 && r2 != 0 && r3 != 0 && r4 != 0) {
							int dialogtype = JOptionPane.INFORMATION_MESSAGE;
							JOptionPane.showMessageDialog(null, " Record Inserted Successfully...", "MESSAGE",
									dialogtype);
						} // if

						else {
							int dialogtype = JOptionPane.INFORMATION_MESSAGE;
							JOptionPane.showMessageDialog(null, " Error Occar...", "MESSAGE", dialogtype);
						} // else

					} // if

					else {
						int dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog(null, " Invalid Entery...", "MESSAGE", dialogtype);
					} // else

					c1.close();

				} // try

				catch (Exception e) {
					System.out.println("\n Exception Occured : \n " + e);

				} // catch

			} // if_change

		}


			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
				stmt = con.createStatement();
				int st = Integer.parseInt(t1.getText());
				rs = stmt.executeQuery("select * from Tr_reg where candi_id=" + st + "");
				while (rs.next()) {
					t2.setText(Integer.toString(rs.getInt("initial_interview")));
					t3.setText(Integer.toString(rs.getInt("written")));
					t4.setText(Integer.toString(rs.getInt("final_interview")));
					t5.setText(rs.getString("discription"));
					t6.setText(Integer.toString(rs.getInt("total")));
				}
			} catch (Exception Ex) {
				System.out.println(Ex);
			}
		}


	public static void main(String args[]) {
		Cd_per f = new Cd_per();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}