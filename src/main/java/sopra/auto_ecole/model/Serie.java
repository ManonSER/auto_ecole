package sopra.auto_ecole.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Serie")
public class Serie {
	@Id
	@GeneratedValue
	private int id;
	@OneToMany(mappedBy = "serie")
	private List<Seance> seance = new ArrayList<Seance>();
	@ManyToMany(mappedBy = "series")
	private List<Question> questions = new ArrayList<Question>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cdRom")
	private CdRom cdRom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Seance> getSeance() {
		return seance;
	}
	public void setSeance(List<Seance> seance) {
		this.seance = seance;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public CdRom getCdRom() {
		return cdRom;
	}
	public void setCdRom(CdRom cdRom) {
		this.cdRom = cdRom;
	}
	
}
