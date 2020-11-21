//package Model;
//
//import DAO.DoadorDAO;
//import java.util.ArrayList;
//
//import DAO.ProfessorDAO;
//
//public class Professor extends Cadastro {
//	// Atributos
//	private double salario;
//	private String materia; // Especialista, Mestre, Doutor, etc
//
//	// Método Construtor de Objeto Vazio
//	public Professor() {
//	}
//
//	// Método Construtor de Objeto, inserindo dados
//	public Professor(double salario, String materia) {
//		this.salario = salario;
//		this.materia = materia;
//	}
//
//	public Professor(int id, String nome, int idade, double salario, String materia) {
//		super(id, nome, idade);
//		this.salario = salario;
//		this.materia = materia;
//	}
//
//	// Métodos GET e SET
//	public double getSalario() {
//		return salario;
//	}
//
//	public void setSalario(double salario) {
//		this.salario = salario;
//	}
//
//	public String getMateria() {
//		return materia;
//	}
//
//	public void setMateria(String titulo) {
//		this.materia = titulo;
//	}
//
//	@Override
//	public String toString() {
//		return "\n ID: " + this.getId() + "\n Nome: " + this.getNome() + "\n Idade: " + this.getEndereco() + "\n salário: "
//				+ this.getSalario() + "\n Materia:" + this.getMateria() + "\n -----------";
//	}
//
//	/* métodos para uso juntos com o DAO */
//
//	// Retorna a Lista de Professor(objetos)
//	public ArrayList getMinhaLista() {
//		return ProfessorDAO.MinhaLista;
//	}
//
//	// Cadastra novo professor
//	public boolean InsertProfessorBD(Professor objeto) {
//		ProfessorDAO.MinhaLista.add(objeto);
//		return true;
//	}
//
//	// Deleta um professor específico pelo seu campo ID
//	public boolean DeleteProfessorBD(int id) {
//		int indice = this.procuraIndice(id);
//		ProfessorDAO.MinhaLista.remove(indice);
//		return true;
//	}
//
//	// Procura um professor específico
//	public boolean VerificaProfessorBD(String objeto) {
//		ProfessorDAO.MinhaLista.contains(objeto);
//		return true;
//	}
//
//	// Edita um professor específico pelo seu campo ID
//	public boolean UpdateProfessorBD(int id, Professor objeto) {
//		int indice = this.procuraIndice(id);
//		ProfessorDAO.MinhaLista.set(indice, objeto);
//		return true;
//	}
//
//	// procura o ÍNDICE de objeto da MinhaLista que contem o ID enviado.
//	private int procuraIndice(int id) {
//		int indice = -1;
//		for (int i = 0; i < ProfessorDAO.MinhaLista.size(); i++) {
//			if (ProfessorDAO.MinhaLista.get(i).getId() == id) {
//				indice = i;
//			}
//		}
//		return indice;
//	}
//        
//        // carrega dados de um aluno específico pelo seu ID
//    public Professor carregaProfessor(int id) {
//        int indice = this.procuraIndice(id);
//        return ProfessorDAO.MinhaLista.get(indice);
//    }
//    
//    // retorna o maior ID da nossa base de dados
//    public int maiorID(){
//        return ProfessorDAO.maiorID();
//    }   
//}
