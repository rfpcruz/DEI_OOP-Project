
package examesdei;

import java.io.Serializable;

/**
 * Classe abstacta Pessoa
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public abstract class Pessoa implements Serializable{
    /**
     * Atributo da Classe Pessoa (nome)
     */
    protected String nome;

    /**
     * Atributo da Classe Pessoa (endereço de e-mail)
     */
    protected String email;
    
    /**
     * Construtor por omissão
     */
    public Pessoa(){}

     /**
     * Contrutor da classe Pessoa
     * @param nome
     * @param email 
     */
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    /**
     * Retorna o nome da Pessoa
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o e-mail da pessoa
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o nome da pessoa
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o email da pessoa
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", email=" + email + '}';
    }
    
    /**
     * Método abstracto
     * @return 
     */
    public abstract String getCategoria();
     
    
}
