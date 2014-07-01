package com.jspider.empinfosystem.main;

import java.util.Scanner;
import com.jspider.empinfosystem.user.*;
/**
 * @author : Santosh Koli
 * @createdDate : Jun 11, 2014
 * @projectName : assignment_1_proj
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--------- App Start ---------");

		User user = new User();
		boolean cont = true;
		Scanner scan = new Scanner(System.in);
		int choice = 0;

		while(cont) {
			System.out.println("\nEmployee Information System");
			System.out.println("1 : Display employee information by ID");
			System.out.println("2 : Display department wise employees information");
			System.out.println("3 : Display employees information by salary range");
			System.out.print("Select your choice ? : ");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:user.readEmployeeDetail(); 
				break;
			case 2:user.readEmployeesDetailsByDept();
				break;
			case 3:user.readEmployeesDetailsBySalaryRange();
				break;
			default : System.out.println("Invalid Choice");
			}
			System.out.print("Would you like continue? (yes/no) : ");
			cont = scan.next().equalsIgnoreCase("yes");
		}
		scan.close();
		
		System.out.println("--------- App End ---------");
	}
}
