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

public class MemberList extends NewFrame implements ActionListener {
	
	//JFrame frame1 = new JFrame();
	private JLabel labelTitle = new JLabel("Member List");
	private JLabel labelRowCount = new JLabel("Total Members: " + model2.getRowCount());
	private JButton buttonCancel = new JButton("Back");
	private JButton buttonEdit = new JButton("Add/Remove");

	private JScrollPane scrollPane = new JScrollPane();
	static JTable tableMember;
	static DefaultTableModel model2 = new DefaultTableModel();

	MemberList() {

		// LABELS
		labelTitle.setBounds(10, 0, 500, 50);
		labelTitle.setFont(new Font(null, Font.PLAIN, 24));
		this.getContentPane().add(labelTitle);

		labelRowCount.setBounds(10, 490, 200, 20);
		this.getContentPane().add(labelRowCount);

		// BUTTONS
		buttonCancel.setBounds(627, 510, 100, 20);
		buttonCancel.setFocusable(false);
		buttonCancel.addActionListener(this);
		this.getContentPane().add(buttonCancel);

		buttonEdit.setBounds(746, 510, 114, 20);
		buttonEdit.setFocusable(false);
		buttonEdit.addActionListener(this);
		this.getContentPane().add(buttonEdit);

		// CREATE TABLE
		model2.setColumnIdentifiers(MemberRegister.columns);

		scrollPane.setBounds(10, 46, 864, 430);
		this.getContentPane().add(scrollPane);

		tableMember = new JTable();
		scrollPane.setViewportView(tableMember);
		tableMember.setModel(model2);

		tableMember.setBackground(Color.white);
		tableMember.setForeground(Color.black);
		tableMember.setSelectionBackground(Color.red);
		tableMember.setSelectionForeground(Color.white);
		tableMember.setFont(new Font("Tahoma", Font.PLAIN, 13));

		tableMember.setGridColor(Color.black);
		tableMember.setRowHeight(30);
		tableMember.setAutoCreateRowSorter(true);

		// FRAME
		this.setSize(900, 600);
		this.setTitle("Member List");
		
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonCancel) {
			super.dispose();
			Home home = new Home();

		} else if (e.getSource() == buttonEdit) {
			super.dispose();
			MemberRegister mRegister = new MemberRegister();
		}

	}
}