package copl_oe8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;

public class dashboard {

	public JFrame dashframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard window = new dashboard("ANONYMOUS");
					window.dashframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dashboard(String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username) {
		dashframe = new JFrame();
		dashframe.setTitle("Welcome");
		dashframe.setBounds(100, 100, 652, 278);
		dashframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashframe.getContentPane().setLayout(null);
		
		JLabel lblOutcomesEvalution = new JLabel("OUTCOMES EVALUTION 8");
		lblOutcomesEvalution.setBorder(UIManager.getBorder("TextField.border"));
		lblOutcomesEvalution.setFont(new Font("Palatino Linotype", Font.BOLD, 34));
		lblOutcomesEvalution.setBounds(75, 26, 473, 66);
		dashframe.getContentPane().add(lblOutcomesEvalution);
		
		JLabel lblDev = new JLabel("-by John Brent David");
		lblDev.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev.setBounds(383, 58, 179, 42);
		dashframe.getContentPane().add(lblDev);
		
		JLabel lblWelcome = new JLabel("Welcome "+username+"!");
		lblWelcome.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblWelcome.setBounds(75, 115, 463, 57);
		dashframe.getContentPane().add(lblWelcome);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBorder(UIManager.getBorder("Button.border"));
		btnLogout.setBackground(new Color(100, 149, 237));
		btnLogout.setBounds(424, 154, 124, 57);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					login log = new login();
					log.loginframe.setVisible(true);
					dashframe.dispose();
				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		dashframe.getContentPane().add(btnLogout);
	}

}
