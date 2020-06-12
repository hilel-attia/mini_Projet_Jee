package metier.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Filiere implements Serializable {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long idFil;
private String nomFil;
private String codeFil;


@Temporal( TemporalType.DATE )
private Date dateCreation;
@OneToMany (mappedBy="filiere")
private List<Etudiant> etudiants;

public Filiere() {
super();
}
public Filiere(String nomFil,  Date dateCreation) {
super();
this.nomFil = nomFil;
this.dateCreation = dateCreation;

}
public Long getIdFil() {
	return idFil;
}
public void setIdFil(Long idFil) {
	this.idFil = idFil;
}
public String getNomFil() {
	return nomFil;
}
public void setNomFil(String nomFil) {
	this.nomFil = nomFil;
}

public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public List<Etudiant> getEtudiants() {
	return etudiants;
}
public void setEtudiants(List<Etudiant> etudiants) {
	this.etudiants = etudiants;
}
}