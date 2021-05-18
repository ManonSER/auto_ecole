package sopra.auto_ecole;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.auto_ecole.Application;
import sopra.auto_ecole.repository.*;
import sopra.auto_ecole.repsitory.jpa.*;

public class Application {
	private static Application instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("auto");
	private final ISerie serieRepo = new SerieRepositoryJpa();
	private final ICdRom cdRomRepo = new CdRomRepositoryJpa();
	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public ISerie getSerieRepo() {
		return serieRepo;
	}

	public ICdRom getCdRomRepo() {
		return cdRomRepo;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}
	
}
