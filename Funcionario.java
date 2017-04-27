
package examesdei;

import java.io.Serializable;

/**
 * Classe Funcionário
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class Funcionario extends Pessoa implements Serializable {
    
    /**
     * Atributo da Classe Funcionário
     */
    protected int numeroMecnografico;

    /**
     * Atributo da Classe Funcionário
     */
    protected String categoria;
    
    /**
     * Construtor por omissão
     */
    public Funcionario(){}

    /**
     * Construtor da Classe Funcionário
     * @param nome Nome do funcionário
     * @param email Endereço de e-mail do funcionário
     * @param numeroMecnografico Nº Mecanográfico do funcionário
     * @param categoria Categoria do Funcionário
     */
    public Funcionario(String nome,  String email, int numeroMecnografico, String categoria) {
        super(nome, email);
        this.numeroMecnografico = numeroMecnografico;
        this.categoria = categoria;
    }

    /**
     * Devolve o número mecanográfico do funcionário
     * @return numeroMecnografico
     */
    public int getNumeroMecnografico() {
        return numeroMecnografico;
    }

    /**
     * Devolve a categoria do funcionário
     * @return categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define o número mecanográfico do funcionário
     * @param numeroMecnografico Nº Mecanográfico do funcionário
     */
    public void setNumeroMecnografico(int numeroMecnografico) {
        this.numeroMecnografico = numeroMecnografico;
    }

    /**
     * Define a categoria do funcionário
     * @param categoria Categoria do Funcionário
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "numeroMecnografico=" + numeroMecnografico + ", categoria=" + categoria + '}';
    }
    
}
