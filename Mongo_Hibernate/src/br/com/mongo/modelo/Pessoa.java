package br.com.mongo.modelo;

//http://www.mballem.com/post/nosql-com-mongodb-e-persistencia-em-java/
	

public class Pessoa {
	private String id;
	private String nome;
	private int idade;
	private Endereco end;

	public Pessoa(){
		
	}
	
	public Pessoa(String id, String nome, int idade, Endereco end) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.end = end;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa {id='" + id + '\''+ 
				", nome='" + nome + '\''+ 
				", idade='" + idade + '\''+ 
				", Endereco=" + end + "}";
	}
	
	

}
