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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EschoolDaoImpl dao=new EschoolDaoImpl();
		 String login=request.getParameter("login");
		 String pass=request.getParameter("password");
		 if(dao.isLogin(login, pass)){
			 String nom=dao.getNom(login, pass);
			 int code=dao.getCode(login, pass);
			 HttpSession session=request.getSession();
			 session.setAttribute("code", code);
			 session.setAttribute("user", nom);
			 List<Matiere_Prof> list=new ArrayList<>();
			 list=dao.listMatieres(code);
			 request.setAttribute("matieres", list);
			 this.getServletContext().getRequestDispatcher("/matieres.jsp").forward(request, response);
		 }
		 else{
			 String message="probléme d'authentification .<br> code ou mot de pass incorrect";
		     request.setAttribute("message", message);
			 this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		 }
	}

}
