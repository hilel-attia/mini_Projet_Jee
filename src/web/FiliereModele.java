package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Filiere;
public class FiliereModele {
List<Filiere> filieres = new ArrayList<>();
public List<Filiere> getFilieres() {
return filieres;
}
public void setFilieres(List<Filiere> filieres) {
this.filieres = filieres;
}
}
