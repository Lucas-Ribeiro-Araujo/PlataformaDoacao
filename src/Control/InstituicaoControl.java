package Control;

import Model.Instituicao;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstituicaoControl {

    private final Instituicao instituicao;

    public InstituicaoControl() {
        this.instituicao = new Instituicao(); // Veja que control � um objeto vazio de Aluno
    }

    // Create 
    public boolean Cadastrar(String area, String descricao, String nome, String endereco, String telefone, double doacao) throws SQLException {

        // AlunoControl recebe os dados da VIEW, cria um objeto COMPLETO e manda este objeto para aluno para inserir em (DAO)
        // Aluno CONTROL N�O DEVE ACESSAR DAO DIRETAMENTE. L� em aluno deve ter uma fun��o que acessa DAO para inserir. InsertAlunoBD()
        int id = instituicao.maiorID() + 1;
        Instituicao objeto = new Instituicao(area, descricao, id, nome, endereco, telefone, doacao);
        if (instituicao.InsertInstituicaoBD(objeto)) {
            return true;
        } else {
            return false;
        }
    }

    // Update
    public boolean Editar(String area, String descricao, int id, String nome, String endereco, String telefone, double doacao) {
        Instituicao objeto = new Instituicao(area, descricao, id, nome, endereco, telefone, doacao);
        if (instituicao.UpdateInstituicaoBD(objeto)) {
            return true;
        } else {
            return false;
        }
    }

    // Delete
    public boolean Apagar(int id) {
        if (instituicao.DeleteInstituicaoBD(id)) {
            return true;
        } else {
            return false;
        }
    }

    // Read
    public Instituicao LoadInstituicao(int id) {
        // procurar o aluno com este id e retornar um objeto com TODOS OS DADOS.
        return instituicao.carregaInstituicao(id);
    }

    // Read
    public ArrayList getMinhaLista() {
        return instituicao.getMinhaLista();
    }

    public boolean Doar(String area, String descricao, int id, String nome, String endereco, String telefone, double doacao){
        Instituicao objeto = new Instituicao(area, descricao, id, nome, endereco, telefone, doacao);
        if (instituicao.Doar(objeto)) {
            return true;
        } else {
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {

        ArrayList<Instituicao> minhalista = instituicao.getMinhaLista();
        int tamanho = minhalista.size();

        String MatrizInstituicao[][] = new String[tamanho][7];
        for (int i = 0; i < tamanho; i++) {
            MatrizInstituicao[i][0] = minhalista.get(i).getId() + "";
            MatrizInstituicao[i][1] = minhalista.get(i).getNome();
            MatrizInstituicao[i][2] = minhalista.get(i).getEndereco();
            MatrizInstituicao[i][3] = minhalista.get(i).getTelefone();
            MatrizInstituicao[i][4] = minhalista.get(i).getArea();
            MatrizInstituicao[i][5] = minhalista.get(i).getDescricao();
            MatrizInstituicao[i][6] = minhalista.get(i).getDoacao() + "";
        }

        return MatrizInstituicao;
    }

}
