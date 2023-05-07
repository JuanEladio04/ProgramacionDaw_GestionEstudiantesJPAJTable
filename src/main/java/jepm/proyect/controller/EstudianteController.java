package jepm.proyect.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import jepm.proyect.model.Estudiante;

public class EstudianteController {
	
	private static EstudianteController controller = null;
	
	/**
	 * 
	 * @return
	 */
	public static EstudianteController getController() {
		if (controller == null) {
			controller = new EstudianteController();
		}
		return controller;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionEstudiantesJPAJTable");	
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Estudiante> query = em.createNamedQuery("Estudiante.findAll", Estudiante.class);
	    return query.getResultList();
	}
	
	/**
	 * 
	 * @param string
	 */
	public static Estudiante findbyId(int idDocente) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionEstudiantesJPAJTable");
		EntityManager em = entityManagerFactory.createEntityManager();
		Estudiante e = new Estudiante();
				
		Query q = em.createNativeQuery("SELECT * FROM estudiante where id = ?", Estudiante.class);

		q.setParameter(1, idDocente);

		
		try {
			e = (Estudiante) q.getSingleResult();
		} catch (Exception exc) {
			e = null;
		}
		em.close();		
		return e;
		
	}
	
	
	/** 
	 * 
	 * @return
	 */
	public static String[] getColumnTittle() {
		return new String[] {"Id", "Nombre", "1º apellido", "2º apellido", "DNI",  "Direccion", "Email", "Teléfono", "Sexo"};
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Object[][] getTableData() {
		// Obtengo todas las personas
		List<Estudiante> students = getController().findAll();
		Object[][] datos = new Object[students.size()][9];
		for (int i = 0; i < students.size(); i++) {
			Estudiante student = students.get(i);
			datos[i][0] = student.getId();
			datos[i][1] = student.getNombre();
			datos[i][2] = student.getApellido1();
			datos[i][3] = student.getApellido2();
			datos[i][4] = student.getDni();
			datos[i][5] = student.getDireccion();
			datos[i][6] = student.getEmail();
			datos[i][7] = student.getTelefono();
			datos[i][8] = student.getTipologiasexo();

		}
		
		return datos;
	}
	
	
	/**
	 * 
	 */
	public static void realizeUpdate (Estudiante e) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionEstudiantesJPAJTable");

		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}

}
