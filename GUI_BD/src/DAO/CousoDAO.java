package DAO;

import Factory.connectionFactory;
import Modelo.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arthur H. Rodrigues
 */
public class CousoDAO {
     private  Connection con;
    
    public CousoDAO(){
        this.con = new connectionFactory().getConnection();
    }
    public void  adiciona(Curso a){
        String sql = "insert into curso(id_curso,nome_curso)"+"values(?,?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,a.getId_curso());
            stmt.setString(2,a.getNome_curso());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
        
    }
    public List<Curso> tabela() throws SQLException{
          
//        String sql = "select * from professor";
//        PreparedStatement stmt =  con.prepareStatement(sql);
        List<Curso> cursos = new ArrayList<>();
        
            
            String sql = "SELECT * FROM CURSO";
            PreparedStatement stmt =  con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        try {
            
            while (rs.next()) {
                
                Curso c = new Curso();
                c.setId_curso(rs.getString("id_curso"));
                c.setNome_curso(rs.getString("nome_curso"));
                cursos.add(c);
                
                
                
                
            }
            
            
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return cursos;
    }
    
}






