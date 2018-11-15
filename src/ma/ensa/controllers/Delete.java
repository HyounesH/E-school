package ma.ensa.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.ensa.beans.helpers.Matiere_Prof;
import ma.ensa.dao.impl.EschoolDaoImpl;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref=request.getParameter("ref");
		HttpSession session=request.getSession();
	    int code=(int) session.getAttribute("code");
	    System.out.println(code);
	    System.out.println(ref);
	    EschoolDaoImpl dao =new EschoolDaoImpl();
	    dao.delete(code, ref);
	    List<Matiere_Prof> list=new ArrayList<Matiere_Prof>();
		list=dao.listMatieres(code);
	    request.setAttribute("matieres", list);
	    
		this.getServletContext().getRequestDispatcher("/matieres.jsp").forward(request, response);
	}

}
