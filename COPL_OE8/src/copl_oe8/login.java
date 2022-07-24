package copl_oe8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class login {

	public JFrame loginframe;
	private JTextField txtUsername;
	public String USERNAME;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginframe = new JFrame();
		loginframe.setTitle("Login");
		loginframe.setBounds(100, 100, 669, 500);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblUsername.setBounds(93, 149, 106, 47);
		loginframe.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel(" Password:");
		lblPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblPassword.setBounds(93, 250, 98, 42);
		loginframe.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(UIManager.getBorder("TextPane.border"));
		txtUsername.setBounds(207, 149, 329, 42);
		loginframe.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBorder(UIManager.getBorder("Button.border"));
		btnLogin.setBackground(new Color(100, 149, 237));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
				//set the mysql jdbc driver
					Class.forName("com.mysql.jdbc.Driver");
				//set the mysql connection string
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/copl_db","root","");
					Statement stmt = (Statement) con.createStatement();
					
				//sql query for the login
					String username = txtUsername.getText();
					String password = txtPassword.getText();
					String sql = "SELECT * FROM users_tbl WHERE username='"+username+"'AND password='"+password+"'";
				//Execute the query
					ResultSet rs =((java.sql.Statement) stmt).executeQuery(sql);
					
				//condition for the username and password
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null, "Login successful...","Login Alert",2);
						USERNAME = txtUsername.getText();
						dashboard welcome = new dashboard(USERNAME);
						welcome.dashframe.setVisible(true);
						loginframe.dispose();
						
					}
					else if(txtUsername.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Username is required...","Login Warning",2);
					}
					else if(txtPassword.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Password is required...","Login Warning",2);
					}
					else {
						JOptionPane.showMessageDialog(null, "Username or Password incorrect...","Login Warning",2);
					}
				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		btnLogin.setBounds(278, 341, 124, 57);
		loginframe.getContentPane().add(btnLogin);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setBorder(UIManager.getBorder("Button.border"));
		btnClose.setBackground(new Color(100, 149, 237));
		btnClose.setBounds(412, 341, 124, 57);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					loginframe.dispose();
				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		loginframe.getContentPane().add(btnClose);
		
		JLabel lblOutcomesEvalution = new JLabel("OUTCOMES EVALUTION 8");
		lblOutcomesEvalution.setFont(new Font("Palatino Linotype", Font.BOLD, 34));
		lblOutcomesEvalution.setBounds(86, 25, 473, 57);
		loginframe.getContentPane().add(lblOutcomesEvalution);
		
		JLabel lblDev = new JLabel("-by John Brent David");
		lblDev.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev.setBounds(398, 55, 179, 42);
		loginframe.getContentPane().add(lblDev);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(207, 248, 329, 42);
		loginframe.getContentPane().add(txtPassword);
		
	
	}
}
