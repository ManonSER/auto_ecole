package sopra.auto_ecole.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Question")

public class Question {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "Intitule")
	private String intitule;
	@Column(name = "Reponse")
	private Reponse reponse;
	@Column(name = "NiveauDifficulte")
	private NiveauDifficulte niveauDifficulte;
	@Column(name = "Theme")
	private String theme;
	@ManyToMany
	@JoinTable(name = "serie", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "serie_id"))
	private List<Serie> series = new ArrayList<Serie>();
	
	public Question() {
		super();
	}
	
	public Question(int id, String intitule, Reponse reponse, NiveauDifficulte niveauDifficulte, String theme) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.reponse = reponse;
		this.niveauDifficulte = niveauDifficulte;
		this.theme = theme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Reponse getReponse() {
		return reponse;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

	public NiveauDifficulte getNiveauDifficulte() {
		return niveauDifficulte;
	}

	public void setNiveauDifficulte(NiveauDifficulte niveauDifficulte) {
		this.niveauDifficulte = niveauDifficulte;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", intitule=" + intitule + ", reponse=" + reponse + ", niveauDifficulte="
				+ niveauDifficulte + ", theme=" + theme + "]";
	}	
}
