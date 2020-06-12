package dao;
import java.util.List;
import metier.entities.Filiere;
public interface IFiliereDao {
public Filiere save(Filiere fil);
public Filiere getFiliere(Long id);
public Filiere updateFiliere(Filiere fil);
public void deleteFiliere(Long id);
public List<Filiere> getAllFilieres();
}
