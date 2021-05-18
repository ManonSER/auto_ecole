

import java.util.Date;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.auto_ecole.Application;
import sopra.auto_ecole.model.Seance;
import sopra.auto_ecole.repository.ISeanceRepository;

public class TestCamilleSeance {
	
	@Test
	public void seanceCreate() {
		ISeanceRepository seanceRepo = Application.getInstance().getSeanceRepo();
		Date date1=new Date();
		Seance seance = new Seance();
		seance.setDate(date1);
		seance.setNombreFautes(2);
		seance.setEstExamen(true);
		try {
			seance = seanceRepo.save(seance);
		} catch(PersistenceException e) {
		}
		Seance seanceFind = seanceRepo.findById(seance.getId());
		Assert.assertEquals(date1, seanceFind.getDate());
		Assert.assertEquals(2, seanceFind.getNombreFautes());
		Assert.assertEquals(true, seanceFind.getEstExamen());		
	}
	
	@Test
	public void seanceUpdate() {
		ISeanceRepository seanceRepo = Application.getInstance().getSeanceRepo();
		Date date1=new Date();
		Date date2=new Date();
		Seance seance = new Seance();
		seance.setDate(date1);
		seance.setNombreFautes(2);
		seance.setEstExamen(true);
		seance = seanceRepo.save(seance);
		seance = seanceRepo.findById(seance.getId());
		seance.setDate(date2);
		seance.setNombreFautes(6);
		seance.setEstExamen(false);
		seance = seanceRepo.save(seance);
		seance = seanceRepo.findById(seance.getId());
		Seance seanceFind = seanceRepo.findById(seance.getId());
		Assert.assertEquals(date2, seanceFind.getDate());
		Assert.assertEquals(6, seanceFind.getNombreFautes());
		Assert.assertEquals(false, seanceFind.getEstExamen());		
	}

}
