package sopra.auto_ecole.repsitory.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.auto_ecole.model.CdRom;
import sopra.auto_ecole.repository.ICdRom;
import sopra.auto_ecole.Application;
import sopra.auto_ecole.model.*;

public class CdRomRepositoryJpa implements ICdRom{

	public List<CdRom> findAll() {
		List<CdRom> cdRoms = new ArrayList<CdRom>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<CdRom> query = em.createQuery("select e from cdRom e", CdRom.class);

			cdRoms = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return cdRoms;
	}

	public CdRom findById(Long id) {
		CdRom cdRom = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			cdRom = em.find(CdRom.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return cdRom;
	}

}
