public class Cliente {
	
	private int ID;
	private String nome;
    private String dadosPessoais;
    private String endereco;
    
	public Cliente(int iD, String nome, String dadosPessoais, String endereco) {
		this.ID = iD;
		this.nome = nome;
		this.dadosPessoais = dadosPessoais;
		this.endereco = endereco;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(String dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [ID=" + ID + ", nome=" + nome + ", dadosPessoais=" + dadosPessoais + ", endereco=" + endereco
				+ "]";
	}   
}
