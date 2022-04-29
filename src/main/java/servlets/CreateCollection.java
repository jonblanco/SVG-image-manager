package servlets;

import HTTPeXist.HTTPeXist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateCollection", value = "/CreateCollection")
public class CreateCollection extends HttpServlet {
    private HTTPeXist eXist;

    public void init(ServletConfig config) {
        System.out.println("---> Entrando en init()de CreateCollection");
        eXist = new HTTPeXist("http://localHost:8080");
        System.out.println("---> Saliendo de init()de CreateCollection");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String collection= request.getParameter("collection");


        //HTTPeXist eXist = new HTTPeXist("http://localHost:8080");
        eXist.create(collection);
        request.setAttribute("informacion", collection + " kolekzioa ongi sortu da!");
        System.out.println("     Redireccionando a index.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
