package com.HR_Management;


import java.util.Scanner;
public class App 
{
   
			public static void main(String[] args)  throws Exception {				
				//Scanner object created
				    Scanner Ak = new Scanner(System.in);         			
				    HRdao hrd = new HRdao();									
					hrd.connect();	
					// created miku object using HREmp class.
					HREmp miku = new HREmp();							
					System.out.println("   Welcome to HR_Management system   ");
					
					System.out.println(" Press 1 : TO add Employee \n Press 2 : TO Hike Salary of the Employee \n Press 3 : TO Remove an Employee \n ");
					int sk = Ak.nextInt();
				   
					
					
					switch (sk) {	
				
					//using switch for choosing   cases
					    case 1 -> {		
						//case 1 is for  adding New employee 
						System.out.println("Enter the details of New Employee");
						System.out.println("Enter  Employee Name :");
						miku.empName = Ak.next();
						System.out.println("Enter Phone number :");
						miku.empPhone = Ak.next();
						System.out.println("Enter Salary :");
						miku.empSalary = Ak.nextInt();
						System.out.println("Enter location :");
						miku.empLocation = Ak.next();
						System.out.println("Enter  Designation :");
						miku.empDesignation = Ak.next();
						
						
						//calling newEmployee
						int var1 = hrd.newEmployee(miku);   
						if (var1 == 1)
							System.out.println("Employee added Successfully.");
						
						
						//Checking if employee already exist in the company.
						else
							System.out.println("Employee already exist");
								}
					
					
					    case 2 -> {		
					    	
						// case 2 is to give hike to the employee.
						int amount, empid;
						
						//Employee id as input.
						System.out.print("Enter Employee Id:");
						empid = Ak.nextInt();					
						 
						
						System.out.print("Enter percentage(%)  to increment salary:");
						amount = Ak.nextInt();	
						
						
						int var3 = hrd.increaseSalary(empid, amount);     //increaseSalary method is called here. 
					       
						if (var3 == 1)
							System.out.println("salary is increased.");
						
						//checking if employee exist in the company.
						
						else
							System.out.println("Employee does not exist");
					 		}
					 
					 
				        case 3 ->{		
				        	
						//case 3 is for Removing employee from the database.
						int empid;
						System.out.print("Enter Employee Id:");
						empid = Ak.nextInt();	
						
						
						int var4 = hrd.removeEmployee(empid);		
						
						if (var4==1)
							System.out.println("Employee removed successfully.");
						//checking whether employee existance
						else
							System.out.println("Employee doesn't exist");
							}

							}
					//Scanner object closed.
					Ak.close();	
					}
			}
		
		
		
		
		
		
		
		


