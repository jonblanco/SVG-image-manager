package servlets;

import HTTPeXist.HTTPeXist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewImage", value = "/NewImage")
public class NewImage extends HttpServlet {
    private HTTPeXist eXist;

    public void init(ServletConfig config) {
        System.out.println("---> Entrando en init()de NewImage");
        eXist = new HTTPeXist("http://localHost:8080");
        System.out.println("---> Saliendo de init()de NewImage");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String collection= request.getParameter("collection");
        String svgName = request.getParameter("svgName");
        //String svgCode = request.getParameter()
        //HTTPeXist eXist = new HTTPeXist("http://localHost:8080");

        request.setAttribute("collection",collection);
        request.setAttribute("svgName",svgName);
        String imagenURI = "http://localhost:8080/exist/rest/db/" + collection + "/" + svgName + "/";
        request.setAttribute("imagenURI",imagenURI);
        request.setAttribute("imagenSVG", "");
        System.out.println("     Redireccionando a imagenEdit.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/imagenEdit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
