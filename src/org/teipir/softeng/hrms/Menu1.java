package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
//import javax.swing.border.*;
//import java.sql.*;
import java.util.Date;
//import java.io.*;
//import java.util.*;
//import javax.swing.table.*;
//import java.sql.*;
//import java.lang.*;
//import javax.sql.rowset.*;
//import com.sun.rowset.*;
//import java.awt.print.*;
//import java.lang.String.*;
import java.text.*;
//import javax.swing.text.*;

public class Menu1 extends JFrame implements ActionListener {
	Toolkit kit;
	Dimension screens;
	int scrh, scrw;
	public JMenu jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8;
	JButton btag, btrg, btdp, bcp, bsc, bexit;
	JTextField dtxt, ttxt;
	JLabel dtx, im, b_tm, stdn;

	public Menu1() {

		setTitle("Main_Screen");
		setLayout(null);

		ImageIcon img = new ImageIcon("a.jpg");
		JLabel l10 = new JLabel(img);

		stdn = new JLabel(" HUMAN RESOURCE MANAGEMENT SYSTEM");
		stdn.setForeground(Color.MAGENTA);
		stdn.setFont(new Font("Georgia", Font.BOLD, 25));
		stdn.setBounds(140, 10, 650, 50);
		add(stdn);

		dtxt = new JTextField();
		dtxt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dtxt.setBackground(Color.CYAN);
		dtxt.setBounds(800, 15, 110, 20);
		dtxt.setEditable(false);
		String str = String.format("%1$td-%1$tb-%1$ty", new Date());
		dtxt.setText(str);
		add(dtxt);

		ttxt = new JTextField();
		Date today = new Date();

		ttxt.setText(DateFormat.getTimeInstance().format(today));
		ttxt.setFont(new Font("Times New Roman", Font.BOLD, 17));
		ttxt.setBackground(Color.CYAN);
		ttxt.setBounds(800, 55, 110, 20);
		ttxt.setEditable(false);
		add(ttxt);

		JMenuBar me = new JMenuBar();
		setJMenuBar(me);

		jb1 = new JMenu("About Project");
		jb7 = new JMenu("Placement_Information");
		jb2 = new JMenu("Training_Information");
		jb3 = new JMenu("Important_Information");
		jb4 = new JMenu("System");
		jb5 = new JMenu("Help");
		jb6 = new JMenu("Exit");

		me.add(jb1);
		me.add(jb7);
		me.add(jb2);
		me.add(jb3);
		me.add(jb4);
		me.add(jb5);
		me.add(jb6);

		JMenuItem jm1 = new JMenuItem("Introduction");
		jb1.add(jm1);

		JMenuItem e = new JMenuItem("Exit");
		jb6.add(e);
		jb1.addSeparator();

		JMenuItem jm2 = new JMenuItem("References");
		jb1.add(jm2);
		JMenuItem jm3 = new JMenuItem("Dpt_Details");
		jb2.add(jm3);
		JMenuItem jm6 = new JMenuItem("Candidate_Aggregate");
		jb3.add(jm6);
		JMenuItem jm5 = new JMenuItem("Change Password");
		jb4.add(jm5);
		JMenuItem jm8 = new JMenuItem("Agencies_Information");
		jb7.add(jm8);
		JMenuItem jm12 = new JMenuItem("Training_registration");
		jb7.add(jm12);
		JMenuItem jm10 = new JMenuItem("Help");
		jb5.add(jm10);

		e.addActionListener(this);
		jm1.addActionListener(this);
		jm2.addActionListener(this);
		jm3.addActionListener(this);
		jm12.addActionListener(this);
		jm5.addActionListener(this);
		jm6.addActionListener(this);
		jm8.addActionListener(this);
		jm10.addActionListener(this);

		btag = new JButton("Training Agency");
		btrg = new JButton("Training Regestration");
		btdp = new JButton("Training Dept.Information");
		bcp = new JButton("Candidate Performance");
		bsc = new JButton("ShortListed Candidates");
		bexit = new JButton("Exit");

		btag.setMnemonic('A');
		btrg.setMnemonic('R');
		btdp.setMnemonic('D');
		bcp.setMnemonic('C');
		bexit.setMnemonic('X');

		l10.setBounds(10, 10, 1000, 700);
		btrg.setBounds(375, 530, 200, 35);
		btag.setBounds(75, 530, 200, 35);
		btdp.setBounds(230, 600, 200, 35);
		bcp.setBounds(675, 530, 200, 35);

		bexit.setBounds(530, 600, 200, 35);

		add(btag);
		add(btrg);
		add(btdp);
		add(bcp);
		add(bexit);

		add(l10);

		btag.addActionListener(this);
		btrg.addActionListener(this);
		btdp.addActionListener(this);
		bcp.addActionListener(this);
		bsc.addActionListener(this);
		bexit.addActionListener(this);

		kit = Toolkit.getDefaultToolkit();
		screens = kit.getScreenSize();

		scrh = screens.height;
		scrw = screens.width;

		setVisible(true);
		setSize(scrw - 25, scrh - 50);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show();
	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		String s1 = "OK";
		String s2 = "CANCEL";

		if (str == "Training Agency") {
			Placement f = new Placement();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}
		if (str == "Training Regestration") {
			Tr_reg f = new Tr_reg();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}
		if (str == "Training Dept.Information") {
			Masterdetails01 f = new Masterdetails01();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}
		if (str == "Candidate Performance") {
			Cd_per f = new Cd_per();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}
		if (str == "Change Password") {
			Change_password cpw = new Change_password();
			cpw.setVisible(true);
			cpw.setSize(450, 250);
			cpw.setLocation(150, 150);
			cpw.show();
		} // if_logout
		if (str == "Exit") {
			JOptionPane.showMessageDialog(null, "ARE YOU WANT TO EXIT CLICK OK", "Alert", JOptionPane.OK_CANCEL_OPTION);
			if (str == "Exit")
				System.exit(0);
		}
		if (str == "Help") {
			Help f = new Help();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}
		if (str == "Agencies_Information") {
			Placement f = new Placement();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}
		if (str == "Dpt_Details") {
			Masterdetails01 f = new Masterdetails01();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}
		if (str == "Introduction") {
			Intro f = new Intro();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}
		if (str == "References") {
			Ref f = new Ref();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}

		if (str == "Candidate_Aggregate") {
			Cd_per f = new Cd_per();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}

		if (str == "Training_registration") {
			Tr_reg f = new Tr_reg();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
		}

	}

	public static void main(String args[]) {
		Menu1 m = new Menu1();

	}
}
