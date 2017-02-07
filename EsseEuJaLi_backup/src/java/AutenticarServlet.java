

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author makingthehand
 */
@WebServlet("/autenticar")
public class AutenticarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
      
        Autenticar autenticador = new Autenticar();
        
        try {
            String nomeUsuario = autenticador.autenticar(login, senha);
            request.setAttribute("nome", nomeUsuario);
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AutenticarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
