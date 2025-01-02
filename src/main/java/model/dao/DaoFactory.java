package model.dao;

import model.dao.impl.DepartmentDaoJPA;
import model.dao.impl.SellerDaoJPA;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJPA();
	}  
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJPA();
	}
}
