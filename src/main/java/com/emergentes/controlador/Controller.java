package com.emergentes.controlador;
import com.emergentes.modelo.GestorLibros;
import com.emergentes.modelo.Libros;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Libros libro1= new Libros();
        int id, pos;
        String opcion = request.getParameter("op");
        String op = (opcion!=null)?request.getParameter("op"):"vista";
        if (op.equals("nuevo")) {
            HttpSession sesion = request.getSession();
            GestorLibros agenda = (GestorLibros)sesion.getAttribute("agenda");
            libro1.setId(agenda.buscaId());
            request.setAttribute("op", op);
            request.setAttribute("miLibro", libro1);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("modificar")) {
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession sesion = request.getSession();
            GestorLibros agenda = (GestorLibros)sesion.getAttribute("agenda");
            pos = agenda.buscaLibro(id);
            libro1 = agenda.getLista().get(pos);
            request.setAttribute("op", op);
            request.setAttribute("miLibro", libro1);
            request.getRequestDispatcher("editar.jsp").forward(request, response);  
        }
        if (op.equals("eliminar")) {
            id=Integer.parseInt(request.getParameter("id"));
            HttpSession sesion = request.getSession();
            GestorLibros agenda = (GestorLibros)sesion.getAttribute("agenda");
            pos=agenda.buscaLibro(id);
            agenda.eliminaLibro(pos);
            sesion.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
        }
        if (op.equals("vista")) {
            response.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Libros libro = new Libros();
        int pos;
        String op=request.getParameter("op");
        if (op.equals("grabar")) {
            libro.setId(Integer.parseInt(request.getParameter("id")));
            libro.setTitulo(request.getParameter("titulo"));
            libro.setAutor(request.getParameter("autor"));
            libro.setResumen(request.getParameter("resumen"));
            libro.setMedio(request.getParameter("medio"));
            HttpSession sesion = request.getSession();
            GestorLibros agenda = (GestorLibros)sesion.getAttribute("agenda");
            String opg = request.getParameter("opg");
            if (opg.equals("nuevo")) {
                agenda.insertaLibro(libro);
            }else{
                pos=agenda.buscaLibro(libro.getId());
                agenda.modificaLibro(pos, libro);
            }
            sesion.setAttribute("agenda", agenda);
            response.sendRedirect("index.jsp");
        }
    }
}
