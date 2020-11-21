//package Control;
//
//import Model.Professor;
//import java.util.ArrayList;
//
//public class ProfessorControl {
//
//    private final Professor control;
//
//    public ProfessorControl() {
//        this.control = new Professor();
//    }
//
//    // Create 
//    public boolean Cadastrar(String nome, int idade, double salario, String materia) {
//
//        // AlunoControl recebe os dados da VIEW, cria um objeto COMPLETO e manda este objeto para aluno para inserir em MinhaLista(DAO)
//        // Aluno CONTROL NÃO DEVE ACESSAR DAO DIRETAMENTE. Lá em aluno deve ter uma função que acessa DAO para inserir. InsertAlunoBD()
//        
//        int id = control.maiorID() + 1;
//        
//        Professor objeto = new Professor(id, nome, idade, salario, materia);
//        if(control.InsertProfessorBD(objeto)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    
//    
//
//    // Update
//    public boolean Editar(String materia, double salario, int id, String nome, int idade) {
//        Professor objeto = new Professor(id, nome, idade, salario, materia) ;
//        if(control.UpdateProfessorBD(id, objeto)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    // Delete
//    public boolean Apagar(int id) {
//        if(control.DeleteProfessorBD(id)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    // Read
//    public Professor LoadProfessor(int id) {
//        // procurar o aluno com este id e retornar um objeto com TODOS OS DADOS.
//        return control.carregaProfessor(id);
//    }
//
//    // Read
//    public ArrayList getMinhaLista() {
//        return control.getMinhaLista();
//    }
//    
//    @SuppressWarnings("unchecked")
//    public String[][] getMinhaMatrizTexto() {
//        
//        ArrayList<Professor> minhalista = control.getMinhaLista();
//        int tamanho = minhalista.size();
//        
//        String MatrizProfessor[][] = new String[tamanho][5];
//        for (int i = 0; i < tamanho; i++) {
//            MatrizProfessor[i][0] = minhalista.get(i).getId() + "";
//            MatrizProfessor[i][1] = minhalista.get(i).getNome();
//            MatrizProfessor[i][2] = minhalista.get(i).getEndereco() + "";
//            MatrizProfessor[i][3] = minhalista.get(i).getMateria();
//            MatrizProfessor[i][4] = minhalista.get(i).getSalario() + "";
//        }        
//        
//        return MatrizProfessor;        
//    }
//    
//}
