package DAO;

import Model.Instituicao;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InstituicaoDAO {

    public static ArrayList<Instituicao> MinhaLista = new ArrayList<Instituicao>();

    public InstituicaoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_instituicao");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;  //instância da conexão

        try {

            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conexão
            String server = "localhost"; //caminho do MySQL
            String database = "db_doar";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "rootpass";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver nao foi encontrado.");
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    // Retorna a Lista de Instituicao(objetos)
    public ArrayList getMinhaLista() {

        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_instituicao");
            while (res.next()) {

                String area = res.getString("area");
                String descricao = res.getString("descricao");
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String endereco = res.getString("endereco");
                String telefone = res.getString("telefone");
                double doacao = res.getDouble("saldo");

                Instituicao objeto = new Instituicao(area, descricao, id, nome, endereco, telefone, doacao);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra nova Instituicao
    public boolean InsertInstituicaoBD(Instituicao objeto) {
        String sql = "INSERT INTO tb_instituicao(id,nome,endereco,telefone,area,descricao,saldo) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getEndereco());
            stmt.setString(4, objeto.getTelefone());
            stmt.setString(5, objeto.getArea());
            stmt.setString(6, objeto.getDescricao());
            stmt.setDouble(7, objeto.getDoacao());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteInstituicaoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_instituicao WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    // Edita uma Instituicao específica pelo seu campo ID
    public boolean UpdateInstituicaoBD(Instituicao objeto) {

        String sql = "UPDATE tb_instituicao set nome = ? ,endereco = ? ,telefone = ? ,area = ? ,descricao = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getEndereco());
            stmt.setString(3, objeto.getTelefone());
            stmt.setString(4, objeto.getArea());
            stmt.setString(5, objeto.getDescricao());
            stmt.setInt(6, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Instituicao carregaInstituicao(int id) {

        Instituicao objeto = new Instituicao();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * id FROM tb_instituicao WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setEndereco(res.getString("endereco"));
            objeto.setTelefone(res.getString("telefone"));
            objeto.setArea(res.getString("area"));
            objeto.setDescricao(res.getString("descricao"));
            objeto.setDoacao(res.getDouble("saldo"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }

    public boolean Doar(Instituicao objeto) {

        String sql = "UPDATE tb_instituicao set saldo = saldo + ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setDouble(1, objeto.getDoacao());
            stmt.setInt(2, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
