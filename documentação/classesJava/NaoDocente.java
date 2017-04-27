
package examesdei;

import java.io.Serializable;

/**
 * Classe NaoDocente
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class NaoDocente extends Funcionario implements Serializable {
    
    /**
     * Atributos da Classe NaoDocente
     */
    private String cargo;
    
    /**
     * Construtor por omissão
     */
    public NaoDocente(){}

    /**
     * Construtor da Classe NaoDocente
     * @param cargo Cargo do Funcionário Não Docente (secretaria, financeiro, apoio técnico)
     * @param nome Nome do Funcionário Não Docente
     * @param email Endereço de email do Funcionário Não Docente
     * @param numeroMecnografico Nº Mecanográfico do Funcionário Nnão Docente
     * @param categoria Categoria do Funccionário Não Docente (ssistente operacional, assistente técnico, técnico superior,
técnico de informática ou especialista de informática)
     */
    public NaoDocente(String nome, String email, int numeroMecnografico, String categoria, String cargo) {
        super(nome, email, numeroMecnografico, categoria);
        this.cargo = cargo;
        
    }


    /**
     * Devolve o cargo do funcionário
     * @return cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Define o cargo do funcionário
     * @param cargo Cargo do Funcionário Não Docente (secretaria, financeiro, apoio técnico)
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
     return  "Nº Mec: " + numeroMecnografico  +"\t" + "Cargo: " + cargo + "\t" + "E-mail: " + email + "\t"   + "Nome: " +  nome;
     
   
    }
    
    
    
}
