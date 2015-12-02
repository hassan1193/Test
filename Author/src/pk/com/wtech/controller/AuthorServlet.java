package pk.com.wtech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pk.com.wtech.dto.Author;
import pk.com.wtech.dao.GenericDAO;
import pk.com.wtech.dao.impl.AuthorDAOImpl;
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/author.jsp";
	    private static String LIST_AUTHOR = "/listauthor.jsp";
			private GenericDAO dao;
			public void init() throws ServletException {
		super.init();
		 dao = new AuthorDAOImpl(getServletContext());
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String forward="";
     String action = request.getParameter("action");
     if(action.equals("delete")){
    	 int bookId = Integer.parseInt(request.getParameter("id"));
    	 System.out.println(request.getParameter("id"));
         dao.deleteAuthor(bookId);
         forward = LIST_AUTHOR;     
         request.setAttribute("books", dao.getAllAuthors());
    }else if (action.equalsIgnoreCase("edit")){
        forward = INSERT_OR_EDIT;
        int bookId = Integer.parseInt(request.getParameter("id"));
       Author book = dao.getAuthorById(bookId);
        request.setAttribute("book", book);
       
    } else if (action.equalsIgnoreCase("listauthor")){
        forward = LIST_AUTHOR;
        request.setAttribute("books", dao.getAllAuthors());
    } else {
        forward = INSERT_OR_EDIT;
    }
     RequestDispatcher view = request.getRequestDispatcher(forward);
     view.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Author au=new Author();
		au.setName(request.getParameter("name"));
		au.setPublisher(request.getParameter("publisher"));
		au.setAddress(request.getParameter("address"));
		String auth=request.getParameter("id");
        String id = request.getParameter("id");
	      
		 if(auth== null || auth.isEmpty())
	        {
	    	 dao.addAuthor(au);
	        }
	        else
	        {
	           au.setId(Integer.parseInt(auth));
	           dao.updateAuthor(au);
	        }
		
		 RequestDispatcher view = request.getRequestDispatcher(LIST_AUTHOR);
	        request.setAttribute("authors", dao.getAllAuthors());
	        view.forward(request, response);
		
		
		
		
	}

}
