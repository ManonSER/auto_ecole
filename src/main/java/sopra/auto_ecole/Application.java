package sopra.auto_ecole;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.auto_ecole.repository.IQuestionRepository;
import sopra.auto_ecole.repsitory.jpa.QuestionRepositoryJpa;


public class Application {
	
	private static Application instance = null;
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("auto_ecole");
	
	private final IQuestionRepository questionRepo = new QuestionRepositoryJpa();
	
	
	private Application() {

	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IQuestionRepository getQuestionRepo() {
		return questionRepo;
	}
	

}
