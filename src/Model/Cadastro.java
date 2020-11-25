package Model;

public abstract class Cadastro {

    // Atributos
    private int id;
    private String nome;
    private String senha;
    private String endereco;
    private String telefone;

    // Metodo Construtor de Objeto Vazio
    public Cadastro() {
    }

    // Metodo Construtor de Objeto, inserindo dados
    public Cadastro(int id, String nome, String senha, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Metodos GET e SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
