package web;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.FiliereDaoImpl;
import dao.IFiliereDao;
import metier.entities.Filiere;
@WebServlet (name="filServ",urlPatterns= {"/filieres","/saisieFiliere",
"/saveFiliere","/supprimerFil","/editerFil","/updateFil"})


public class FiliereServlet extends HttpServlet {
	IFiliereDao metier;
	@Override
	public void init() throws ServletException {
	metier = new FiliereDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	String path=request.getServletPath();
	System.out.println("PATH "+path);
	if (path.equals("/filieres"))
	{
	FiliereModele model= new FiliereModele();
	List<Filiere> fils = metier.getAllFilieres();
	model.setFilieres(fils);
	request.setAttribute("model", model);
	request.getRequestDispatcher("Filieres.jsp").forward(request,response);
	}
	else if (path.equals("/saisieFiliere") )
	{
	request.getRequestDispatcher("saisieFiliere.jsp").forward(request,response
	);
	}
	else if (path.equals("/saveFiliere") &&
	request.getMethod().equals("POST"))
	{
	Date dateFil= new Date();
	 String nom=request.getParameter("nom");
	 String pattern = "yyyy-MM-dd";
	 SimpleDateFormat simpleDateFormat = new
	SimpleDateFormat(pattern);
	 try {dateFil =
			 simpleDateFormat.parse(request.getParameter("dateFil"));
	 } catch (ParseException e) {
	 e.printStackTrace();
	 }

	 Filiere fil = metier.save(new Filiere(nom,dateFil));
	 request.setAttribute("filiere", fil);
	 response.sendRedirect("filieres");
	 }
	 else if (path.equals("/supprimerCat"))
	 {
	  Long id= Long.parseLong(request.getParameter("id"));
	  metier.deleteFiliere(id);
	  response.sendRedirect("filieres");
	 }
	 else if (path.equals("/editerFil") )
	 {
	 Long id= Long.parseLong(request.getParameter("id"));
	  Filiere fil = metier.getFiliere(id);
	  request.setAttribute("filiere", fil);
	 request.getRequestDispatcher("editerFiliere.jsp").forward(request,response
	 );
	 }
	 else if (path.equals("/updateFil") )
	 {
	 Date dateFil= new Date();
	 Long id = Long.parseLong(request.getParameter("id"));
	 String nom=request.getParameter("nom");
	
	 Filiere fil = new Filiere();
	 fil.setIdFil(id);
	 fil.setNomFil(nom);
	
	 String pattern = "yyyy-MM-dd";
	 SimpleDateFormat simpleDateFormat = new
	 SimpleDateFormat(pattern);
	  try {
	 dateFil =
	 simpleDateFormat.parse(request.getParameter("dateCreation"));
	 } catch (ParseException e) {
	 e.printStackTrace();
	 }
	 fil.setDateCreation(dateFil);
	  metier.updateFiliere(fil);
	 response.sendRedirect("filieres");
	 }
	 else
	 {
	 response.sendError(Response.SC_NOT_FOUND);
	 }
	 }
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws
	ServletException, IOException {
		doGet(request,response);
		}
		 
	
}

