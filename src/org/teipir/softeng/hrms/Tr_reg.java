package org.teipir.softeng.hrms;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Tr_reg extends JFrame implements ActionListener, ItemListener {
	public JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, dtx;
	public JTextField t1, t2, t3, t4, t5, t6, t7, t15, t16, dtxt;
	public String ts1, ts2, ts3, ts4, ts5, ts6, ts7, ts8, ts9, ts10, ts11, ts12, ts13, ts14, ts15, ts16;
	public String s1, s2, s3, s4, s5, s6;
	public JToggleButton b1, b4;
	public JComboBox ch, ch1, ch2;
	public JPanel panel;
	public JRadioButton r1, r2, r3, r4, r5, r6;
	public JButton b3, b2;
	public Font g, g1;

	DBCon con = new DBCon();

	public Tr_reg() {
		panel = (JPanel) getContentPane();
		panel.setLayout(null);
		g = new Font("Georgia", Font.BOLD, 22);
		g1 = new Font("Georgia", Font.BOLD, 15);

		panel.setBackground(new java.awt.Color(204, 230, 255));

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

		l = new JLabel("Training Registration Form");
		l1 = new JLabel("Name :-");
		l2 = new JLabel("Fathers Name :-");
		l3 = new JLabel("Roll Number :-");
		l4 = new JLabel("Email Id:-");
		l5 = new JLabel("Phone No. :-");
		l6 = new JLabel("Per.Address :-");
		l7 = new JLabel("Qualifications :-");
		l8 = new JLabel("Hobbies :-");
		l9 = new JLabel("Gender :-");
		l10 = new JLabel("Category :-");
		l11 = new JLabel("Nationality :-");
		l12 = new JLabel("Candidate_id :-");
		b1 = new JToggleButton("ADD");
		ImageIcon img1 = new ImageIcon("n.gif");
		b2 = new JButton(img1);
		ImageIcon img = new ImageIcon("b.gif");
		b3 = new JButton(img);
		b4 = new JToggleButton("CLEAR");

		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		t6 = new JTextField(20);
		t7 = new JTextField(30);
		t15 = new JTextField(30);
		t16 = new JTextField(30);

		ch = new JComboBox();
		ch1 = new JComboBox();
		ch2 = new JComboBox();

		panel.add(l);
		l.setBounds(200, 0, 380, 60);
		l.setFont(g);

		l12.setBounds(20, 100, 130, 30);
		panel.add(l12);
		t1.setBounds(150, 100, 150, 30);
		panel.add(t1);
		l12.setFont(g1);
		l1.setBounds(20, 160, 130, 30);
		panel.add(l1);
		t2.setBounds(150, 160, 150, 30);
		panel.add(t2);
		l1.setFont(g1);

		l2.setBounds(20, 220, 130, 30);
		panel.add(l2);
		t3.setBounds(150, 220, 150, 30);
		panel.add(t3);
		l2.setFont(g1);

		l5.setBounds(20, 280, 130, 30);
		panel.add(l5);
		t6.setBounds(150, 280, 150, 30);
		panel.add(t6);
		l5.setFont(g1);

		l4.setBounds(20, 340, 130, 30);
		panel.add(l4);
		t5.setBounds(150, 340, 150, 30);
		panel.add(t5);
		l4.setFont(g1);
		l8.setBounds(20, 400, 130, 30);
		panel.add(l8);
		l8.setFont(g1);
		t16.setBounds(150, 400, 150, 30);
		panel.add(t16);

		l3.setBounds(410, 100, 150, 30);
		panel.add(l3);
		l3.setFont(g1);
		t4.setBounds(560, 100, 150, 30);
		panel.add(t4);

		l6.setBounds(410, 160, 150, 30);
		panel.add(l6);
		l6.setFont(g1);
		t15.setBounds(560, 160, 150, 30);
		panel.add(t15);

		l11.setBounds(410, 220, 150, 30);
		panel.add(l11);
		l11.setFont(g1);
		t7.setBounds(560, 220, 150, 30);
		panel.add(t7);

		panel.add(b1);
		b3.setBounds(150, 500, 80, 30);
		panel.add(b2);
		b1.setBounds(250, 500, 80, 30);
		panel.add(b3);
		b4.setBounds(350, 500, 80, 30);
		panel.add(b4);
		b2.setBounds(450, 500, 80, 30);

		l7.setBounds(410, 280, 150, 30);
		panel.add(l7);
		l7.setFont(g1);
		ch.addItem("B.Tech.");
		ch.addItem("M.Tech.");
		ch.addItem("MCA");
		ch.addItem("B.Sc.(CS)/M.Sc.(CS)");
		ch.addItem("MBA");
		panel.add(ch);
		ch.setBounds(560, 280, 150, 25);

		l9.setBounds(410, 340, 100, 30);
		panel.add(l9);
		l9.setFont(g1);
		ch1.addItem("Male.");
		ch1.addItem("Female.");
		panel.add(ch1);
		ch1.setBounds(560, 340, 150, 25);

		l10.setBounds(410, 400, 100, 30);
		panel.add(l10);
		l10.setFont(g1);
		ch2.addItem("Gen");
		ch2.addItem("OBC.");
		ch2.addItem("SC/ST");
		ch2.addItem("OTHERS.");

		panel.add(ch2);
		ch2.setBounds(560, 400, 150, 25);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
			String maxcode = "select count( * ) from Tr_reg";
			PreparedStatement ch = con.prepareStatement(maxcode);
			ResultSet rs1 = ch.executeQuery();
			rs1.next();
			int j = rs1.getInt(1);
			int ano;
			ano = j + 1;
			t1.setText("" + ano);
			t1.setEditable(false);
			t4.setText("" + ano);
			t4.setEditable(false);
			con.close();
		} // try
		catch (NumberFormatException ne) {
			JOptionPane.showMessageDialog(this, "Invalid Input", "Operation Not Possible", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			System.out.println("\n Exception : " + e.getMessage());

		} // catch
	}

	public void itemStateChanged(ItemEvent a1) {
		repaint();
	}

	public void actionPerformed(ActionEvent a) {
		String str = a.getActionCommand();
		if (a.getSource() == b3) {
			Placement f = new Placement();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}

		if (a.getSource() == b2) {
			Cd_per f = new Cd_per();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}

		if (str == "CLEAR") {
			t2.setText("");
			t3.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t15.setText("");
			t16.setText("");
		}
		if (str == "ADD") {
			try {
				System.out.println("starting Established..");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println(" Established..");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
				System.out.println("DBCon Established.. ........");
				Statement sm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

				ts1 = t1.getText();
				int a1 = Integer.parseInt(ts1);
				ts2 = t2.getText();
				ts3 = t3.getText();
				ts4 = t4.getText();
				int a2 = Integer.parseInt(ts4);
				ts5 = t5.getText();
				ts6 = t6.getText();

				int a3 = Integer.parseInt(ts6);
				ts7 = (String) ch.getSelectedItem();

				String sc = (String) ch1.getSelectedItem();
				String sc1 = (String) ch1.getSelectedItem();
				ts14 = t7.getText();
				ts15 = t15.getText();
				ts16 = t16.getText();
				String dsc = " ";
				int p = 0, q = 0, r = 0, s = 0;

				System.out.println("query Established..");
				PreparedStatement psm = con.prepareStatement("insert into Tr_reg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				psm.setInt(1, a1);
				psm.setString(2, ts2);
				psm.setString(3, ts7);
				psm.setString(4, ts3);
				psm.setInt(5, a2);
				psm.setString(6, ts5);
				psm.setString(7, ts6);
				psm.setString(8, ts14);
				psm.setString(9, ts16);
				psm.setString(10, sc);
				psm.setString(11, sc1);
				psm.setString(12, ts15);
				psm.setInt(13, p);
				psm.setInt(14, q);
				psm.setInt(15, r);
				psm.setString(16, dsc);
				psm.setInt(17, p);
				int i = psm.executeUpdate();
				System.out.println("query.");
				con.commit();
				JOptionPane.showMessageDialog(this, "Query Executed", "Record Inserted", JOptionPane.WARNING_MESSAGE);
				System.out.println("Query Executed");

			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(this, "Invalid Input", "Operation Not Possible",
						JOptionPane.WARNING_MESSAGE);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException es) {
				es.printStackTrace();
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Tr_reg f = new Tr_reg();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}