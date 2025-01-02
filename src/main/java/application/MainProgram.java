package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import application.programs.ProgramDepartment;
import application.programs.ProgramSeller;

public class MainProgram {

	public static void main(String[] args) throws ParseException {  
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Welcome to system! Select an option: ");
		System.out.println("1 - Seller");
		System.out.println("2 - Department"); 
		int option = sc.nextInt(); 
		sc.nextLine(); 
			
		switch(option) {
		case 1: 
			ProgramSeller.main(args); 
				break;
		case 2:
			ProgramDepartment.main(args);
				break;
		default:
			System.out.println("This option does not exist!");
		}
	
		sc.close();
	}
}