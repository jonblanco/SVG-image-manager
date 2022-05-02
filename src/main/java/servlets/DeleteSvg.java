package servlets;

import HTTPeXist.HTTPeXist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteSvg", value = "/DeleteSvg")
public class DeleteSvg extends HttpServlet {
    private HTTPeXist eXist;

    public void init(ServletConfig config) {
        System.out.println("---> Entrando en init()de DeleteSvg");
        eXist = new HTTPeXist("http://localHost:8080");
        System.out.println("---> Saliendo de init()de DeleteSvg");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String collection= request.getParameter("collection");
        String svgName = request.getParameter("svgName");

        //HTTPeXist eXist = new HTTPeXist("http://localHost:8080");
        eXist.delete(collection, svgName);
        System.out.println("     Redireccionando a index.jsp");
        request.setAttribute("informacion",  svgName+" irudia ongi ezabatu da!");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
        rd.forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
