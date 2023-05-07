package jepm.proyect.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jepm.proyect.model.Estudiante;
import jepm.proyect.model.Tipologiasexo;

public class TipologiaSexoController {
	
	/**
	 * 
	 * @return
	 */
	public static List<Tipologiasexo> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionEstudiantesJPAJTable");	
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Tipologiasexo> query = em.createNamedQuery("Tipologiasexo.findAll", Tipologiasexo.class);
	    return query.getResultList();
	}

}
