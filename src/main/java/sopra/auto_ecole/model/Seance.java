package sopra.auto_ecole.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Seance {
	@Id
	@GeneratedValue
	private int id;
	private Date date;
	private int nombreFautes;
	private Boolean estExamen;
	@OneToMany(mappedBy="seance")
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@OneToMany(mappedBy = "seance")
	private Serie serie;
	
	public int getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	public int getNombreFautes() {
		return nombreFautes;
	}
	public Boolean getEstExamen() {
		return estExamen;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setNombreFautes(int nombreFautes) {
		this.nombreFautes = nombreFautes;
	}
	public void setEstExamen(Boolean estExamen) {
		this.estExamen = estExamen;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "seance [id=" + id + ", date=" + date + ", nombreFautes=" + nombreFautes + ", estExamen=" + estExamen
				+ "]";
	}
	
	

}
