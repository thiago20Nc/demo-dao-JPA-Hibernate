package application.programs;

import java.util.Scanner;

import application.services.DepartmentServices;

public class ProgramDepartment {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);  
		DepartmentServices departmentService = new DepartmentServices();
		
		System.out.println();
		System.out.println("Department area, choose the option of the operation you want to do: ");
		System.out.println("1 - Find department by id:");
		System.out.println("2 - List departments: ");
		System.out.println("3 - Insert department:");
		System.out.println("4 - Update department:");
		System.out.println("5 - Delete department:");
		int option = sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1: 
			departmentService.departmentFindById();
			break;
		case 2: 
			departmentService.departmentFindByDepartment();
			break; 
		case 3: 
			departmentService.insertDepartment();
			break; 
		case 4: 
			departmentService.updateDepartment();
			break;
		case 5: 
			departmentService.deleteDepartment();
			break;
		default: 
			System.out.println("Operation not found!");
			break;
		}
		
		sc.close();
	}
}