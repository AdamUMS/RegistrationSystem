//Group OOP-ing Members:
//Arianna Anding Aganduk BI20110271
//Muhammad Izzat Bin Jamal BI20110267
//Muhammad Adib Bin Suffian BI20110265
//Muhammad Afif Asyraaf Bin Sharri BI20110269

package RegistrationSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Settings extends NewFrame implements ActionListener {

	//JFrame frame1 = new JFrame();
	private JLabel labelTitle = new JLabel("Settings");
	private JLabel labelClubName = new JLabel("Club Name:");
	private JLabel labelClubDesc = new JLabel("Club Desc:");
	private JLabel labelReset = new JLabel("Reset System?");

	private JButton buttonSave = new JButton("Save");
	private JButton buttonCancel = new JButton("Back");
	private JButton buttonReset = new JButton("Reset");

	private JTextField tfClubName = new JTextField();
	private JTextField tfClubDesc = new JTextField();

	Settings() {

		// LABELS
		labelTitle.setBounds(10, 0, 500, 50);
		labelTitle.setFont(new Font(null, Font.PLAIN, 24));
		this.getContentPane().add(labelTitle);

		labelClubName.setBounds(32, 95, 93, 26);
		labelClubName.setFont(new Font(null, Font.PLAIN, 15));
		this.getContentPane().add(labelClubName);

		labelClubDesc.setBounds(32, 145, 100, 26);
		labelClubDesc.setFont(new Font(null, Font.PLAIN, 15));
		this.getContentPane().add(labelClubDesc);

		labelReset.setHorizontalAlignment(SwingConstants.LEFT);
		labelReset.setBounds(32, 284, 138, 26);
		labelReset.setFont(new Font("Arial", Font.PLAIN, 15));
		this.getContentPane().add(labelReset);

		// TEXTFIELDS
		tfClubName.setBounds(142, 100, 200, 20);
		tfClubDesc.setBounds(142, 150, 200, 20);
		this.getContentPane().add(tfClubName);
		this.getContentPane().add(tfClubDesc);

		// BUTTONS
		buttonCancel.setBounds(550, 330, 100, 20);
		buttonCancel.setFocusable(false);
		buttonCancel.addActionListener(this);
		this.getContentPane().add(buttonCancel);

		buttonSave.setBounds(242, 202, 100, 20);
		buttonSave.setFocusable(false);
		buttonSave.addActionListener(this);
		this.getContentPane().add(buttonSave);

		buttonReset.setBounds(42, 319, 100, 20);
		buttonReset.setFocusable(false);
		buttonReset.addActionListener(this);
		this.getContentPane().add(buttonReset);

		//FRAMES
		this.setTitle("Settings");
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonSave) {
			if (tfClubName.getText().equals("") && tfClubDesc.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Both fields are empty!");

			} else if (tfClubDesc.getText().equals("")) {
				this.setClubName(tfClubName.getText());
				JOptionPane.showMessageDialog(null, "Club Name Saved Successfully!");

			} else if (tfClubName.getText().equals("")) {
				this.setClubDesc(tfClubDesc.getText());
				JOptionPane.showMessageDialog(null, "Club Description Saved Successfully!");

			} else {
				this.setClubName(tfClubName.getText());
				this.setClubDesc(tfClubDesc.getText());

				JOptionPane.showMessageDialog(null, "Saved Successfully!");
			}

		} else if (e.getSource() == buttonReset) {

			//DEFAULT SETTINGS
			this.setClubName("Programming");
			this.setClubDesc("The Best Club Ever!!");
			
			String[] option= {"Confirm", "Cancel"};
			int answer = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, 0);
			
			if (answer == 0) {

				MemberRegister.model.setRowCount(0);
				MemberList.model2.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Reset Successfully!");
			}

		} else if (e.getSource() == buttonCancel) {
			this.dispose();
			Home home = new Home();
		}

	}

	public void setClubName(String clubName) {
		Home.clubName = clubName;
	}

	public void setClubDesc(String clubDesc) {
		Home.clubDesc = clubDesc;
	}
}