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
}
