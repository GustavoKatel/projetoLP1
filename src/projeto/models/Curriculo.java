package projeto.models;

import java.util.ArrayList;

//Classe de dados para manipulação de Currículo
public class Curriculo {
	
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private int cpf;
	private int reg_profissional;
	private ArrayList<Titulo> titulos;
	
	//Construtor da classe Currículo.
	public Curriculo(String nome, String endereco, String telefone,
			String email, int cpf, int reg_profissional) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.reg_profissional = reg_profissional;
		this.titulos = new ArrayList<Titulo>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getReg_profissional() {
		return reg_profissional;
	}
	public void setReg_profissional(int reg_profissional) {
		this.reg_profissional = reg_profissional;
	}
	public ArrayList<Titulo> getTitulos(){
		return titulos;		
	}
	
	public void addTitulo(Titulo titulo) {
		if (titulos != null){
			titulos.add(titulo);
		}
	}
}
