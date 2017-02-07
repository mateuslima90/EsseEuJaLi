
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author makingthehand
 */
public class Autenticar {
    
      static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Autenticar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String autenticar(String login, String senha) throws Exception{
        
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/dbweblibrary","postgres","pug@2014")){
            
            PreparedStatement ps =  c.prepareStatement(
            "select nome from usuario where login = ? and senha = ?");
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("nome");
            }
            else
                throw new Exception("Não foi possivel autenticar o usuário");
        }
    }
}
