package sopra.auto_ecole.repsitory.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.auto_ecole.Application;
import sopra.auto_ecole.model.Question;
import sopra.auto_ecole.repository.IQuestionRepository;

public class QuestionRepositoryJpa implements IQuestionRepository{

	@Override
	public List<Question> findAll() {
		List<Question> questions = new ArrayList<Question>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Question> query = em.createQuery("select q from Question q", Question.class);

			questions = query.getResultList();

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

		return questions;
	}

	@Override
	public Question findById(Long id) {
		Question question = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			question = em.find(Question.class, id);

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

		return question;
	}
}
