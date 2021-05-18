package sopra.auto_ecole;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.auto_ecole.Application;
import sopra.auto_ecole.repository.IClientRepository;
import sopra.auto_ecole.repsitory.jpa.ClientRepositoryJpa;



public class Application {
	
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("auto");

	private final IClientRepository clientRepo = new ClientRepositoryJpa();
	
	
	private Application() {

	}

	public static Application getInstance() {
		if(instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IClientRepository getClientRepo() {
		return clientRepo;
	}
	
	

}
