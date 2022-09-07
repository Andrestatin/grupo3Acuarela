
package acuarela.controlador;

import acuarela.modelo.Obra;
import acuarela.modelo.ObraDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorImag extends HttpServlet {
ObraDAO odao= new ObraDAO();
List<Obra>obra= new ArrayList();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        obra=odao.listar();
        switch (accion) {
            case "ejemplo":
                
                break;
            default:
                request.setAttribute("obra", obra);
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        odao.LIstarImg(id, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
