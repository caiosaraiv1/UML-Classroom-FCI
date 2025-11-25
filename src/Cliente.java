public class Cliente {
    
    private int ID;
    private String nome;
    private String email;
    private String endereco;
    
    // Construtor que chama os métodos de ajuste para garantir que as regras sejam aplicadas
    public Cliente(int iD, String nome, String email, String endereco) {
        this.ID = iD;
        //setters para validar na criação
        setNome(nome);
        setEmail(email);
        setEndereco(endereco);
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    public String getNome() {
        return nome;
    }

    // setter com validação
    public void setNome(String nome) {
		//nome não pode ser nulo ou vazio
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inválido: não pode ser vazio.");
		}
		this.nome = nome.trim(); //Remover espaços em branco
	}

    public String getEmail() {
        return email;
    }

    //setter com Validação
    public void setEmail(String email) {
        //Validação de E-mail
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        if (email == null || !email.matches(emailRegex)) {
            throw new IllegalArgumentException("Formato de E-mail inválido.");
        }
        this.email = email.toLowerCase(); //Armazena as letrss em minúsculas
    }

    public String getEndereco() {
        return endereco;
    }

    // setter com Validação
    public void setEndereco(String endereco) {
        //Condição para o endereço não pode ser nulo ou vazio
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço inválido: não pode ser vazio.");
        }
        this.endereco = endereco.trim(); //Remove espaços
    }

    @Override
    public String toString() {
        return "Cliente [ID=" + ID + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco
                + "]";
    }   
}