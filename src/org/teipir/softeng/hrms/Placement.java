package org.teipir.softeng.hrms;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class Placement extends JFrame implements ActionListener {
	public JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, dtx;
	public JTextField t1, t2, t4, t5, t6, t7, t8, dtxt;
	public TextArea t3;
	public String ts1, ts2, ts3, ts4, ts5, ts6, ts7, ts8;
	public JButton b1, b2, b3, b4, b5;
	public JPanel panel;
	public Font g, g1;
	public int ano;

	public Placement() {
		g = new Font("Georgia", Font.BOLD, 22);
		g1 = new Font("Georgia", Font.BOLD, 16);
		panel = (JPanel) getContentPane();
		panel.setLayout(null);
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

		l = new JLabel("Placement Agencies");
		l1 = new JLabel("Id Number :-");
		l2 = new JLabel("Name :-");
		l3 = new JLabel("Address");
		l4 = new JLabel("Contact_Person :-");
		l5 = new JLabel("Contact_Phone :-");
		l6 = new JLabel("InCharge :-");
		l7 = new JLabel("E-mail ID :-");

		t3 = new TextArea(5, 8);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		t6 = new JTextField(20);
		t7 = new JTextField(20);
		t8 = new JTextField(20);
		t1 = new JTextField(20);
		t1.setEditable(false);
		t2 = new JTextField(20);

		b1 = new JButton("SUBMIT");
		ImageIcon img = new ImageIcon("n.gif");
		b2 = new JButton(img);

		b3 = new JButton("SEARCH");
		b4 = new JButton("CLEAR");

		t1.setBounds(320, 100, 200, 30);
		t2.setBounds(320, 150, 200, 30);
		t3.setBounds(320, 400, 200, 60);
		t4.setBounds(320, 200, 200, 30);
		t5.setBounds(320, 250, 200, 30);
		t6.setBounds(320, 300, 200, 30);
		t7.setBounds(320, 350, 200, 30);

		panel.add(b1);
		b1.setBounds(120, 500, 100, 30);
		panel.add(b2);
		b2.setBounds(450, 500, 100, 30);
		panel.add(b3);
		b3.setBounds(340, 500, 100, 30);
		panel.add(b4);
		b4.setBounds(230, 500, 100, 30);

		panel.add(l);
		l.setBounds(240, 25, 300, 35);
		l.setFont(g);
		panel.add(l1);
		l1.setBounds(150, 100, 150, 30);
		l1.setFont(g1);
		panel.add(l2);
		l2.setBounds(150, 150, 150, 30);
		l2.setFont(g1);
		panel.add(l3);
		l3.setBounds(150, 400, 150, 30);
		l3.setFont(g1);
		l4.setBounds(150, 200, 150, 30);
		l4.setFont(g1);
		l5.setBounds(150, 250, 150, 30);
		panel.add(l4);
		l6.setBounds(150, 300, 150, 30);
		l7.setBounds(150, 350, 150, 30);
		panel.add(l5);
		l5.setFont(g1);
		panel.add(l6);
		l6.setFont(g1);

		panel.add(l7);
		l7.setFont(g1);

		panel.add(t1);
		panel.add(t2);
		panel.add(t3);
		panel.add(t4);
		panel.add(t5);
		panel.add(t6);
		panel.add(t7);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");

			String maxcode = "select count( * ) from place";
			PreparedStatement ch = con.prepareStatement(maxcode);
			ResultSet rs1 = ch.executeQuery();
			rs1.next();
			int j = rs1.getInt(1);
			ano = j + 1;
			t1.setText("" + ano);

		} // try

		catch (Exception e) {
			System.out.println("\n Exception : " + e.getMessage());

		} // catch

	}

	public void actionPerformed(ActionEvent ae) {
		String str1 = ae.getActionCommand();
		if (ae.getSource() == b2) {
			Tr_reg f = new Tr_reg();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}
		if (str1 == "SUBMIT") {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");

				String maxcode = "select count( * ) from place";
				PreparedStatement ch = con.prepareStatement(maxcode);
				ResultSet rs1 = ch.executeQuery();
				rs1.next();
				int j = rs1.getInt(1);
				ano = j + 1;
				t1.setText("" + ano);

			} // try

			catch (Exception e) {
				System.out.println("\n Exception : " + e.getMessage());

			} // catch
			t1.setText("" + ano);
			t1.setEditable(false);
			try {
				System.out.println("starting Established..");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println(" Established..");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
				System.out.println("DBCon Established.. ...nbm....rr.fd");
				con.setAutoCommit(false);
				Statement sm = con.createStatement();

				ts1 = t1.getText();
				int a1 = Integer.parseInt(ts1);
				ts2 = t2.getText();
				ts3 = t3.getText();
				ts4 = t4.getText();
				ts5 = t5.getText();
				int a2 = Integer.parseInt(ts5);
				ts6 = t6.getText();
				ts7 = t7.getText();
				ts8 = t8.getText();

				System.out.println("query Established..");
				PreparedStatement psm = con.prepareStatement("insert into place values(?,?,?,?,?,?,?)");

				psm.setInt(1, a1);
				psm.setString(2, ts2);
				psm.setString(3, ts4);
				psm.setInt(4, a2);
				psm.setString(5, ts6);
				psm.setString(6, ts7);
				psm.setString(7, ts3);

				psm.executeUpdate();

				System.out.println("query.");
				con.commit();
				JOptionPane.showMessageDialog(this, "Query Executed", "Record Inserted", JOptionPane.WARNING_MESSAGE);
				System.out.println("Query Executed");
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(this, "Please Enter Valid Input", "Hiiiiiiiiiiiiii",
						JOptionPane.WARNING_MESSAGE);
			} catch (Exception e) {
			}

		}
		if (str1 == "CLEAR") {
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t1.setEditable(true);
			t1.setText("");
		}
		if (str1 == "SEARCH") {
			t1.setEditable(true);
			try {
				System.out.println("starting Established..");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println(" Established..");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
				System.out.println("DBCon Established.. ...");
				con.setAutoCommit(false);
				Statement sm = con.createStatement();
				System.out.println("Query Executed");
				int st = Integer.parseInt(t1.getText());
				System.out.println("Query Executed" + st);
				PreparedStatement psm1 = con.prepareStatement("select * from place where Id_Number=?");
				System.out.println("Query Executed" + st);
				psm1.setInt(1, st);
				ResultSet rs = psm1.executeQuery();
				if (!rs.next()) {
					System.out.println("hiiiiiiiiiiiiiiii");
					JOptionPane.showMessageDialog(this, "Plz Enter Id_Number", "Search is possible",
							JOptionPane.WARNING_MESSAGE);
					t1.setEditable(true);
					t1.setText("");
				} else {
					String st2 = rs.getString(2);
					String st4 = rs.getString(3);
					int st3 = Integer.parseInt(rs.getString(4));
					String st5 = rs.getString(5);
					String st6 = rs.getString(6);
					String st7 = rs.getString(7);

					t2.setText(st2);
					t3.setText(st7);
					t5.setText(String.valueOf(st3));
					t4.setText(st4);
					t6.setText(st5);
					t7.setText(st6);
					t1.setEditable(false);
				}
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(this, " Please Enter Valid Input", " Hiiiiii",
						JOptionPane.WARNING_MESSAGE);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException es) {
			}
		}
	}

	public static void main(String args[]) {
		Placement f = new Placement();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}
