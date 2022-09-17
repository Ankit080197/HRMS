package com.HR_Management;
import java.sql.*;


public class HRdao {

		Connection con;
	
		void connect() throws Exception {
			
			// Loading JDBC Driver.
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		
			//Connection established from database.
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Ankit_DB", "root", "ankit@080917");		 					
									}

			int newEmployee(HREmp emp) throws Exception {
				
		      //executing query 
	    	  String query = "select * from employee where empId = " + emp.empId + "  ";
	    	  Statement st = con.createStatement();
	    	  ResultSet set = st.executeQuery(query);							
		
	    	  if (set.next()) 
	    	  {
	    		  return -1;
					} 
	    	  else 
	    	  		{
	    	  String query2 = ("INSERT into employee(empName,empPhone,empSalary,empLocation,empDesignation) values(?,?,?,?,?);");
			
	    	  PreparedStatement pr = con.prepareStatement(query2);
			
	    	  
	    	  //Inserting employee to the database.
	    	  pr.setString(1, emp.empName);				
	    	  pr.setString(2, emp.empPhone);
	    	  pr.setInt(3, emp.empSalary);
	    	  pr.setString(4, emp.empLocation);
	    	  pr.setString(5, emp.empDesignation);
			
	    	  int count = pr.executeUpdate();	
	    	  return count;				
				}		
		
				}

			 int removeEmployee(int empId) throws Exception {
	    	
		       Statement ds = con.createStatement();
		
	    	   //executing query to fetch data
		       ResultSet rs = ds.executeQuery("select * from employee where empId="+empId);
		       if(rs.next()) {
			   rs.close();
			
			
			
			
			    Statement s = con.createStatement();
			
				//Deleting employee row from the table.
				int count = s.executeUpdate("DELETE from employee WHERE empId = "+empId);		
				return 1;
				}
				else 
				{
				return 0;
				}
	    		}

			 
	         	public int increaseSalary(int empId, int hike) throws Exception 
	         	{
	         		
	        	Statement st = con.createStatement();
	        	
	        	//executing query to fetch data
	        	ResultSet rs = st.executeQuery("select * from employee where empId ="+empId);
		
	        	 if(rs.next()) 
	        	 {
	        		 Statement s = con.createStatement();
				
				 
	             	 int count = s.executeUpdate("update employee SET empSalary=empSalary+((empSalary*" + hike + ")/100) where empId=" + empId);
					 return count;		
	        	 			}
	        	 else 
	        	 		{
	        		 return 0;
	        	 		}
	}
}

