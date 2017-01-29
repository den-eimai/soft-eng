package org.teipir.softeng.hrms;
//----- Creating Form For Change Password

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class Change_password extends JFrame implements ActionListener {
	JButton cpw_change, cpw_cancel, cpw_clear;
	JLabel cpw_uname, cpw_ulname, cpw_id, cpw_pwd, cpw_cpwd, cpw_cnpwd;
	JTextField cpw_utf, cpw_ultf, cpw_uid;
	JPasswordField cpw_ppf, cpw_cppf, cpw_cnppf;

	public Change_password() {
		super("Change Password...");
		setLayout(null);

		Container c = this.getContentPane();
		c.setBackground(new Color(204, 230, 255));

		cpw_id = new JLabel(" Enter The Login ID         :- ");
		cpw_id.setFont(new Font("Georgia", Font.BOLD, 15));
		cpw_id.setBounds(30, 25, 225, 25);
		add(cpw_id);

		cpw_uid = new JTextField();
		cpw_uid.setBounds(250, 25, 150, 25);
		add(cpw_uid);

		cpw_pwd = new JLabel(" Enter Old Password        :- ");
		cpw_pwd.setFont(new Font("Georgia", Font.BOLD, 15));
		cpw_pwd.setBounds(30, 60, 225, 25);
		add(cpw_pwd);

		cpw_ppf = new JPasswordField();
		cpw_ppf.setBounds(250, 60, 150, 25);
		add(cpw_ppf);

		cpw_cpwd = new JLabel(" Enter New Password      :- ");
		cpw_cpwd.setFont(new Font("Georgia", Font.BOLD, 15));
		cpw_cpwd.setBounds(30, 95, 225, 25);
		add(cpw_cpwd);

		cpw_cppf = new JPasswordField();
		cpw_cppf.setBounds(250, 95, 150, 25);
		add(cpw_cppf);

		cpw_cnpwd = new JLabel(" Verify New Password     :- ");
		cpw_cnpwd.setFont(new Font("Georgia", Font.BOLD, 15));
		cpw_cnpwd.setBounds(30, 130, 225, 25);
		add(cpw_cnpwd);

		cpw_cnppf = new JPasswordField();
		cpw_cnppf.setBounds(250, 130, 150, 25);
		add(cpw_cnppf);

		cpw_change = new JButton("Change");
		cpw_change.setToolTipText("Changes Existing Password...");
		cpw_change.addActionListener(this);
		cpw_change.setFont(new Font("Georgia", Font.BOLD, 17));
		cpw_change.setBounds(22, 175, 110, 25);
		add(cpw_change);

		cpw_clear = new JButton("Clear");
		cpw_clear.setToolTipText("Clears All Textfields...");
		cpw_clear.addActionListener(this);
		cpw_clear.setFont(new Font("Georgia", Font.BOLD, 17));
		cpw_clear.setBounds(160, 175, 110, 25);
		add(cpw_clear);

		cpw_cancel = new JButton("Cancel");
		cpw_cancel.setToolTipText("Avoids Changing Password & Goes Back To Main Window...");
		cpw_cancel.addActionListener(this);
		cpw_cancel.setFont(new Font("Georgia", Font.BOLD, 17));
		cpw_cancel.setBounds(300, 175, 110, 25);
		add(cpw_cancel);

	}// Change_password_constructor

	public void actionPerformed(ActionEvent ae5) {
		String scpw = ae5.getActionCommand();

		if (scpw.equals("Cancel")) {
			this.dispose();
			Menu1 ms = new Menu1();

		} // if_cancel

		if (scpw.equals("Clear")) {
			cpw_uid.setText(null);
			cpw_ppf.setText(null);
			cpw_cppf.setText(null);
			cpw_cnppf.setText(null);

		} // if_clear

		if (scpw.equals("Change")) {
			String cpw_sid = cpw_uid.getText();
			String cpw_pass = cpw_ppf.getText();
			String cpw_cpass = cpw_cppf.getText();
			String cpw_scnpwd = cpw_cnppf.getText();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
				System.out.println("\n Congrats.......\n DBCon Successfull.\n");

				Statement st1 = c1.createStatement();

				String q = "select * from id_password where login_id='" + cpw_sid + "' and password='" + cpw_pass
						+ "';";

				ResultSet rs = st1.executeQuery(q);

				if (rs.next()) {
					if (cpw_cpass.equals(cpw_scnpwd)) {
						q = "update id_password set password ='" + cpw_scnpwd + "' where login_id='" + cpw_sid + "';";
						int r = st1.executeUpdate(q);

						if (r != 0) {
							int dialogtype = JOptionPane.INFORMATION_MESSAGE;
							JOptionPane.showMessageDialog(null, " Password Has Been Changed Successfully...", "MESSAGE",
									dialogtype);

							this.dispose();

						} // if

						else {
							int dialogtype = JOptionPane.INFORMATION_MESSAGE;
							JOptionPane.showMessageDialog(null, " Error In Changing Password...", "MESSAGE",
									dialogtype);

							this.dispose();

						} // else

					} // if

					else {
						int dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog(null,
								" Error... \n Passords Do Not Match.\n Please Re-enter & Try Again...", "MESSAGE",
								dialogtype);

						cpw_cppf.setText(null);
						cpw_cnppf.setText(null);

					} // else

				} // if

				else {
					int dialogtype = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog(null, " Invalid Login Id Or Password...", "MESSAGE", dialogtype);

					this.dispose();

				} // else

				c1.close();

			} // try

			catch (Exception e) {
				System.out.println("\n Exception Occured : \n " + e);

			} // catch

		} // if_change

	}// actionPerformed

	public static void main(String a[]) {
		Change_password cppw = new Change_password();
		cppw.setLocation(150, 150);
		cppw.setVisible(true);
		cppw.setSize(450, 250);

	}// main

}// Change_password_class