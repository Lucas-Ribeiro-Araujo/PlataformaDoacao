/*
 Aqui vamos simular a persistencia de dados.
 Nas proximas aulas nos vamos reprogramar esta classe para conectar-se com o banco de dados.
 */
package DAO;

import Model.Doador;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoadorDAO {

    public static ArrayList<Doador> MinhaLista = new ArrayList<Doador>();

    public DoadorDAO() {

    }

    public int maiorID() throws SQLException {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_doador");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();
        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;  //instância da conexăo

        try {

            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conexăo
            String server = "localhost"; //caminho do MySQL
            String database = "db_doador";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "cesar";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NĂO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver năo encontrado
            System.out.println("O driver nao foi encontrado.");
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {

        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_doador");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String endereco = res.getString("Endereço");
                String telefone = res.getString("Telefone");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");

                Doador objeto = new Doador(id, nome, senha, endereco, telefone, cpf);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo aluno
    public boolean InsertDoadorBD(Doador objeto) {
        String sql = "INSERT INTO tb_doador(id,nome,senha,endereco,telefone,cpf) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getSenha());
            stmt.setString(4, objeto.getEndereco());
            stmt.setString(5, objeto.getTelefone());
            stmt.setString(6, objeto.getCpf());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Deleta um aluno específico pelo seu campo ID
    public boolean DeleteDoadorBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_doador WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    // Edita um aluno específico pelo seu campo ID
    public boolean UpdateDoadorBD(Doador objeto) {

        String sql = "UPDATE tb_doador set nome = ? ,senha = ? ,endereco = ? ,telefone = ? ,cpf = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getSenha());
            stmt.setString(4, objeto.getEndereco());
            stmt.setString(5, objeto.getTelefone());
            stmt.setString(6, objeto.getCpf());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Doador carregaDoador(int id) {

        Doador objeto = new Doador();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * id FROM tb_doador WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setEndereco(res.getString("endereço"));
            objeto.setTelefone(res.getString("telefone"));
            objeto.setCpf(res.getString("cpf"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }
}


