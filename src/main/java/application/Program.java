package application;

import java.util.List;

import model.dao.impl.SellerDaoJPA;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	 
		SellerDaoJPA daoJPA = new SellerDaoJPA();

		// Criar um objeto Department com o ID desejado
		Department department = new Department(1, "Ti");

		// Buscar vendedores pelo departamento
		List<Seller> sellers = daoJPA.findByDepartment(department);

		// Imprimir os resultados
		if (sellers != null && !sellers.isEmpty()) {
		    for (Seller sel : sellers) {
		        System.out.println("ID: " + sel.getId());
		        System.out.println("Nome: " + sel.getName());
		        System.out.println("Email: " + sel.getEmail());
		        System.out.println("Departamento: " + sel.getDepartment().getName());
		        System.out.println("----------------------------");
		    }
		} 
		else {
		    System.out.println("Nenhum vendedor encontrado para o departamento informado.");
		}

		
	}

}
