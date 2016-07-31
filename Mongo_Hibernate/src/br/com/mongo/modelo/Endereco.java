package br.com.mongo.modelo;

public class Endereco {

	private String rua;
	private String cidade;
	private String cep;

	public Endereco(){
		
	}
	
	public Endereco(String rua, String cidade, String cep) {
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Override
	public String toString() {
		return "Endereco {" +
				"rua=" + rua + '\'' +
				", cidade=" + cidade + '\'' + 
				", cep=" + cep + "}";
	}
	
	

}
