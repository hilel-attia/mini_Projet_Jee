package metier.entities;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ETUDIANTS")
public class Etudiant implements Serializable{
	
	
	@Id
	@Column (name="ID_ETUDIANT")
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
private Long idEtudiant;
	@Column (name="NOM_ETUDIANT")
private String nomEtudiant;
	@Column (name="PRENOM_ETUDIANT")
private String prenomEtudiant;
	@Column (name="EMAIL_ETUDIANT")
private String emailEtudiant;

private Filiere filiere;
public Etudiant(String nomEtudiant, String prenomEtudiant, String emailEtudiant,Filiere fil) {
super();
this.nomEtudiant = nomEtudiant;
this.prenomEtudiant = prenomEtudiant;
this.emailEtudiant = emailEtudiant;
this.setFiliere(fil);
}
public Filiere getFiliere() {
return filiere;
}
public void setFiliere(Filiere filiere) {
this.filiere = filiere;
}

public Etudiant() {
super();
}
public Etudiant(String nomEtudiant,String prenomEtudiant,String emailEtudiant) {
super();
this.nomEtudiant = nomEtudiant;
this.prenomEtudiant = prenomEtudiant;
this.emailEtudiant = emailEtudiant;


}
public Long getIdEtudiant() {
	return idEtudiant;
}
public void setIdEtudiant(Long idEtudiant) {
	this.idEtudiant = idEtudiant;
}
public String getNomEtudiant() {
	return nomEtudiant;
}
public void setNomEtudiant(String nomEtudiant) {
	this.nomEtudiant = nomEtudiant;
}
public String getPrenomEtudiant() {
	return prenomEtudiant;
}
public void setPrenomEtudiant(String prenomEtudiant) {
	this.prenomEtudiant = prenomEtudiant;
}
public String getEmailEtudiant() {
	return emailEtudiant;
}
public void setEmailEtudiant(String emailEtudiant) {
	this.emailEtudiant = emailEtudiant;
	
}
@Override
public String toString() {
	return "Etudiant [idEtudiant=" + idEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant=" + prenomEtudiant
			+ ", emailEtudiant=" + emailEtudiant + "]";
}

}
