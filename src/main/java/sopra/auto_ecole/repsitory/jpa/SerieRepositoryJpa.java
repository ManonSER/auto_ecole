package sopra.auto_ecole.repsitory.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.auto_ecole.Application;
import sopra.auto_ecole.model.CdRom;
import sopra.auto_ecole.model.Serie;
import sopra.auto_ecole.repository.ISerie;

public class SerieRepositoryJpa implements ISerie{

	public List<Serie> findAll() {
		List<Serie> series = new ArrayList<Serie>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Serie> query = em.createQuery("select e from serie e", Serie.class);

			series = query.getResultList();

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
		return series;
	}
	public Serie findById(Long id) {
		Serie serie = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			serie = em.find(Serie.class, id);

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

		return serie;
	}

}
