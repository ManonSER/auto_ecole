import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("auto");
		

		emf.close();
	}

}
