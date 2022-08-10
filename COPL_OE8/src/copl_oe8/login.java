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
	public JTextField txtUsername;
	public String USERNAME;
	public JPasswordField txtPassword;
	private JPasswordField txtPassword2;
	private JLabel lblPassword2;
	private JButton btnReg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.loginframe.setVisible(true);
					window.txtPassword2.setVisible(false);
					window.lblPassword2.setVisible(false);
					window.btnReg.setVisible(false);
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
		loginframe.getContentPane().setBackground(Color.WHITE);
		loginframe.setTitle("Sign In");
		loginframe.setBounds(100, 100, 669, 500);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblUsername.setBounds(93, 149, 106, 47);
		loginframe.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel(" Password:");
		lblPassword.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblPassword.setBounds(93, 224, 98, 42);
		loginframe.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(UIManager.getBorder("TextField.border"));
		txtUsername.setBounds(207, 149, 329, 42);
		loginframe.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblOutcomesEvalution = new JLabel("COPL Finals Exam");
		lblOutcomesEvalution.setFont(new Font("Palatino Linotype", Font.BOLD, 34));
		lblOutcomesEvalution.setBounds(188, 28, 301, 57);
		loginframe.getContentPane().add(lblOutcomesEvalution);
		
		JLabel lblDev = new JLabel("-by John Brent David");
		lblDev.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev.setBounds(336, 57, 179, 42);
		loginframe.getContentPane().add(lblDev);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(207, 222, 329, 42);
		loginframe.getContentPane().add(txtPassword);
		
		btnReg = new JButton("REGISTER");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtUsername.getText().trim().equals("")&& !txtPassword.getText().trim().equals("")&& !txtPassword2.getText().trim().equals(""))	{
					if(txtPassword.getText().trim().equals(txtPassword2.getText()))	{
						if(!Verify()) {
							Register();
						}
						else
							JOptionPane.showMessageDialog(null, "Username is already taken!");
					}else {
						JOptionPane.showMessageDialog(null,"Password fields does not match!");
					}
				}
				else 
					JOptionPane.showMessageDialog(null,"All text fields should be filled!");
				
			}
		});
		btnReg.setBorder(UIManager.getBorder("Button.border"));
		btnReg.setBackground(UIManager.getColor("Button.highlight"));
		btnReg.setBounds(278, 357, 124, 57);
		
		loginframe.getContentPane().add(btnReg);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBorder(UIManager.getBorder("Button.border"));
		btnClear.setBackground(UIManager.getColor("Button.highlight"));
		btnClear.setBounds(412, 357, 124, 57);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					txtUsername.setText("");
					txtPassword.setText("");
					txtPassword2.setText("");
				}catch(Exception ex) {
					System.out.print(ex);
				}
			}
		});
		loginframe.getContentPane().add(btnClear);
	
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBorder(UIManager.getBorder("Button.border"));
		btnLogin.setBackground(UIManager.getColor("Button.highlight"));
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
						greet welcome = new greet(username);
						welcome.frame.setVisible(true);
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
		btnLogin.setBounds(278, 357, 124, 57);
		loginframe.getContentPane().add(btnLogin);
		
		txtPassword2 = new JPasswordField();
		txtPassword2.setBounds(207, 302, 329, 42);
		loginframe.getContentPane().add(txtPassword2);
		
		lblPassword2 = new JLabel(" Retype Password:");
		lblPassword2.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblPassword2.setBounds(24, 304, 167, 42);
		loginframe.getContentPane().add(lblPassword2);
		
		JButton btnChange = new JButton("Sign Up");
		btnChange.setBackground(UIManager.getColor("Button.highlight"));
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnChange.getText().equals("Sign Up"))	{
					txtPassword2.setVisible(true);
					lblPassword2.setVisible(true);
					btnReg.setVisible(true);	
					btnChange.setText("Sign In");
					loginframe.setTitle("Sign Up");
					btnLogin.setVisible(false);
				}
				else if (btnChange.getText().equals("Sign In")) {
					txtPassword2.setVisible(false);
					lblPassword2.setVisible(false);
					btnReg.setVisible(false);	
					btnChange.setText("Sign Up");
					loginframe.setTitle("Sign In");
					btnLogin.setVisible(true);
				}
			}
		});
		btnChange.setBounds(547, 28, 98, 47);
		loginframe.getContentPane().add(btnChange);
		
	}//end of object
	public boolean Verify() {
		try {
			//set the mysql jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			//set the mysql connection
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/copl_db","root","");
			Statement st = (Statement) con.createStatement();
			
			//sql query for register
			String username = txtUsername.getText();
				String sql = "SELECT * FROM users_tbl WHERE username ='"+username+"'";
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
					return true;
				}else
					return false;
				
		}catch(Exception ex) {
			System.out.print(ex);
		}
		return false;
		
	}//end of verify method
	public void Register() {
		try {
			//set the mysql jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			//set the mysql connection
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/copl_db","root","");
			Statement st = (Statement) con.createStatement();
			
			//sql query for register
			String username = txtUsername.getText();
			String password = txtPassword.getText();
			String sql = "INSERT INTO users_tbl (username,password) VALUES ('"+username+"','"+password+"')";
			st.execute(sql);
			JOptionPane.showMessageDialog(null, "Record Successfully SAVED!");
			txtUsername.setText("");
			txtPassword.setText("");
			txtPassword2.setText("");
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}//end of  register method
}//end of class
