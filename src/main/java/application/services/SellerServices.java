package application.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerServices { 
	
	Scanner sc = new Scanner(System.in); 
	
	SellerDao sellerDao = DaoFactory.createSellerDao();  
	Seller seller = new Seller();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public void sellerFindById() {
		System.out.println("Enter the id you want to find: ");
		int id = sc.nextInt();
		sc.nextLine();
		seller = sellerDao.findById(id);
		System.out.println(seller);
		sc.close();
	}

	public List<Seller> sellerFindByDepartment() {
		System.out.print("Enter department id to find sellers: ");
		int id = sc.nextInt();
		sc.nextLine();
		sc.close();
		Department department = new Department(id, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		return list;
	}

	public List<Seller> sellerFindAll() {
		System.out.println("All sellers: ");
		List<Seller> list = new ArrayList<>();
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		return list;
	}

	public void insertSeller() throws ParseException {
		System.out.println("Seller insert: ");
		System.out.print("Enter seller name: ");
		String name = sc.nextLine();
		System.out.print("Enter seller email: ");
		String email = sc.nextLine();
		System.out.print("Enter date: ");
		String data = sc.nextLine();
		System.out.print("Enter seller salary: ");
		Double salary = sc.nextDouble();
		System.out.print("Enter department id: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		Seller newSeller = new Seller(null, name, email, sdf.parse(data), salary, new Department(id, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		System.out.println("Seller: " + newSeller.toString());
		sc.close();
	}

	public void sellerUpdate() {
		System.out.print("Enter the ID of the seller you want to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("What do you want to update?");
		System.out.print("1 - Name/ 2 - Email/ 3 - Salary: ");
		int option = sc.nextInt();
		sc.nextLine();
		seller = sellerDao.findById(id);
		switch (option) {
		case 1:
			System.out.print("Update the name: ");
			String name = sc.nextLine();
			seller.setName(name);
			break;
		case 2:
			System.out.print("Update the email: ");
			String email = sc.nextLine();
			seller.setName(email);
			break;
		case 3:
			System.out.print("Update the salary: ");
			Double salary = sc.nextDouble();
			seller.setBaseSalary(salary);
			break;
		default:
			System.out.print("Invalid option");
			break;
		}
		sellerDao.update(seller);
		System.out.println("Update Completed!\n" + seller);
		sc.close();
	}

	public void sellerDelete() {
		System.out.println("Seller delete");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}
}