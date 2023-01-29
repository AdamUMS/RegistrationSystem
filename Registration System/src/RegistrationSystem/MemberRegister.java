//Group OOP-ing Members:
//Arianna Anding Aganduk BI20110271
//Muhammad Izzat Bin Jamal BI20110267
//Muhammad Adib Bin Suffian BI20110265
//Muhammad Afif Asyraaf Bin Sharri BI20110269

package RegistrationSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class MemberRegister extends NewFrame implements ActionListener {

	// JFrame frame1 = new JFrame();

	private JLabel labelTitle = new JLabel("Member Register");

	private JButton buttonAdd = new JButton("Add");
	private JButton buttonRemove = new JButton("Remove");
	private JButton buttonCancel = new JButton("Cancel");
	private JButton buttonDisplay = new JButton("Display");

	private JTextField tfName = new JTextField();
	private JTextField tfNoIC = new JTextField();
	private JTextField tfNoMatric = new JTextField();
	private JTextField tfPhone = new JTextField();
	private JTextField tfEmail = new JTextField();
	private JTextField tfDate = new JTextField();

	String[] gender = { "Male", "Female" };
	JComboBox cbGender = new JComboBox(gender);
	String[] position = { "President", "Vice-President", "Treasure", "AJK", "Member" };
	JComboBox cbPosition = new JComboBox(position);

	JScrollPane scrollPane = new JScrollPane();
	JTable tableMember = new JTable();
	static DefaultTableModel model = new DefaultTableModel();
	static Object[] columns = { "Name", "Gender", "NoIC", "NoMatrics", "NoPhone", "Email", "Date", "Position" };
	static Object[] row = new Object[8];

	MemberRegister() {

		// TITLE LABEL
		labelTitle.setBounds(187, 0, 500, 50);
		labelTitle.setFont(new Font(null, Font.PLAIN, 24));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

		// TEXTFIELD
		tfName.setBounds(187, 80, 168, 20);
		this.getContentPane().add(tfName);

		tfNoIC.setBounds(187, 140, 168, 20);
		this.getContentPane().add(tfNoIC);

		tfNoMatric.setBounds(187, 172, 168, 20);
		this.getContentPane().add(tfNoMatric);

		tfPhone.setBounds(562, 80, 188, 20);
		this.getContentPane().add(tfPhone);

		tfEmail.setBounds(562, 111, 188, 20);
		this.getContentPane().add(tfEmail);

		tfDate.setBounds(562, 140, 188, 20);
		this.getContentPane().add(tfDate);

		// CREATE COMBO BOX
		cbGender.setBounds(187, 107, 168, 22);
		cbPosition.setBounds(562, 171, 188, 22);
		cbGender.getActionListeners();
		cbPosition.getActionListeners();
		this.getContentPane().add(cbGender);
		this.getContentPane().add(cbPosition);

		// QUERY LABEL
		JLabel labelName = new JLabel("Name:");
		labelName.setBounds(30, 83, 50, 14);
		this.getContentPane().add(labelName);

		JLabel labelGender = new JLabel("Gender:");
		labelGender.setBounds(30, 114, 50, 14);
		this.getContentPane().add(labelGender);

		JLabel labelNoIC = new JLabel("No IC (xxxxxx-xx-xxxx):");
		labelNoIC.setBounds(30, 143, 140, 14);
		this.getContentPane().add(labelNoIC);

		JLabel labelNoMatric = new JLabel("No Matric:");
		labelNoMatric.setBounds(30, 175, 58, 14);
		this.getContentPane().add(labelNoMatric);

		JLabel labelPhone = new JLabel("Phone (01x-xxxxxx):");
		labelPhone.setBounds(439, 83, 130, 14);
		this.getContentPane().add(labelPhone);

		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(439, 114, 50, 14);
		this.getContentPane().add(labelEmail);

		JLabel labelDate = new JLabel("Date (DD-MM-YY):");
		labelDate.setBounds(439, 143, 100, 14);
		this.getContentPane().add(labelDate);

		JLabel lblNewLabel_5 = new JLabel("Position:");
		lblNewLabel_5.setBounds(439, 175, 50, 14);
		this.getContentPane().add(lblNewLabel_5);

		// CREATE TABLE
		model.setColumnIdentifiers(columns);
		MemberList.model2.setColumnIdentifiers(columns);
		

		scrollPane.setBounds(10, 306, 864, 244);
		scrollPane.setViewportView(tableMember);
		this.getContentPane().add(scrollPane);

		tableMember.setModel(model);
		tableMember.setBackground(Color.white);
		tableMember.setForeground(Color.black);
		tableMember.setSelectionBackground(Color.red);
		tableMember.setSelectionForeground(Color.white);
		tableMember.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableMember.setGridColor(Color.black);
		tableMember.setRowHeight(30);
		tableMember.setAutoCreateRowSorter(true);

		// ADD BUTTON
		buttonAdd.setBounds(285, 266, 89, 23);
		buttonAdd.setFocusable(false);
		buttonAdd.addActionListener(this);
		this.getContentPane().add(buttonAdd);

		// REMOVE BUTTON
		buttonRemove.setBounds(385, 266, 89, 23);
		buttonRemove.setFocusable(false);
		buttonRemove.addActionListener(this);
		this.getContentPane().add(buttonRemove);

		// DISPLAY BUTTON
		buttonDisplay.setBounds(510, 266, 89, 23);
		buttonDisplay.setFocusable(false);
		buttonDisplay.addActionListener(this);
		this.getContentPane().add(buttonDisplay);

		// CANCEL BUTTON
		buttonCancel.setBounds(610, 266, 89, 23);
		buttonCancel.setFocusable(false);
		buttonCancel.addActionListener(this);
		this.getContentPane().add(buttonCancel);

		// CREATE FRAME
		this.setTitle("Member Register");

		this.setVisible(true);

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonAdd) {
			row[0] = tfName.getText();
			row[1] = cbGender.getSelectedItem();
			row[2] = tfNoIC.getText();
			row[3] = tfNoMatric.getText();
			row[4] = tfPhone.getText();
			row[5] = tfEmail.getText();
			row[6] = tfDate.getText();
			row[7] = cbPosition.getSelectedItem();
			model.addRow(row);
			MemberList.model2.addRow(row);
			JOptionPane.showMessageDialog(null, "Added Successfully!");
		}

		if (e.getSource() == buttonRemove) {
			int i = tableMember.getSelectedRow();
			if (i >= 0) {
				model.removeRow(i);
				MemberList.model2.removeRow(i);
				JOptionPane.showMessageDialog(null, "Removed successfully!");
			} else {
				JOptionPane.showMessageDialog(null, "Please select a row first!");
			}
		}

		if (e.getSource() == buttonDisplay) {
			super.dispose();
			MemberList mList = new MemberList();
		}

		if (e.getSource() == buttonCancel) {
			super.dispose();
			Home home = new Home();

		}
	}
}
