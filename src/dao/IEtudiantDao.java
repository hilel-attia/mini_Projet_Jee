package dao;
import java.util.List;
import metier.entities.Etudiant;
public interface IEtudiantDao {
public Etudiant save(Etudiant p);
public List<Etudiant> etudiantsParNO(String no);
public Etudiant getEtudiant(Long id);
public Etudiant updateEtudiant(Etudiant p);
public void deleteEtudiant(Long id);
}
