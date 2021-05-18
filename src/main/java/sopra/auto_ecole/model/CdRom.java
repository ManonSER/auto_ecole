package sopra.auto_ecole.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CDRom")
public class CdRom {
@Id
@GeneratedValue
private Long id; 
@Column(name = "editeur")
private String editeur;
@OneToMany(mappedBy = "cdRom" )
private List<Serie> series = new ArrayList<Serie>();
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEditeur() {
	return editeur;
}
public void setEditeur(String editeur) {
	this.editeur = editeur;
}
public List<Serie> getSeries() {
	return series;
}
public void setSeries(List<Serie> series) {
	this.series = series;
}
}
