package application.programs;

import java.text.ParseException;
import java.util.Scanner;

import application.services.SellerServices;

public class ProgramSeller {

	public static void main(String[] args) throws ParseException {  
		
		SellerServices sellerService = new SellerServices();  
		Scanner sc = new Scanner(System.in); 
		
		System.out.println();
		System.out.println("Sellers area, choose the option of the operation you want to do: ");
		System.out.println("1 - Find seller by id:");
		System.out.println("2 - Find seller by department id:");
		System.out.println("3 - Find all sellers:");
		System.out.println("4 - Insert seller:");
		System.out.println("5 - Update seller:");
		System.out.println("6 - Delete seller:");
		int option = sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1: 
			sellerService.sellerFindById();
			break;
		case 2: 
			sellerService.sellerFindByDepartment();
			break; 
		case 3: 
			sellerService.sellerFindAll();
			break; 
		case 4: 
			sellerService.insertSeller();
			break;
		case 5: 
			sellerService.sellerUpdate();
			break;
		case 6: 
			sellerService.sellerDelete();
			break;
		default: 
			System.out.println("Operation not found!");
			break;
		}
		sc.close();
	}
	
}