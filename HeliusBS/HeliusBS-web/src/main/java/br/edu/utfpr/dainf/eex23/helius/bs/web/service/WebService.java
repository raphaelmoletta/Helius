package br.edu.utfpr.dainf.eex23.helius.bs.web.service;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.HeliusEJB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rapha
 */
@WebServlet(urlPatterns = {"/ws/*"})
public class WebService extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request != null && !request.getRequestURI().isEmpty()) {
            String url = request.getRequestURI();
            if (url.endsWith("/")) {
                url = url.substring(0, url.length() - 2);
            }
            url = url.substring(url.lastIndexOf("/"), url.length());
            response.setContentType("application/json;charset=UTF-8");
            switch (url) {
                case "/home":
                    response.getWriter().println(HeliusEJB.mobile.getHome());
                    break;
                case "/tensao":
                    response.getWriter().println("{'teste':'tensao'}");
                    break;
                case "/corrente":
                    response.getWriter().println("{'teste':'corrente'}");
                    break;
                case "/eficiencia":
                    response.getWriter().println("{'teste':'eficiencia'}");
                    break;
                case "/incidencia":
                    response.getWriter().println("{'teste':'incidencia'}");
                    break;
                
            }
            response.getWriter().flush();
        }
    }
}
