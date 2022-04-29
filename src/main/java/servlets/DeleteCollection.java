package servlets;

import HTTPeXist.HTTPeXist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCollection", value = "/DeleteCollection")
public class DeleteCollection extends HttpServlet {
    private HTTPeXist eXist;

    public void init(ServletConfig config) {
        System.out.println("---> Entrando en init()de DeleteCollection");
        eXist = new HTTPeXist("http://localHost:8080");
        System.out.println("---> Saliendo de init()de DeleteCollection");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String collection= request.getParameter("collection");
        eXist.delete(collection);

        //HTTPeXist eXist = new HTTPeXist("http://localHost:8080");


        request.setAttribute("informacion", collection + " ondo ezabatu da!");

        System.out.println("     Redireccionando a index.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
