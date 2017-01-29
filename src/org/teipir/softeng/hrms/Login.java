package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	public JTextField t1;
	public TextField t2;
	public JLabel l1, l2, l3;
	public JButton b1, b2;
	public JPanel panel;
	public Font g;

	public Login() {

		super("LOGIN SCREEN ");
		g = new Font("Georgia", Font.BOLD, 25);
		getContentPane().setBackground(Color.lightGray);
		panel = (JPanel) getContentPane();
		panel.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("d.gif");
		JLabel l10 = new JLabel(img);
		l1 = new JLabel(" LOGIN FORM ");
		l1.setForeground(Color.BLACK);
		l2 = new JLabel("LOGIN");
		l2.setFont(new Font("Georgia", Font.BOLD, 15));
		l3 = new JLabel("PASSWORD");
		l3.setFont(new Font("Georgia", Font.BOLD, 15));
		t1 = new JTextField(20);
		t2 = new TextField(20);
		t2.setEchoChar('+');
		b1 = new JButton("OK");
		b2 = new JButton("EXIT");

		panel.add(l1);
		l1.setFont(g);
		panel.add(l2);
		panel.add(l3);

		panel.add(t1);
		panel.add(t2);
		panel.add(b1);
		panel.add(b2);
		panel.add(l10);

		l10.setBounds(300, 60, 200, 100);
		l1.setBounds(160, 0, 270, 90);
		l2.setBounds(30, 80, 100, 30);
		l3.setBounds(30, 130, 100, 30);

		t1.setBounds(140, 80, 150, 30);
		t2.setBounds(140, 130, 150, 30);

		b1.setBounds(140, 180, 60, 30);
		b2.setBounds(220, 180, 65, 30);

		t1.addActionListener(this);
		t2.addActionListener(this);

		b1.addActionListener(this);
		b2.addActionListener(this);
		setLocation(150, 100);

	}

	public void actionPerformed(ActionEvent a) {
		String s1 = "u";
		String s2 = "u";
		String s3 = "OK";
		String s4 = "EXIT";
		String str = a.getActionCommand();

		if (s3.equals(str)) {
			if (s1.equals(t1.getText()) && s2.equals(t2.getText())) {
				this.dispose();
				Menu1 p = new Menu1();
				p.setVisible(true);
				p.show();
				this.dispose();
			} else {
				if (s3.equals(str)) {
					t1.setText("");
					t2.setText("");
					JOptionPane.showMessageDialog(null, "Please varify the correct Login and Password", "Warning",
							JOptionPane.OK_CANCEL_OPTION);
				}
			}
		}

		if (str == "EXIT") {
			JOptionPane.showMessageDialog(null, "The project is still in progress,do u want to quit now", "Warning",
					JOptionPane.OK_CANCEL_OPTION);
			if (s4.equals(str)) {
				System.exit(0);
			}
			repaint();
		}

	}

	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Login f = new Login();
		f.setVisible(true);
		f.setSize(550, 300);
		f.show();
	}

}
