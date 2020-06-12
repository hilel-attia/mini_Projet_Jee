	package dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.JPAutil;


import metier.entities.Etudiant;

	
	public class EtudiantDaoImpl implements IEtudiantDao {
		private EntityManager entityManager=JPAutil.getEntityManager("Mini_Projet_Jee");
	@Override
	
	 public Etudiant save(Etudiant p) {
	
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
		return p;
		}
	@Override
	public List<Etudiant> etudiantsParNO(String no) {
	List<Etudiant> prods = entityManager.createQuery("select p from Etudiant p where p.nomEtudiant like :no").setParameter("no", "%"+no+"%")
			 .getResultList();
			 return prods;
			}
			@Override
			public Etudiant getEtudiant(Long id) {
			 return entityManager.find(Etudiant.class, id);
			}
			@Override
			public Etudiant updateEtudiant(Etudiant p) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(p);
			tx.commit();
			return p;
			}
			@Override
			public void deleteEtudiant(Long id) {
			Etudiant etudiant = entityManager.find(Etudiant.class, id);
			entityManager.getTransaction().begin();
			entityManager.remove(etudiant);
			entityManager.getTransaction().commit();
			}
			}
		