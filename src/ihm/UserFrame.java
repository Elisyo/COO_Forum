package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import domain.User;

import persistence.MySqlConnection;

public class UserFrame extends JFrame{

	public UserFrame(final MySqlConnection mySql, User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(400,300);
		
		JButton cancel = new JButton("Annuler");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionFrame frame = new ConnectionFrame(mySql);
				try {
					mySql.closeConnection();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.setVisible(true);
				dispose();
			}
		});
		this.add(cancel);
	}
	
}
