package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
//import java.applet.*;
import javax.swing.*;
import java.util.*;

public class Intro extends JFrame implements ActionListener {
	public JPanel pane;
	public JButton b1, b2, b3;
	public TextArea t;
	String val;

	public Intro() {
		setTitle("Introduction");
		pane = (JPanel) getContentPane();
		pane.setLayout(null);

		JLabel j = new JLabel(" PROJECT INFORMATION ");
		j.setFont(new Font(" ", Font.BOLD, 16));
		j.setBounds(280, 11, 250, 50);
		pane.add(j);

		String val = "       " + "       " + "       " + "       " + "       " + " \n\nProject Title: HRMS Automation"
				+ "\n\n\n\nIntroduction:"

				+ "\nThe presented project here is made in view overcoming the problems faced by the any Export firm regarding Maintenance,"
				+ "\nRecording and keeping of Data base, Employee information, Financial transactions, Payroll system, Training, Recruitment etc. i.e."
				+ "\nGeneral HRMS Automation."

				+ "\nThis project is an Application Project i.e. HRMS Automation System."

				+ "\nApplication run in a local area network of client where as web site run in wide area networks i.e. World Wide Web."
				+ "\nApplication run on user defined window where as website works in a browser.Hence this project is an Application and not a portal/website."

				+ "\nThis project can be widely used in any Export firm which contain different departments with various employees having different designations, salary profiles etc."
				+ "\nBeside these it is very useful for the organizations having number of branches with a Head Branch connected by a LAN system through its other branches."
				+ "\nThese networks need a special kind of security feature. "

				+

				"\nObjective and Scope of the study:-  "

				+ "\nObjective of doing this project is to enhance my knowledge in the field of Distributed technology using J2EE and Oracle 8i. "
				+ "\nSome of the client requirement and objectives of this project is as under: -"

				+ "\nThe main objective of study: -"

				+

				"\n* It should contain all the information of Company."
				+ "\n* It should contain all the information of Company Infrastructure."
				+ "\n* It should contain all the information of Company Employees."
				+ "\n* It should contain all the information of Orders."
				+ "\n* It should contain all the information of Item in stock."

				+ "\n\n\nPURPOSE: -" +

				"\nComputerized HRMS Automation System is developed to facilitate the general administration system to manage "
				+ "\nthe various information of the employees and the processes involved in an export firm. So, that organization "
				+ "\ncan access accurate information quickly and easily as and when required, thereby improving its operational efficiency "
				+ "\n& effectiveness as well."

				+ "\n\nModule Description :-"

				+ "\n\n\nHRMS Automation comprises with the following modules:"

				+

				"\n\n1)	Manpower Planning System." + "\n\n2)	Training  & Planning System."
				+ "\n\n3)	Employee Information System" + "\n\n4)	Salary processing system "
				+ "\n\n5)	Attendance recording system."

				+

				"\nHere we will work on the first module 'Training and Planning System'"

				+

				" \n\n\nTraining division: -"
				+ "�	\nInstitute Training. It maintains all the details, information about the institute or company, which provide the training to the candidates or employees."

				+ "\n\n                 Following are the fields for training:-"

				+ "\n\n	Master Details."

				+ "�	\nInstitute Name." + "�	\nInstitute details." + "�	\nTraining criteria (training package)."
				+ "�	\nNo. of batches." + "�	\nNo. of candidate/batch."
				+ "�	\nDetails of the candidate in each batch." + "�	\nDuration of the training."
				+ "�	\nTraining program." + "�	\nCost of training." + "�	\nFaculty assigned for the batch."

				+

				"�	\n\n\nProfessional Training:- It maintain details of various training program undertaken by employee."

				+ "�	\nDepartment name." + "�	\nDepartment details." + "�	\nNo. of employees assigned/department."
				+ "�	\nName of training program." + "�	\nDuration of training." + "�	\nIn charge details."
				+ "�	\nCost of training." + "�	\nTraining criteria." + "�	\nTraining role."
				+ "�	\nEmployee details."

				+

				"�	\n\n\nTraining Program Master:-It contains the name of the training and all details under the particular training program."

				+ "     \n\n Required fields are:-"

				+ "	\nMaster Details." + "�	\nInstitute/Department Name." + "�	\nInstitute/Department details"
				+ "�	\nTraining criteria (training package)." + ".	\nDetails of the candidate"
				+ "�	\nDuration of the training." + "�	\nTraining program." + "�	\nCost of training."
				+ "�	\nPerson assigned for the training." + "�	\nNo. of employees assigned/department."
				+ "�	\nName of training program." + "�	\nTraining role (for which post)."

				+

				"�	\n\n\nPlan:-We can entered training plan/need and duration of training required for employee."

				+ "\nRequired fields are:-"

				+ "�	\nTraining name." + "�	\nObjective of the training." + "�	\nDuration of training."
				+ "�	\nRequired employees." + "�	\nEmployee's details." + "�	\nCriteria for training."
				+ "�	\nEmployee assigned for training/In charge." + "�	\nIn charge details." + "�	\nModification."
				+ "�	\nTrainee data bank."

				+ "�	\n\n\nExecution of training: - In this option details of training undertaken by employee and their performance is entered."

				+ " Required fields are: -" + "�	\nTraining name." + "�	\nTraining status."
				+ "�	\nPerformance of the employee." + "�	\nResult of the training." +

				"\n\n\nTraining and Planning (Recruitment)"

				+

				"\n\nRECRUITMENT PROCESS"

				+ "	\n		Recruitment Process is one of the eras of HRMS."
				+ "\nRecruitment of the employee is not very easy job choosing suitable candidate from the lot of candidate. This selection process is not single step process but consists of multiple processes, which involves different methods of recruitment, maintenance of lot of records."
				+

				"\nThis Recruitment process can be divided in the two groups"

				+

				"	\n			Internal Recruitment" + "	\n			External Recruitment" +

				"\n\nINTERNAL RECRUITMENT"

				+

				"\n\nInternal Recruitment basically consider with the Recruiting the person internally in an organization this may be giving promotion to the existing employee or recruiting the person by internal reference and this is not very big deal."
				+

				"\nEXTERNAL RECRUITMENT"

				+ "	\n		External Recruitment is not very easy task. There are different methods of recruiting the person."
				+

				"\n				Giving Advertisement" + "	\n			Placement Agencies"
				+ "	\n			Earlier Applied" +

				"\nBody Shoppers" +

				"\n\nThis Recruitment Process is not a single step process this may contain several steps like"

				+

				"\n				Precheck" + "	\n			Initial Interview" + "	\n			Written"
				+ "	\n			Final Interview" +

				"\n\n\nINPUT OUTPUT FORMS"

				+ "\n1.Job requirement form" + "\n2.Skill input form" + "\n3.Job skill requirement"
				+ "\n4.Advertisement form" + "\n5.Placement agencies record form" + "\n6.Body shopper's form"
				+ "\n7.Short listed candidate" + "\n8.Candidate Performance."

				+

				"\n\n\nTABLE STRUCTURE"

				+

				"\n\nJob_Requirement"

				+

				"\nField name      Data type           Size		     Remark"
				+ "\njid			   Number		           3      Primary key"
				+ "\njname		   Varchar2      	      20" + "\njexperince	   number		          2"
				+ "\njvaccancies	   number		          4" + "\njlocation	   varchar2		          20"
				+ "\njdno			   number		          2" + "\nqualification   Varchar2		          20"

				+

				"\n\nSkills"

				+ "\nField name     data type       size		type" + "\nsid			  varchar2			5"
				+ "\nsname		  varchar2			10"

				+

				"\n\nJob_skills"

				+ "\nField name     data type      size		type" + "\njid			number		 	 3"
				+ "\nsid			varchar2	  	 5" + "\nyr_of_exp	number		  	 2"

				+

				"\n\nAdvertisement"

				+ "\nField name      data type      size		type" + "\nadid			  varchar2	    	5"
				+ "\njid			  varchar2	    	10"

				+

				"\n\nCandidateperformance" +

				"\nField name		    Data type		Size		Remark" + "\nInitial_interview	Number		    3"
				+ "\nWritten		        Number	    	3" + "\nFinal_interview	    Number	    	3"
				+ "\nDescription		    Varchar2		200";

		t = new TextArea(10, 6);
		t.setText(val);
		t.setBounds(30, 50, 700, 450);
		t.setBackground(new java.awt.Color(204, 230, 255));
		t.setForeground(Color.black);
		Font f2 = new Font("monospace", Font.PLAIN, 15);
		t.setFont(f2);
		t.setEnabled(true);

		b1 = new JButton("Cancel");

		pane.add(b1);

		b1.setBounds(300, 520, 100, 30);

		b1.setFont(f2);

		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);

		pane.add(t);
		b1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent a) {

		String s3 = "Cancel";
		String str = a.getActionCommand();

		if (s3.equals(str)) {
			this.dispose();
			Menu1 p = new Menu1();
		}
	}

	public static void main(String args[]) {
		Intro f = new Intro();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}