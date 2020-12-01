package Control;

import Model.Doador;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoadorControl {

    private final Doador doador;

    public DoadorControl() {
        this.doador = new Doador(); // Veja que control � um objeto vazio de Aluno
    }

    // Create 
    public boolean Cadastrar(String senha, String cpf, String nome, String endereco, String telefone) throws SQLException {

        // AlunoControl recebe os dados da VIEW, cria um objeto COMPLETO e manda este objeto para aluno para inserir em (DAO)
        // Aluno CONTROL N�O DEVE ACESSAR DAO DIRETAMENTE. L� em aluno deve ter uma fun��o que acessa DAO para inserir. InsertAlunoBD()
        int id = doador.maiorID() + 1;
        Doador objeto = new Doador(senha, cpf, id, nome, endereco, telefone);
        if (doador.InsertDoadorBD(objeto)) {
            return true;
        } else {
            return false;
        }
    }

    // Update
    public boolean Editar(String senha, String cpf, int id, String nome, String endereco, String telefone) {
        Doador objeto = new Doador(senha, cpf, id, nome, endereco, telefone);
        if (doador.UpdateDoadorBD(objeto)) {
            return true;
        } else {
            return false;
        }
    }

    // Delete
    public boolean Apagar(int id) {
        if (doador.DeleteDoadorBD(id)) {
            return true;
        } else {
            return false;
        }
    }

    // Read
    public Doador LoadDoador(int id) {
        // procurar o aluno com este id e retornar um objeto com TODOS OS DADOS.
        return doador.carregaDoador(id);
    }

    // Read
    public ArrayList getMinhaLista() {
        return doador.getMinhaLista();
    }

    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {

        ArrayList<Doador> minhalista = doador.getMinhaLista();
        int tamanho = minhalista.size();

        String MatrizDoador[][] = new String[tamanho][6];
        for (int i = 0; i < tamanho; i++) {
            MatrizDoador[i][0] = minhalista.get(i).getId() + "";
            MatrizDoador[i][1] = minhalista.get(i).getNome();
            MatrizDoador[i][2] = minhalista.get(i).getSenha();
            MatrizDoador[i][3] = minhalista.get(i).getEndereco();
            MatrizDoador[i][4] = minhalista.get(i).getTelefone();
            MatrizDoador[i][5] = minhalista.get(i).getCpf();
        }

        return MatrizDoador;
    }

}
