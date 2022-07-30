//JOHN BRENT DAVID | BSCS 2-1 | PT3 FOR COP - Prof: ISAAC MORALLO
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class JobDetails {

	public static void main(String[] args) throws SQLException{
		printJobs();
		System.out.println("===================================================================================");
		printRegions();
		System.out.println("===================================================================================");
		printJobGrades();
	}//end of main
	
	public static void printJobs() throws SQLException {
		// TODO Auto-generated method stub
				OracleDataSource ods = new OracleDataSource();
				ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@//localhost:1521/xepdb1");
				Connection conn = ods.getConnection();
				
				Statement stmt = conn.createStatement();
				//Execute a statement - DO THIS WITH AT LEAST 3 TABLES - PROVIDE SCREENSHOT
				ResultSet rset = stmt.executeQuery("Select JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY from jobs");
				System.out.println("Job ID\t\tJob Title\t\t\tMin Salary\tMax Salary\n");

				while(rset.next()) {
					if (rset.getString(1).length()>=7)
						if(rset.getString(2).length() >=16 && rset.getString(2).length() <24 )
							System.out.println(rset.getString(1)+"\s\t"+
									   rset.getString(2)+"\t\t"+
									   rset.getString(3)+"\t\t"+
									   rset.getString(4));
						else if(rset.getString(2).length() >=28 )
							System.out.println(rset.getString(1)+"\s\t"+
									   rset.getString(2)+" "+
									   rset.getString(3)+"\t\t"+
									   rset.getString(4));
						else if(rset.getString(2).length() >=24 )
							System.out.println(rset.getString(1)+"\s\t"+
									   rset.getString(2)+"\t"+
									   rset.getString(3)+"\t\t"+
									   rset.getString(4));
						else
							System.out.println(rset.getString(1)+"\s\t"+
							   rset.getString(2)+"\t\t\t"+
							   rset.getString(3)+"\t\t"+
							   rset.getString(4));
					else
						if(rset.getString(2).length() >=16 && rset.getString(2).length() <24 )
							System.out.println(rset.getString(1)+"\t\t"+
									   rset.getString(2)+"\t\t"+
									   rset.getString(3)+"\t\t"+
									   rset.getString(4));
						else if(rset.getString(2).length() >=28 )
							System.out.println(rset.getString(1)+"\t\t"+
									   rset.getString(2)+"   "+
									   rset.getString(3)+"\t\t"+
									   rset.getString(4));
						else if(rset.getString(2).length() >=24 )
							System.out.println(rset.getString(1)+"\t\t"+
									   rset.getString(2)+"\t"+
									   rset.getString(3)+"\t\t"+
									   rset.getString(4));
						else
							System.out.println(rset.getString(1)+"\t\t"+
							   rset.getString(2)+"\t\t\t"+
							   rset.getString(3)+"\t\t"+
							   rset.getString(4));
				}//end of while
				rset.close();
				stmt.close();
	}//end of jobs method
	
	public static void printRegions()throws SQLException{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@//localhost:1521/xepdb1");
		Connection conn = ods.getConnection();
		
		Statement stmt = conn.createStatement();
		//Execute a statement - DO THIS WITH AT LEAST 3 TABLES - PROVIDE SCREENSHOT
		ResultSet rset = stmt.executeQuery("Select REGION_ID,REGION_NAME from regions");
		System.out.println("Region ID\tRegion Name\n");

		while(rset.next()) {
			System.out.println(rset.getString(1)+"\t\t"+
							   rset.getString(2));
		}//end of while
		rset.close();
		stmt.close();
	}//end of region method
	
	public static void printJobGrades() throws SQLException{
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@//localhost:1521/xepdb1");
		Connection conn = ods.getConnection();
		
		Statement stmt = conn.createStatement();
		//Execute a statement - DO THIS WITH AT LEAST 3 TABLES - PROVIDE SCREENSHOT
		ResultSet rset = stmt.executeQuery("Select GRADE_LEVEL,LOWEST_SAL,HIGHEST_SAL from job_grades");
		System.out.println("Grade Level\tLowest Sal\tHighest Sal\n");

		while(rset.next()) {
			System.out.println(rset.getString(1)+"\t\t"+
						       rset.getString(2)+"\t\t"+
							   rset.getString(3));
			
		}//end of while
		rset.close();
		stmt.close();
	}
	
}//end of class
