package org.teipir.softeng.hrms;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Masterdetails01 extends JFrame implements ActionListener {
	public JLabel l, l0, l1, l2, l3, l4, l5, l6, dtx;
	public JTextField t, t0, t1, t2, t3, t4, t5, dtxt;
	public Choice ch1, ch2;
	public Font g, g1;
	public String ts1, ts2, ts3, ts4, ts5, ts6, ts7, ts8, ts9, ts10;
	public JButton b1, b2, b3;
	public JPanel panel;
	public JMenu jb1;

	public Masterdetails01() {

		panel = (JPanel) getContentPane();
		panel.setLayout(null);
		panel.setBackground(new java.awt.Color(204, 230, 255));

		JMenuBar me = new JMenuBar();
		setJMenuBar(me);
		jb1 = new JMenu("Reports");
		me.add(jb1);
		JMenuItem jm1 = new JMenuItem("Report");
		jb1.add(jm1);
		jm1.addActionListener(this);

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
		add(dtxt);

		// ---------------------------------------------------

		g = new Font("Georgia", Font.BOLD, 22);
		g1 = new Font("Georgia", Font.BOLD, 16);

		l = new JLabel("Training Department Information");
		l0 = new JLabel("Department Name :-");
		l1 = new JLabel("Candidate Reg.No :-");
		l2 = new JLabel("Training for which Post :-");
		l3 = new JLabel("Name of Training Program :-");
		l4 = new JLabel("Duration of Training :-");
		l5 = new JLabel("Cost of Training Program :-");
		l6 = new JLabel("Person Assigned for Training :-");

		ch1 = new Choice();
		ch2 = new Choice();

		l.setFont(g);

		t = new JTextField(20);
		t0 = new JTextField(20);
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);

		b1 = new JButton("Add");
		b2 = new JButton("Clear");
		ImageIcon img = new ImageIcon("b.gif");
		b3 = new JButton(img);

		panel.add(l);
		l.setBounds(140, 25, 400, 35);
		panel.add(l0);
		l0.setBounds(100, 100, 350, 50);
		panel.add(l1);
		l1.setBounds(100, 150, 350, 50);
		panel.add(l2);
		l2.setBounds(100, 200, 350, 50);
		panel.add(l3);
		l3.setBounds(100, 250, 350, 50);
		panel.add(l4);
		l4.setBounds(100, 300, 350, 50);
		panel.add(l5);
		l5.setBounds(100, 350, 350, 50);
		panel.add(l6);
		l6.setBounds(100, 400, 350, 50);

		l0.setFont(g1);
		l1.setFont(g1);
		l2.setFont(g1);
		l3.setFont(g1);
		l4.setFont(g1);
		l5.setFont(g1);
		l6.setFont(g1);

		ch1.addItem("Rs. 10000 upto 20000");
		ch1.addItem("Above 20000 upto 50000");
		ch1.addItem("Above 50000");
		panel.add(ch1);
		ch1.setBounds(420, 370, 150, 60);

		ch2.addItem("60 Hours/90 Hours");
		ch2.addItem("45 Days");
		ch2.addItem("6 Months");
		ch2.addItem("12 Months");
		panel.add(ch2);
		ch2.setBounds(420, 320, 150, 60);

		panel.add(t);
		t.setBounds(420, 160, 120, 30);
		panel.add(t0);
		t0.setBounds(420, 110, 120, 30);
		panel.add(t1);
		t1.setBounds(420, 210, 120, 30);
		panel.add(t2);
		t2.setBounds(420, 260, 120, 30);
		panel.add(t3);
		t3.setBounds(420, 410, 120, 30);

		panel.add(b1);
		b3.setBounds(130, 480, 80, 30);
		panel.add(b2);
		b1.setBounds(290, 480, 80, 30);
		panel.add(b3);
		b2.setBounds(450, 480, 80, 30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent a) {
		String str = a.getActionCommand();
		if (a.getSource() == b3) {
			Tr_reg f = new Tr_reg();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}
		if (str == "Report") {
			Report j2 = new Report();
			j2.setVisible(true);
			this.setVisible(false);

		}
		if (str == "Clear") {
			t.setText("");
			t0.setText("");
			t1.setText("");
			t2.setText("");
			t3.setText("");

		}

		if (str == "Add") {

			try {
				System.out.println("starting Established..");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println(" Established..");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
				System.out.println("DBCon Established.. ...");
				con.setAutoCommit(false);
				Statement sm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

				ts1 = t0.getText();
				ts2 = t.getText();
				int a1 = Integer.parseInt(ts2);
				ts3 = t1.getText();
				ts4 = t2.getText();
				ts5 = ch2.getSelectedItem();
				ts6 = ch1.getSelectedItem();
				ts7 = t3.getText();

				System.out.println("query Established.....");

				PreparedStatement psm = con.prepareStatement("insert into master values(?,?,?,?,?,?,?)");
				System.out.println("query Established.....");

				psm.setString(1, ts1);
				psm.setInt(2, a1);
				psm.setString(3, ts3);
				psm.setString(4, ts4);
				psm.setString(5, ts5);
				psm.setString(6, ts6);
				psm.setString(7, ts7);

				psm.executeUpdate();
				System.out.println("query.");
				con.commit();
				JOptionPane.showMessageDialog(this, "Query Executed", "Record Inserted", JOptionPane.WARNING_MESSAGE);
				System.out.println("Query Executed");

			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(this, "Invalid Input", "Operation Not Possible",
						JOptionPane.WARNING_MESSAGE);
			} catch (ClassNotFoundException es) {
				System.out.println(es);
			} catch (SQLException es) {
				System.out.println(es);
			} catch (Exception es) {
				System.out.println(es);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Masterdetails01 f = new Masterdetails01();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}