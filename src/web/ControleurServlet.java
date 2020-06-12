	package web;
	import java.io.IOException;
	import java.util.List;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.apache.catalina.connector.Response;
	
	import dao.EtudiantDaoImpl;
	import dao.FiliereDaoImpl;
	import dao.IEtudiantDao;
	import dao.IFiliereDao;
	import metier.entities.Etudiant;
	import metier.entities.Filiere;
	
	@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
	public class ControleurServlet extends HttpServlet {
		
	
	IEtudiantDao metier;
	IFiliereDao metierFil;
	
	
	@Override
	public void init() throws ServletException {
	metier = new EtudiantDaoImpl();
	metierFil = new FiliereDaoImpl();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
	 HttpServletResponse response)
	 throws ServletException, IOException {
	String path=request.getServletPath();
	if (path.equals("/index.do"))
	{
	request.getRequestDispatcher("etudiants.jsp").forward(request,response);
	}
	else if (path.equals("/chercher.do"))
	{
		
		
	String motCle=request.getParameter("motCle");
	EtudiantModele model= new EtudiantModele();
	model.setMotCle(motCle);
	List<Etudiant> prods = metier.etudiantsParNO(motCle);
	model.setEtudiants(prods);
	request.setAttribute("model", model);
	
	request.getRequestDispatcher("etudiants.jsp").forward(request,response);
	}
	else if (path.equals("/saisie.do") )
		
	{
		
			List<Filiere> fils = metierFil.getAllFilieres();
			FiliereModele model= new FiliereModele();
			model.setFilieres(fils);
			request.setAttribute("filModel", model);
	request.getRequestDispatcher("saisieEtudiant.jsp").forward(request,response);
	}
	else if (path.equals("/save.do") && request.getMethod().equals("POST"))
	{
	 String nom=request.getParameter("nom");
	String prenom=request.getParameter("prenom");
	String email=request.getParameter("email");
	Long filiereId=Long.parseLong(request.getParameter("filiere"));

	Filiere fil = metierFil.getFiliere(filiereId);
	Etudiant p = metier.save(new Etudiant(nom,prenom,email));
	
	request.setAttribute("etudiant", p);
	response.sendRedirect("chercher.do?motCle=");
	}
	else if (path.equals("/supprimer.do"))
	{
	 Long id= Long.parseLong(request.getParameter("id"));
	 metier.deleteEtudiant(id);
	 response.sendRedirect("chercher.do?motCle=");
	}
	
	
	else if (path.equals("/editer.do") )
	{
	Long id= Long.parseLong(request.getParameter("id"));
	 Etudiant p = metier.getEtudiant(id);
	 request.setAttribute("etudiant", p);
	 List<Filiere> fils = metierFil.getAllFilieres();
		FiliereModele model= new FiliereModele();
		model.setFilieres(fils);
		request.setAttribute("filModel", model);
	
	request.getRequestDispatcher("editerEtudiant.jsp").forward(request,response);
	}
	else if (path.equals("/update.do") )
	{
	Long id = Long.parseLong(request.getParameter("id"));
	String nom=request.getParameter("nom");
	String prenom=request.getParameter("prenom");
	String email=request.getParameter("email");
	Long filiereId=Long.parseLong(request.getParameter("filiere"));
	Etudiant p = new Etudiant();
	p.setIdEtudiant(id);
	p.setNomEtudiant(nom);
	p.setPrenomEtudiant(prenom);
	p.setEmailEtudiant(email);
	
	Filiere fil = metierFil.getFiliere(filiereId);
	p.setFiliere(fil);
	metier.updateEtudiant(p);
	response.sendRedirect("chercher.do?motCle=");
	}
	else
	{
	response.sendError(Response.SC_NOT_FOUND);
	}
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
	 HttpServletResponse response) throws
	ServletException, IOException {
	doGet(request,response);
	}
	}
	
	
