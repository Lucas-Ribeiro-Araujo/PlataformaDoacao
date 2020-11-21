package Model;

import java.util.*;
import DAO.DoadorDAO;

public class Doador extends Cadastro {

    // Atributos
    private String cpf;

    // M�todo Construtor de Objeto Vazio
    public Doador() {
    }

    // M�todo Construtor de Objeto, inserindo dados
    public Doador(String cpf ) {
        this.cpf = cpf;

    }

    // M�todo Construtor usando tamb�m o construtor da SUPERCLASSE
    public Doador(int id, String nome, String senha , String endereco , String telefone, String cpf) {
        super(id, nome, senha, endereco, telefone);
        this.cpf = cpf;

    }

    // M�todos GET e SET
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
                + "\n Endere�o: " + this.getEndereco()
                + "\n Telefone: " + this.getTelefone()
                + "\n Cpf: " + this.getCpf()
                + "\n -----------";
    }

    /*
    
        ABAIXO OS M�TODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    
     */
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        return DoadorDAO.MinhaLista;
    }

    // Cadastra novo aluno
    public boolean InsertDoadorBD(Doador objeto) {
        DoadorDAO.MinhaLista.add(objeto);
        return true;

    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteDoadorBD(int id) {
        int indice = this.procuraIndice(id);
        DoadorDAO.MinhaLista.remove(indice);
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateDoadorBD(int id, Doador objeto) {
        int indice = this.procuraIndice(id);
        DoadorDAO.MinhaLista.set(indice, objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < DoadorDAO.MinhaLista.size(); i++) {
            if (DoadorDAO.MinhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    // carrega dados de um aluno espec�fico pelo seu ID
    public Doador carregaDoador(int id) {
        int indice = this.procuraIndice(id);
        return DoadorDAO.MinhaLista.get(indice);
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() {
        return DoadorDAO.maiorID();
    }
}
