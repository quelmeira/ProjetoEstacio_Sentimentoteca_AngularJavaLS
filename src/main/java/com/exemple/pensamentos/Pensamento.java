import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Pensamento {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestao_alunos", "username", "password");

            String insertAlunoSQL = "INSERT INTO alunos (nome, data_nascimento, turma, contato_responsavel, endereco, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertAlunoSQL);
            insertStmt.setString(1, "Pedro Costa");
            insertStmt.setDate(2, java.sql.Date.valueOf("2011-03-22"));
            insertStmt.setString(3, "7A");
            insertStmt.setString(4, "José Costa, (11) 91234-5678");
            insertStmt.setString(5, "Rua Nova, 456");
            insertStmt.setString(6, "jose@exemplo.com");

            int rowsAffected = insertStmt.executeUpdate();
            System.out.println(rowsAffected + " aluno(s) inserido(s).");

            insertStmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
