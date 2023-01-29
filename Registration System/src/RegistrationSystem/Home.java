//Group OOP-ing Members:
//Arianna Anding Aganduk BI20110271
//Muhammad Izzat Bin Jamal BI20110267
//Muhammad Adib Bin Suffian BI20110265
//Muhammad Afif Asyraaf Bin Sharri BI20110269

package RegistrationSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Home extends NewFrame implements ActionListener {

	static String clubName = "Programming";
	static String clubDesc = "The Best Club Ever!!";
	
	//JFrame frame1 = new JFrame();
	private JLabel titleName = new JLabel(clubName + " Club Registration System");
	private JLabel titleDesc = new JLabel(clubDesc);
	private JButton buttonRegister = new JButton("Member Register");
	private JButton buttonList = new JButton("Member List");
	private JButton buttonSettings = new JButton("Settings");

	Home() {

		// LABELS
		titleName.setHorizontalAlignment(SwingConstants.CENTER);
		titleName.setBounds(110, 47, 670, 50);
		titleName.setFont(new Font("Dialog", Font.BOLD, 24));
		this.getContentPane().add(titleName);
		
		titleDesc.setVerticalAlignment(SwingConstants.TOP);
		titleDesc.setHorizontalAlignment(SwingConstants.CENTER);
		titleDesc.setBounds(110, 100, 670, 88);
		titleDesc.setFont(new Font("Dialog", Font.ITALIC, 23));
		this.getContentPane().add(titleDesc);

		// BUTTONS
		buttonRegister.setBounds(110, 300, 200, 40);
		buttonRegister.setFocusable(false);
		buttonRegister.addActionListener(this);
		this.getContentPane().add(buttonRegister);

		buttonList.setBounds(580, 300, 200, 40);
		buttonList.setFocusable(false);
		buttonList.addActionListener(this);
		this.getContentPane().add(buttonList);

		buttonSettings.setBounds(400, 468, 100, 40);
		buttonSettings.setFocusable(false);
		buttonSettings.addActionListener(this);
		this.getContentPane().add(buttonSettings);

		// FRAME
		this.setTitle("Home");
	
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonRegister) {
			super.dispose();
			MemberRegister mRegister = new MemberRegister();
			
		} else if (e.getSource() == buttonList) {
			super.dispose();
			MemberList mList = new MemberList();
			
		} else if (e.getSource() == buttonSettings) {
			super.dispose();
			Settings settings = new Settings();
		}
	}
}
