package test;
import java.util.List;

import dao.EtudiantDaoImpl;
import metier.entities.Etudiant;
public class TestDao {
	
public static void main(String[] args) {
	EtudiantDaoImpl pdao= new EtudiantDaoImpl();
	Etudiant prod= pdao.save(new Etudiant("hilel","attia","hilelattia.dev@gmail.com"));
	System.out.println(prod);
	
	List<Etudiant> prods =pdao.etudiantsParNO("hilel");
	for (Etudiant p : prods)
	System.out.println(p);
}
}
