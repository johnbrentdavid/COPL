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
import java.util.GregorianCalendar;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class dashboard {

	public JFrame dashframe;
	private JTable tableView;
	private JTextField txtStudentnum;
	private JTextField txtStudentname;
	private JTextField txtAddress;
	private JTextField txtSearch;
	private JTextField txtContact;
	private JComboBox txtGender;
	private JButton btnAdd;
	private JLabel lblClock;

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
		clock();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username) {
		dashframe = new JFrame();
		dashframe.getContentPane().setBackground(Color.WHITE);
		dashframe.setTitle("Student Records");
		dashframe.setBounds(100, 100, 996, 595);
		dashframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashframe.getContentPane().setLayout(null);
		
		JLabel lblOutcomesEvalution = new JLabel("Student Record System");
		lblOutcomesEvalution.setBorder(null);
		lblOutcomesEvalution.setFont(new Font("Palatino Linotype", Font.BOLD, 34));
		lblOutcomesEvalution.setBounds(10, 12, 368, 66);
		dashframe.getContentPane().add(lblOutcomesEvalution);
		
		JLabel lblDev = new JLabel("-by John Brent David");
		lblDev.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev.setBounds(232, 45, 179, 42);
		dashframe.getContentPane().add(lblDev);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Logged in as", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(480, 12, 492, 50);
		dashframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblWelcome = new JLabel(username);
		lblWelcome.setBackground(Color.WHITE);
		lblWelcome.setBounds(10, 11, 345, 36);
		panel_2.add(lblWelcome);
		lblWelcome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcome.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBounds(373, 10, 109, 33);
		panel_2.add(btnLogout);
		btnLogout.setBorder(UIManager.getBorder("Button.border"));
		btnLogout.setBackground(UIManager.getColor("Button.highlight"));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 124, 660, 372);
		dashframe.getContentPane().add(scrollPane);
		
		tableView = new JTable();
		tableView.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableView);
		tableView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtStudentnum.setEnabled(false);
				String id = tableView.getValueAt(tableView.getSelectedRow(), 0).toString();
				fillField(id);
			}
		});
		tableView.setColumnSelectionAllowed(true);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Student Information", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 124, 292, 320);
		dashframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		txtStudentnum = new JTextField();
		txtStudentnum.setBounds(140, 43, 130, 42);
		panel.add(txtStudentnum);
		txtStudentnum.setColumns(10);
		txtStudentnum.setText("");
		
		txtStudentname = new JTextField();
		txtStudentname.setBounds(140, 95, 130, 42);
		panel.add(txtStudentname);
		txtStudentname.setColumns(10);
		txtStudentname.setText("");
		
		txtAddress = new JTextField();
		txtAddress.setBounds(140, 147, 130, 42);
		panel.add(txtAddress);
		txtAddress.setColumns(10);txtAddress.setText("");
		
		JLabel lblStudentName = new JLabel("Student Name :");
		lblStudentName.setBounds(16, 97, 114, 42);
		panel.add(lblStudentName);
		lblStudentName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentName.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		
		JLabel lblDev_1_1 = new JLabel("Address : ");
		lblDev_1_1.setBounds(62, 149, 67, 42);
		panel.add(lblDev_1_1);
		lblDev_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDev_1_1.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		
		JLabel lblDev_1_3 = new JLabel("Student Number :");
		lblDev_1_3.setBounds(0, 45, 130, 42);
		panel.add(lblDev_1_3);
		lblDev_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDev_1_3.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		
		JLabel lblDev_1_1_1 = new JLabel("Gender : ");
		lblDev_1_1_1.setBounds(63, 201, 67, 42);
		panel.add(lblDev_1_1_1);
		lblDev_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDev_1_1_1.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		
		JLabel lblDev_1_1_2 = new JLabel("Contact no : ");
		lblDev_1_1_2.setBounds(39, 253, 91, 42);
		panel.add(lblDev_1_1_2);
		lblDev_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDev_1_1_2.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		
		txtContact = new JTextField();
		txtContact.setBounds(140, 251, 130, 42);
		panel.add(txtContact);
		txtContact.setText("");
		txtContact.setColumns(10);
		
		txtGender = new JComboBox();
		txtGender.setBounds(140, 199, 130, 42);
		panel.add(txtGender);
		txtGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRecord();//call to the add method
			}
		});
		
		btnAdd.setBorder(UIManager.getBorder("Button.border"));
		btnAdd.setBackground(UIManager.getColor("Button.highlight"));
		btnAdd.setBounds(30, 454, 114, 42);
		dashframe.getContentPane().add(btnAdd);
		
		JButton btnView = new JButton("REFRESH");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRecord();
				txtSearch.setText("");
			}
		});
		btnView.setBorder(UIManager.getBorder("Button.border"));
		btnView.setBackground(UIManager.getColor("Button.highlight"));
		btnView.setBounds(858, 506, 114, 42);
		dashframe.getContentPane().add(btnView);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateRecord();
				btnAdd.setEnabled(true);
				txtStudentnum.setEnabled(true);
				
			}
		});
		btnUpdate.setBorder(UIManager.getBorder("Button.border"));
		btnUpdate.setBackground(UIManager.getColor("Button.highlight"));
		btnUpdate.setBounds(30, 506, 114, 42);
		dashframe.getContentPane().add(btnUpdate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
				btnAdd.setEnabled(true);
				txtStudentnum.setEnabled(true);
			}
		});
		btnClear.setBorder(UIManager.getBorder("Button.border"));
		btnClear.setBackground(UIManager.getColor("Button.highlight"));
		btnClear.setBounds(166, 454, 114, 42);
		dashframe.getContentPane().add(btnClear);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(623, 72, 251, 42);
		dashframe.getContentPane().add(txtSearch);
		
		JLabel lblDev_1_3_1 = new JLabel("Search");
		lblDev_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDev_1_3_1.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblDev_1_3_1.setBounds(483, 74, 130, 42);
		dashframe.getContentPane().add(lblDev_1_3_1);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchTable();
			}
		});
		btnSearch.setBorder(UIManager.getBorder("Button.border"));
		btnSearch.setBackground(UIManager.getColor("Button.highlight"));
		btnSearch.setBounds(884, 72, 88, 42);
		dashframe.getContentPane().add(btnSearch);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtStudentnum.getText().trim().equals("")) {
					deleteRecord(txtStudentnum.getText().toString());
					txtStudentnum.setEnabled(true);
					btnAdd.setEnabled(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Select a Row to Delete");
				}
			}
		});
		btnDelete.setBorder(UIManager.getBorder("Button.border"));
		btnDelete.setBackground(UIManager.getColor("Button.highlight"));
		btnDelete.setBounds(166, 505, 116, 42);
		dashframe.getContentPane().add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Current Time and Date", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(611, 498, 237, 50);
		dashframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblClock.setBounds(10, 14, 262, 26);
		panel_1.add(lblClock);
		
		
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
	//ADD METHOD
		private void addRecord() {
			Connection con = connect();
			String sno =txtStudentnum.getText();
			String sname = txtStudentname.getText();
			String add = txtAddress.getText();
			String gender = txtGender.getSelectedItem().toString();
			String contact = txtContact.getText();
			try {
				if(!txtStudentnum.getText().trim().equals("") && !txtStudentname.getText().trim().equals("")&& !txtAddress.getText().trim().equals("")&& !txtContact.getText().trim().equals("")) {
					String query = "INSERT INTO student_tbl (student_no,student_name,address,gender,contact_no,date_created) VALUES(?,?,?,?,?,NOW())";
					PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
					ps.setString(1, sno);
					ps.setString(2, sname);
					ps.setString(3, add);
					ps.setString(4, gender);
					ps.setString(5, contact);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Record Successfully Saved!");
					clearTextfield();
					viewRecord();
				}
				else {
					JOptionPane.showMessageDialog(null, "All Textfield should be filled!");
					
				}
			}catch(Exception e) {
				System.out.println("Error : "+e);
			}
		}
	//CLEAR METHOD
		private void clearTextfield() {
			txtStudentnum.setText("");
			txtStudentname.setText("");
			txtAddress.setText("");
			txtContact.setText("");
		}
	//VIEW METHODS
		public void viewRecord() {
			
			Connection con = connect();
			DefaultTableModel mod = new DefaultTableModel();
			mod.addColumn("ID");
			mod.addColumn("Student No");
			mod.addColumn("Student Name");
			mod.addColumn("Gender");
			mod.addColumn("Contact No");
			mod.addColumn("Address");
			mod.addColumn("Date of Registration");
			
			try {
				String sql = "SELECT * FROM student_tbl";
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					mod.addRow(new Object[]{
						rs.getInt("id"),
						rs.getString("student_no"),
						rs.getString("student_name"),
						rs.getString("gender"),
						rs.getString("contact_no"),
						rs.getString("address"),
						rs.getString("date_created")
					});	
				}
				rs.close();
				st.close();
				con.close();
				
				tableView.setModel(mod);
				tableView.setAutoResizeMode(0);
				tableView.getColumnModel().getColumn(0).setPreferredWidth(30);//ID
				tableView.getColumnModel().getColumn(1).setPreferredWidth(90);//Student Number
				tableView.getColumnModel().getColumn(2).setPreferredWidth(135);//Student Name
				tableView.getColumnModel().getColumn(3).setPreferredWidth(60);//Gender
				tableView.getColumnModel().getColumn(4).setPreferredWidth(100);//Contact
				tableView.getColumnModel().getColumn(5).setPreferredWidth(115);//Address
				tableView.getColumnModel().getColumn(6).setPreferredWidth(125);//Date of Registration
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		public void viewOneRecord(String add) {
			Connection con = connect();
			DefaultTableModel mod = new DefaultTableModel();
			mod.addColumn("ID");
			mod.addColumn("Student No");
			mod.addColumn("Student Name");
			mod.addColumn("Gender");
			mod.addColumn("Contact No");
			mod.addColumn("Address");
			mod.addColumn("Date of Registration");
			
			try {
				String sql = "SELECT * FROM student_tbl WHERE "+add;
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					mod.addRow(new Object[]{
						rs.getInt("id"),
						rs.getString("student_no"),
						rs.getString("student_name"),
						rs.getString("gender"),
						rs.getString("contact_no"),
						rs.getString("address"),
						rs.getString("date_created")
					});	
				}
				rs.close();
				st.close();
				con.close();
				
				tableView.setModel(mod);
				tableView.setAutoResizeMode(0);
				tableView.getColumnModel().getColumn(0).setPreferredWidth(30);//ID
				tableView.getColumnModel().getColumn(1).setPreferredWidth(90);//Student Number
				tableView.getColumnModel().getColumn(2).setPreferredWidth(135);//Student Name
				tableView.getColumnModel().getColumn(3).setPreferredWidth(60);//Gender
				tableView.getColumnModel().getColumn(4).setPreferredWidth(100);//Contact
				tableView.getColumnModel().getColumn(5).setPreferredWidth(115);//Address
				tableView.getColumnModel().getColumn(6).setPreferredWidth(125);//Date of Registration
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		//DELETE METHOD
		public void deleteRecord(String sno) {
			Connection con = connect();
			try {
				String sql = "DELETE from student_tbl where student_no =?";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1,sno);
				ps.execute();
				ps.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Record Deleted from Database...");
				clearTextfield();
				viewRecord();
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
	//UPDATE METHODS
		public void updateRecord(){
			String sno =txtStudentnum.getText();
			String sname = txtStudentname.getText();
			String add = txtAddress.getText();
			String gender = txtGender.getSelectedItem().toString();
			String contact = txtContact.getText();
			Connection con = connect();
			try {
				String sql = "UPDATE student_tbl SET student_name = ?,address = ?,gender = ?,contact_no=? WHERE student_no = ?";
				PreparedStatement ps= (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, sname);
				ps.setString(2, add);
				ps.setString(3, gender);
				ps.setString(4, contact);
				ps.setString(5, sno);
				ps.execute();
				
				ps.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Record Updated...");
				clearTextfield();
				viewRecord();
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		//Wrong code for setting the txt fields
		public void fillField(String id) {
			try {
				Connection con = connect();
				String sql = "SELECT * FROM student_tbl WHERE id = ?";
				PreparedStatement ps= (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1,id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					txtStudentnum.setText(rs.getString("student_no"));
					txtStudentname.setText(rs.getString("student_name"));
					txtContact.setText(rs.getString("contact_no"));
					txtAddress.setText(rs.getString("address"));
					if(rs.getString("gender").trim().equals("Male")) {
						txtGender.setSelectedItem("Male");
					}
					else {
						txtGender.setSelectedItem("Female");
					}
					txtStudentnum.setEnabled(false);
					btnAdd.setEnabled(false);
				}
					ps.close();
					con.close();
				
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		
		public void clock() {
			Thread clock = new Thread() {
				public void run() {
					try {
						while(true) {
						Calendar c1 = new GregorianCalendar();
						int day=c1.get(Calendar.DAY_OF_MONTH);
						int month=c1.get(Calendar.MONTH)+1;
						int year=c1.get(Calendar.YEAR);
						
						int sec=c1.get(Calendar.SECOND);
						int min=c1.get(Calendar.MINUTE);
						int hr=c1.get(Calendar.HOUR);
						
						lblClock.setText(hr+":"+min+":"+sec+" | "+month+"/"+day+"/"+year);
						sleep(1000);
						}
					}catch(InterruptedException ex){
						ex.printStackTrace();
					}
				}
			};
			clock.start();
		}
		//SEARCH METHOD
		public void searchTable() {
			Connection con = connect();
			boolean found = false;
			try {
				String sql = "SELECT * FROM student_tbl";
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				String add = "";
				while(rs.next()) {

					if(rs.getString(1).equals(txtSearch.getText())) {//compare to id
						add="id = "+txtSearch.getText().trim();
						viewOneRecord(add);
						found = true;
						break;
					}
					else if(rs.getString("student_no").equals(txtSearch.getText())) {//compare to student_no
						add="student_no LIKE '%"+txtSearch.getText()+"%'";
						viewOneRecord(add);
						found = true;
						break;
					}
					else if(rs.getString("student_name").equals(txtSearch.getText())) {//compare to student_name
						add="student_name = '"+txtSearch.getText()+"'";
						viewOneRecord(add);
						found = true;
						break;
					}
					else if(rs.getString("gender").equals(txtSearch.getText())) {//compare to gender
						add="gender LIKE '"+txtSearch.getText()+"'";
						viewOneRecord(add);
						found = true;
						break;
					}
					else if(rs.getString("contact_no").equals(txtSearch.getText())) {//compare to contact_no
						add="contact_no = '"+txtSearch.getText()+"'";
						viewOneRecord(add);
						found = true;
						break;
					}
					else if(rs.getString("address").trim().equals(txtSearch.getText())) {//compare to address
						add="address = '"+txtSearch.getText()+"'";
						viewOneRecord(add);
						found = true;
						break;
					}
				}//end of while loop
				if(!found) {
					JOptionPane.showMessageDialog(null,"Not found on Student Records.");
					viewRecord();
				}
				st.close();rs.close();
			}catch(Exception e) {
				System.out.println(e);
			}//end of first try catch
			
			
		}
		
		
}
