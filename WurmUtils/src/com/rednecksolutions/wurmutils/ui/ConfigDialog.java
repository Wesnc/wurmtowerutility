package com.rednecksolutions.wurmutils.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConfigDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public final JTextField tfPlayer;
	public String directory = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigDialog dialog = new ConfigDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigDialog() {
		setTitle("Config Utility");
		setBounds(100, 100, 450, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 0;
			gbc_horizontalStrut.gridy = 0;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			JLabel lblWurmDirectory = new JLabel("Wurm Directory:");
			GridBagConstraints gbc_lblWurmDirectory = new GridBagConstraints();
			gbc_lblWurmDirectory.anchor = GridBagConstraints.WEST;
			gbc_lblWurmDirectory.insets = new Insets(0, 0, 5, 5);
			gbc_lblWurmDirectory.gridx = 1;
			gbc_lblWurmDirectory.gridy = 0;
			contentPanel.add(lblWurmDirectory, gbc_lblWurmDirectory);
		}
		{
			JLabel lblDir = new JLabel("Empty");
			GridBagConstraints gbc_lblDir = new GridBagConstraints();
			gbc_lblDir.anchor = GridBagConstraints.WEST;
			gbc_lblDir.insets = new Insets(0, 0, 5, 5);
			gbc_lblDir.gridx = 2;
			gbc_lblDir.gridy = 0;
			contentPanel.add(lblDir, gbc_lblDir);
		}
		{
			JButton btnChooseDirectory = new JButton("Choose Directory");
			GridBagConstraints gbc_btnChooseDirectory = new GridBagConstraints();
			gbc_btnChooseDirectory.insets = new Insets(0, 0, 5, 0);
			gbc_btnChooseDirectory.gridwidth = 3;
			gbc_btnChooseDirectory.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnChooseDirectory.gridx = 1;
			gbc_btnChooseDirectory.gridy = 1;
			contentPanel.add(btnChooseDirectory, gbc_btnChooseDirectory);
			
			btnChooseDirectory.addActionListener(new ActionListener() {
				
				
				@Override public void actionPerformed(ActionEvent evt) {
					final JFileChooser fc = new JFileChooser();
					
					int option = fc.showOpenDialog(null);
					if(option == JFileChooser.APPROVE_OPTION)
					{
						File file = fc.getSelectedFile();
						directory = file.getAbsolutePath();
						System.out.println("Directory: "+ directory);
					}
				}
			});
		}
		{
			JLabel lblSelectedPlayer = new JLabel("Selected Player:");
			GridBagConstraints gbc_lblSelectedPlayer = new GridBagConstraints();
			gbc_lblSelectedPlayer.anchor = GridBagConstraints.EAST;
			gbc_lblSelectedPlayer.insets = new Insets(0, 0, 0, 5);
			gbc_lblSelectedPlayer.gridx = 1;
			gbc_lblSelectedPlayer.gridy = 3;
			contentPanel.add(lblSelectedPlayer, gbc_lblSelectedPlayer);
		}
		{
			tfPlayer = new JTextField();
			GridBagConstraints gbc_tfPlayer = new GridBagConstraints();
			gbc_tfPlayer.insets = new Insets(0, 0, 0, 5);
			gbc_tfPlayer.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfPlayer.gridx = 2;
			gbc_tfPlayer.gridy = 3;
			contentPanel.add(tfPlayer, gbc_tfPlayer);
			tfPlayer.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
