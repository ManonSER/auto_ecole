package sopra.auto_ecole.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Client {
	
	private int id;
	private String nom;
	private String prenom;
	private Date dtNaissance;
	private Adresse adresse;
	private List<Seance> seances = new ArrayList<Seance>();
	
	public Client() {
		super();
	}
	
	public Client(int id, String nom, String prenom, Date dtNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dtNaissance = dtNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	
	public void addUe(Seance seance) {
		this.seances.add(seance);
	}
	
	
	
	
	

}
