package DAO;
import Factory.connectionFactory;
import Modelo.Aluno;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
     private  Connection con;
    
    public AlunoDAO() throws ClassNotFoundException{
        this.con = new connectionFactory().getConnection();
    }
    public void  adiciona(Aluno a){
        String sql = "insert into aluno(nome,cpf,email,telefone,matricula)"+"values(?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,a.getNome());
            stmt.setString(2,a.getCpf());
            stmt.setString(3,a.getEmail());
            stmt.setString(4,a.getTelefone());
            stmt.setString(5,a.getMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
        
    }
    public List<Aluno> tabela() throws SQLException{
          
//        String sql = "select * from professor";
//        PreparedStatement stmt =  con.prepareStatement(sql);
        List<Aluno> als = new ArrayList<>();
        
            
            String sql = "SELECT * FROM ALUNO";
            PreparedStatement stmt =  con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        try {
            
            while (rs.next()) {
                
                Aluno alu = new Aluno();
                alu.setNome(rs.getString("nome"));
                alu.setCpf(rs.getString("cpf"));
                alu.setEmail(rs.getString("email"));
                alu.setTelefone(rs.getString("telefone"));
                alu.setMatricula(rs.getString("matricula"));
                als.add(alu);
                
                
                
                
            }
            
            
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return als;
    }
}