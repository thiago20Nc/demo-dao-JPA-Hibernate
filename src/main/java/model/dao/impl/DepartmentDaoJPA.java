package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exception.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJPA implements DepartmentDao{

	@Override
	public void insert(Department obj) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	    	em.getTransaction().begin();
	        
	        em.persist(obj);
	        
	        em.getTransaction().commit();
	    } 
	    catch (DbException e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace(); 
	    } 
	    finally {
	        em.close();
	        emf.close();
	    }
	}		

	@Override
	public void update(Department obj) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
		EntityManager em = emf.createEntityManager(); 
		
		try {
			em.getTransaction().begin();
			 
			em.merge(obj);
			
			em.getTransaction().commit();
		}
		catch(DbException e) {
			if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace(); 
		}
		finally {
			em.close();
			emf.close();
		}
	}

	@Override
	public void deleteById(Integer id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
		EntityManager em = emf.createEntityManager(); 
		
		try {
			em.getTransaction().begin();
			Department dep = em.find(Department.class, id);
			
			if(dep != null) {
				em.remove(dep);
			}
			
			em.getTransaction().commit();
		}
		catch(DbException e) {
			if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
		}
		finally {
			em.close();
			emf.close(); 
		}
	}

	@Override
	public Department findById(Integer id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Department.class, id);
		}
		catch(DbException e) {
	        e.printStackTrace(); 
	        return null;
		}
		finally {
			em.close();
			emf.close(); 
		}
	}

	@Override
	public List<Department> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
		EntityManager em = emf.createEntityManager();
		
		try {
			 String jpql = "SELECT d FROM Department d";
		     return em.createQuery(jpql, Department.class).getResultList();
		}
		catch(DbException e) {
	        e.printStackTrace(); 
	        return null;
		}
		finally {
			em.close();
			emf.close(); 
		}
	}

}
