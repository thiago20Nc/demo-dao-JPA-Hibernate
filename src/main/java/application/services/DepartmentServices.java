package application.services;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentServices {

	Scanner sc = new Scanner(System.in); 
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	Department department = new Department();
	
	public void departmentFindById() {
		System.out.print("Enter the id you want to find: ");
		int id = sc.nextInt();
		sc.nextLine();
		department = departmentDao.findById(id);
		System.out.println(department);
		sc.close();
	} 
	
	public List<Department> departmentFindByDepartment(){
		System.out.println("All departments: "); 
		department = new Department(0, null);
		List<Department> list = departmentDao.findAll(); 
		for(Department obj : list) {
			System.out.println(obj);
		}
		return list;
	}
	
	public void insertDepartment(){
		System.out.println("Department insert: ");
		System.out.print("Enter department name: ");
		String name = sc.nextLine();
		Department newDepartment = new Department(null, name); 
		departmentDao.insert(newDepartment); 
		System.out.println("Inserted! New Id = " + newDepartment.getId()); 
		System.out.println("Department: " + newDepartment);
		sc.close();
	}
	
	public void updateDepartment() {
		System.out.println("Department update: ");
		System.out.print("Enter the ID of the department you want to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		Department department2 = departmentDao.findById(id);
		System.out.print("Update the name: ");
		String name = sc.nextLine();
		department2.setName(name);
		departmentDao.update(department2); 
		System.out.println("Update Completed!\n" + department2);
		sc.close();
	}
	
	public void deleteDepartment() {
		System.out.println("Department delete: "); 
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt(); 
		departmentDao.deleteById(id); 
		System.out.println("Delete completed");
		sc.close();
	}
}