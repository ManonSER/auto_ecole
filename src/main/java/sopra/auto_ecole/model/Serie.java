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
import javax.persistence.Table;
import sopra.auto_ecole.model.*;
@Entity
@Table(name = "Serie")
public class Serie {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "seance")
	private Seance seance;
	@ManyToMany(mappedBy = "series")
	private List<Questions> questions = new ArrayList<Question>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cdRom")
	private CdRom cdRom;
	
}
