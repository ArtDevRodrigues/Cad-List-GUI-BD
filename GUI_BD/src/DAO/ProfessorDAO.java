package DAO;

import Modelo.Professor;
import Factory.connectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
     
public class ProfessorDAO {
    private  Connection con;
    
    public ProfessorDAO() throws ClassNotFoundException{
        this.con = new connectionFactory().getConnection();
    }
    public void  adiciona(Professor p){
        String sql = "insert into professor(nome,cpf,email,telefone)"+"values(?,?,?,?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getCpf());
            stmt.setString(3,p.getEmail());
            stmt.setString(4,p.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
        
    }
    public List<Professor> tabela() throws SQLException{
          
//        String sql = "select * from professor";
//        PreparedStatement stmt =  con.prepareStatement(sql);
        List<Professor> profs = new ArrayList<>();
        
            
            String sql = "SELECT * FROM PROFESSOR";
            PreparedStatement stmt =  con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        try {
            
            while (rs.next()) {
                
                Professor pro = new Professor();
                pro.setNome(rs.getString("nome"));
                pro.setCpf(rs.getString("cpf"));
                pro.setEmail(rs.getString("email"));
                pro.setTelefone(rs.getString("telefone"));
                profs.add(pro);
                
                
                
                
            }
            
            
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return profs;
            
    }
    
    public Professor pesquisa(String nome)throws SQLException{
        
        String sql = "select nome,cpf,email,telefone "
                +"from agenda.professor "
                +"where nome like % "+nome+" %";
        
        PreparedStatement stmt =  con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        Professor pro = new Professor();
        try {
            
            while (rs.next()) {
                
                pro.setNome(rs.getString("nome"));
                pro.setCpf(rs.getString("cpf"));
                pro.setEmail(rs.getString("email"));
                pro.setTelefone(rs.getString("telefone"));
                
                
            }
         }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rs.close();
        con.close();
        return pro;
        
        
    }
    
    
    
}


















