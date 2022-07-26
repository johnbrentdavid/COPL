package copl_oe8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class dashboard {

	public JFrame dashframe;
	private JTable tableView;
	private JTextField txtStudentnum;
	private JTextField txtStudentname;
	private JTextField txtAddress;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard window = new dashboard("ANONYMOUS");
					window.dashframe.setVisible(true);
					window.viewRecord();
					
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
		dashframe.setTitle("Student Records");
		dashframe.setBounds(100, 100, 996, 595);
		dashframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashframe.getContentPane().setLayout(null);
		
		JLabel lblOutcomesEvalution = new JLabel("Student Record System");
		lblOutcomesEvalution.setBorder(null);
		lblOutcomesEvalution.setFont(new Font("Palatino Linotype", Font.BOLD, 34));
		lblOutcomesEvalution.setBounds(102, 12, 368, 66);
		dashframe.getContentPane().add(lblOutcomesEvalution);
		
		JLabel lblDev = new JLabel("-by John Brent David");
		lblDev.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev.setBounds(324, 45, 179, 42);
		dashframe.getContentPane().add(lblDev);
		
		JLabel lblWelcome = new JLabel("Login as: "+username);
		lblWelcome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcome.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblWelcome.setBounds(485, 12, 368, 50);
		dashframe.getContentPane().add(lblWelcome);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBorder(UIManager.getBorder("Button.border"));
		btnLogout.setBackground(new Color(100, 149, 237));
		btnLogout.setBounds(863, 12, 109, 42);
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
		
		tableView = new JTable();
		tableView.setBounds(411, 177, 561, 371);
		dashframe.getContentPane().add(tableView);
		
		
		txtStudentnum = new JTextField();
		txtStudentnum.setBounds(150, 177, 251, 42);
		dashframe.getContentPane().add(txtStudentnum);
		txtStudentnum.setColumns(10);
		
		txtStudentname = new JTextField();
		txtStudentname.setColumns(10);
		txtStudentname.setBounds(150, 247, 251, 42);
		dashframe.getContentPane().add(txtStudentname);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(150, 319, 251, 42);
		dashframe.getContentPane().add(txtAddress);
		txtStudentnum.setText("");txtStudentname.setText("");txtAddress.setText("");
		
		JLabel lblStudentName = new JLabel("Student Name :");
		lblStudentName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentName.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblStudentName.setBounds(26, 249, 114, 42);
		dashframe.getContentPane().add(lblStudentName);
		
		JLabel lblDev_1_1 = new JLabel("Address : ");
		lblDev_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDev_1_1.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev_1_1.setBounds(73, 321, 67, 42);
		dashframe.getContentPane().add(lblDev_1_1);
		
		JLabel lblDev_1_3 = new JLabel("Student Number :");
		lblDev_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDev_1_3.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev_1_3.setBounds(10, 179, 130, 42);
		dashframe.getContentPane().add(lblDev_1_3);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRecord();//call to the add method
			}
		});
		
		btnAdd.setBorder(UIManager.getBorder("Button.border"));
		btnAdd.setBackground(new Color(100, 149, 237));
		btnAdd.setBounds(150, 371, 114, 42);
		dashframe.getContentPane().add(btnAdd);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRecord();
			}
		});
		btnView.setBorder(UIManager.getBorder("Button.border"));
		btnView.setBackground(new Color(100, 149, 237));
		btnView.setBounds(287, 475, 114, 42);
		dashframe.getContentPane().add(btnView);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBorder(UIManager.getBorder("Button.border"));
		btnUpdate.setBackground(new Color(100, 149, 237));
		btnUpdate.setBounds(150, 423, 114, 42);
		dashframe.getContentPane().add(btnUpdate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnClear.setBorder(UIManager.getBorder("Button.border"));
		btnClear.setBackground(new Color(100, 149, 237));
		btnClear.setBounds(287, 371, 114, 42);
		dashframe.getContentPane().add(btnClear);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(574, 120, 251, 42);
		dashframe.getContentPane().add(txtSearch);
		
		JLabel lblDev_1_3_1 = new JLabel("Search");
		lblDev_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDev_1_3_1.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev_1_3_1.setBounds(434, 122, 130, 42);
		dashframe.getContentPane().add(lblDev_1_3_1);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBorder(UIManager.getBorder("Button.border"));
		btnSearch.setBackground(new Color(100, 149, 237));
		btnSearch.setBounds(835, 120, 88, 42);
		dashframe.getContentPane().add(btnSearch);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBorder(UIManager.getBorder("Button.border"));
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(287, 423, 114, 42);
		dashframe.getContentPane().add(btnDelete);
	}
	//DB Connection
		static Connection connect(){
			try {
				String myDriver ="com.mysql.jdbc.Driver";
				Class.forName(myDriver);
				String url = "jdbc:mysql://localhost:3306/copl_db";
				return(Connection) DriverManager.getConnection(url,"root","");
			}catch(Exception e) {
				System.out.print("Cannot connect to the database");
			}
			return null;
		}
	//Add button method
		private void addRecord() {
			Connection con = connect();
			String sno =txtStudentnum.getText();
			String sname = txtStudentname.getText();
			String add = txtAddress.getText();
			
			try {
				if(!txtStudentnum.getText().trim().equals("") && !txtStudentname.getText().trim().equals("")&& !txtAddress.getText().trim().equals("")) {
					String query = "INSERT INTO student_tbl (student_no,student_name,address,date_created) VALUES(?,?,?,NOW())";
					PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
					ps.setString(1, sno);
					ps.setString(2, sname);
					ps.setString(3, add);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Record Successfully Saved!");
					clearTextfield();
				}
				else {
					JOptionPane.showMessageDialog(null, "All Textfield should be filled!");
					
				}
			}catch(Exception e) {
				System.out.println("Error : "+e);
			}
		}
	//Clear method
		private void clearTextfield() {
			txtStudentnum.setText("");
			txtStudentname.setText("");
			txtAddress.setText("");
		}
		public void viewRecord() {
			Connection con = connect();
			DefaultTableModel mod = new DefaultTableModel();
			mod.addColumn("ID");
			mod.addColumn("Student No");
			mod.addColumn("Student Name");
			mod.addColumn("Address");
			mod.addColumn("Date of Registration");
			
			try {
				String sql = "SELECT * FROM student_tbl";
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				mod.addRow(new Object[]{
						"ID",
						"Student Number",
						"Student Name",
						"Address",
						"Date of Registration"
				});
				while(rs.next()) {
					mod.addRow(new Object[]{
						rs.getInt("id"),
						rs.getString("student_no"),
						rs.getString("student_name"),
						rs.getString("address"),
						rs.getString("date_created")
					});	
				}
				rs.close();
				st.close();
				con.close();
				
				tableView.setModel(mod);
				tableView.setAutoResizeMode(0);
				tableView.getColumnModel().getColumn(0).setPreferredWidth(5);
				tableView.getColumnModel().getColumn(1).setPreferredWidth(30);
				tableView.getColumnModel().getColumn(2).setPreferredWidth(30);
				tableView.getColumnModel().getColumn(3).setPreferredWidth(20);
				tableView.getColumnModel().getColumn(4).setPreferredWidth(30);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
}
