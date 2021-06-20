package Factory;

import DAO.ProfessorDAO;
import java.sql.SQLException;
import Modelo.Professor;

public class testaConexao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("iniciando.....");
        
        ProfessorDAO dao = new ProfessorDAO();
        Professor p = new Professor();
        
        System.out.println("cadastrando....");
        
        p.setNome("Ze ninquem");
        p.setCpf("1234567800");
        p.setEmail("teste002@gmail.com");
        p.setTelefone("(86)99875-5432");
        
        
        dao.adiciona(p);
        System.out.println("Finalizado.");
    }
}

//        Connection c = new connectionFactory().getConnection();
//        System.out.println("conexao aberta!!");
//        c.close();
//                