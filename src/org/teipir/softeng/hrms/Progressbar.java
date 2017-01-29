package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Progressbar extends JFrame implements ActionListener {
	static ProgressMonitor pbar;
	static int counter = 0;
	JButton b = new JButton("Click here");

	public Progressbar() {
		super("Progress Monitor Demo");
		setSize(300, 400);
		pbar = new ProgressMonitor(null, "Monitor Progress", "Initializing....", 0, 100);
		Timer t = new Timer(250, this);
		t.start();
		setVisible(true);
	}

	public static void main(String args[]) {
		UIManager.put("Progressbar.progressText", "HRMS System");
		UIManager.put("OptionPane.cancelButtonText", "QUIT");
		new Progressbar();
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Update());
		if (counter == 100) {
			b.setEnabled(false);
			this.dispose();
		}
	}

	class Update implements Runnable {
		public void run() {
			if (pbar.isCanceled()) {
				pbar.close();
				System.exit(1);
			}
			pbar.setProgress(counter);
			pbar.setNote("Operation Is " + counter + " % Completed");
			counter += 2;
		}
	}
}
