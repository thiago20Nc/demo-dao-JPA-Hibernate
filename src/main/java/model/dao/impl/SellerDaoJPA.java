package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exception.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJPA implements SellerDao{

	@Override
	public void insert(Seller obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	    	em.getTransaction().begin();
	        
	    	em.find(Department.class, 2);
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
	public void update(Seller obj) {
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
			Seller sel = em.find(Seller.class, id);
			
			if(sel != null) {
				em.remove(sel);
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
	public Seller findById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Seller.class, id);
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
	public List<Seller> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
		EntityManager em = emf.createEntityManager();
		
		try {
			 String jpql = "SELECT s FROM Seller s";
		     return em.createQuery(jpql, Seller.class).getResultList();
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
	public List<Seller> findByDepartment(Department department) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dao-jpa-hibernate");
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	        String jpql = "SELECT s FROM Seller s WHERE s.department.id = :departmentId";
	        return em.createQuery(jpql, Seller.class)
	                 .setParameter("departmentId", department)
	                 .getResultList();
	    } 
	    catch (DbException e) {
	        e.printStackTrace();
	        return null;
	    } 
	    finally {
	        em.close();
	        emf.close();
	    }	
	}
}
