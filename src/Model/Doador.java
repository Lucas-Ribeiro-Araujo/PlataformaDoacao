package Model;

import java.util.*;
import DAO.DoadorDAO;
import java.sql.SQLException;

public class Doador extends Cadastro {

    private String senha;
    private String cpf;
    private final DoadorDAO dao;

    public Doador() {
        this.dao = new DoadorDAO();
    }

    public Doador(String senha, String cpf) {
        this.senha = senha;
        this.cpf = cpf;
        this.dao = new DoadorDAO();
    }

    public Doador(String senha, String cpf, int id, String nome, String endereco, String telefone) {
        super(id, nome, endereco, telefone);
        this.senha = senha;
        this.cpf = cpf;
        this.dao = new DoadorDAO();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Override necess�rio para poder retornar os dados de Pessoa no toString para aluno.
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Senha: " + this.getSenha()
                + "\n Endereco: " + this.getEndereco()
                + "\n Telefone:" + this.getTelefone()
                + "\n Cpf: " + this.getCpf()
                + "\n -----------";
    }

    /*
    
        ABAIXO OS M�TODOS PARA USO JUNTO COM O DAO
    
     */
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    // Cadastra novo aluno
    public boolean InsertDoadorBD(Doador objeto) {
        dao.InsertDoadorBD(objeto);
        return true;
    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteDoadorBD(int id) {
        dao.DeleteDoadorBD(id);
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateDoadorBD(Doador objeto) {
        dao.UpdateDoadorBD(objeto);
        return true;
    }

    // carrega dados de um aluno espec�fico pelo seu ID
    public Doador carregaDoador(int id) {
        dao.carregaDoador(id);
        return null;
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
