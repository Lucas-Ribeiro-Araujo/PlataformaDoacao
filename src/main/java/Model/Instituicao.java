package Model;

import java.util.*;
import DAO.InstituicaoDAO;

public class Instituicao extends Cadastro {

    // Atributos
    private String area;
    private String descricao;

    public Instituicao() {
    }

    public Instituicao(int id, String nome, String senha, String endereco, String telefone, String area, String descricao) {
        super(id, nome, senha, endereco, telefone);
        this.area = area;
        this.descricao = descricao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Override necessário para poder retornar os dados de Pessoa no toString para aluno.
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Endereço: " + this.getEndereco()
                + "\n Telefone: " + this.getTelefone()
                + "\n Área: " + this.getArea()
                + "\n Descrição: " + this.getDescricao()
                + "\n -----------";
    }

    public ArrayList getMinhaLista() {
        return InstituicaoDAO.MinhaLista;
    }

    // Cadastra novo aluno
    public boolean InsertInstituicaoBD(Instituicao objeto) {
        InstituicaoDAO.MinhaLista.add(objeto);
        return true;

    }

    // Deleta um aluno específico pelo seu campo ID
    public boolean DeleteInstituicaoBD(int id) {
        int indice = this.procuraIndice(id);
        InstituicaoDAO.MinhaLista.remove(indice);
        return true;
    }

    // Edita um aluno específico pelo seu campo ID
    public boolean UpdateInstituicaoBD(int id, Instituicao objeto) {
        int indice = this.procuraIndice(id);
        InstituicaoDAO.MinhaLista.set(indice, objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < InstituicaoDAO.MinhaLista.size(); i++) {
            if (InstituicaoDAO.MinhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    // carrega dados de um aluno específico pelo seu ID
    public Instituicao carregaInstituicao(int id) {
        int indice = this.procuraIndice(id);
        return InstituicaoDAO.MinhaLista.get(indice);
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() {
        return InstituicaoDAO.maiorID();
    }
    
}
