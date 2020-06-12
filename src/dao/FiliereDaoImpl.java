package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Filiere;
import util.JPAutil;
public class FiliereDaoImpl implements IFiliereDao {

private EntityManager entityManager=JPAutil.getEntityManager("Mini_Projet_Jee");
@Override
public Filiere save(Filiere fil ) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(fil);
tx.commit();
return fil;
}
@Override
public Filiere getFiliere(Long id) {
 return entityManager.find(Filiere.class, id);
}
@Override
public Filiere updateFiliere(Filiere fil) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(fil);
tx.commit();
return fil;
}
@Override
public void deleteFiliere(Long id) {
	Filiere filiere = entityManager.find(Filiere.class, id);
entityManager.getTransaction().begin();
entityManager.remove(filiere);
entityManager.getTransaction().commit();
}
@Override
public List<Filiere> getAllFilieres() {
List<Filiere> fils =
entityManager.createQuery("select c from Filiere c").getResultList();
return fils;
}
}