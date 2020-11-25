package Model;

import java.util.*;
import DAO.DoadorDAO;
import java.sql.SQLException;

public class Doador extends Cadastro {

    // Atributos
    private String cpf;
    private final DoadorDAO dao;

    // Metodo Construtor de Objeto Vazio
    public Doador() {
          this.dao = new DoadorDAO(); // inicializado năo importa em qual construtor
    }
    

    // Metodo Construtor de Objeto, inserindo dados
    public Doador(String cpf ) {
        this.cpf = cpf;
        this.dao = new DoadorDAO(); // inicializado năo importa em qual construtor

    }

    // Metodo Construtor usando tambem o construtor da SUPERCLASSE
    public Doador(int id, String nome, String senha , String endereco , String telefone, String cpf) {
        super(id, nome, senha, endereco, telefone);
        this.cpf = cpf;
        this.dao = new DoadorDAO(); // inicializado năo importa em qual construtor

    }

  

    // Metodos GET e SET
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Override necessario para poder retornar os dados de Pessoa no toString para aluno.
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Endereço: " + this.getEndereco()
                + "\n Telefone: " + this.getTelefone()
                + "\n Cpf: " + this.getCpf()
                + "\n -----------";
    }

    /*
    
        ABAIXO OS MeTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    
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

    // Deleta um aluno especefico pelo seu campo ID
    public boolean DeleteDoadorBD(int id) {
        dao.DeleteDoadorBD(id);
        return true;
    }

    // Edita um aluno especefico pelo seu campo ID
    public boolean UpdateDoadorBD( Doador objeto) {
        dao.InsertDoadorBD(objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
//    private int procuraIndice(int id) {
//        int indice = -1;
//        for (int i = 0; i < DoadorDAO.MinhaLista.size(); i++) {
//            if (DoadorDAO.MinhaLista.get(i).getId() == id) {
//                indice = i;
//            }
//        }
//        return indice;
//    }

    // carrega dados de um aluno especefico pelo seu ID
    public Doador carregaDoador(int id) {
        dao.carregaDoador(id);
        return null;
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
}
