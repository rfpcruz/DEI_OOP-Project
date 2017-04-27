
package examesdei;

import java.io.Serializable;

/**
 * Classe Docente
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class Docente extends Funcionario implements Serializable {
    
    /**
     * Atributos da Classe Docente
     */
    private String areaInvestigacao;
    

    /**
     * 
     * Construtor por omissão
     */
    public Docente(){}

    /**
     * Construtor da Classe Docente
     * @param areaInvestigacao Área de Investigação do Docente (Sistemas de Informação, Comunicação e Telemática ou Engenharia de Software)
     * @param numeroMecnografico N.º Mecanográfio do Docente
     * @param categoria Categoria do Docente (Prof Assistente, Prof Auxiliar, Prof Associado ou Prof Catedrático)
     * @param nome Nome do Docente
     * @param email Endereço de email do Docente
     */
    public Docente(String nome, String email, int numeroMecnografico, String categoria, String areaInvestigacao) {
        super(nome, email, numeroMecnografico, categoria);
        this.areaInvestigacao = areaInvestigacao;
    }

    /**
     * Define a área de investigação do docente (sistemas de informação, comunicação e
telemática, engenharia de software)
     * @param areaInvestigacao Área de Investigação do Docente (Sistemas de Informação, Comunicação e Telemática ou Engenharia de Software)
     */
    public void setAreaInvestigacao(String areaInvestigacao) {
        this.areaInvestigacao = areaInvestigacao;
    }

    /**
     * Devolve a área de investigação de um docente
     * @return areaInvestigacao
     */
    public String getAreaInvestigacao() {
        return areaInvestigacao;
    }

    @Override
    public String toString() {
        return "Nº Mec: " + numeroMecnografico + "\t" + "Área de Investigação: " + areaInvestigacao + "\t" + "Email: " + email + "\t" + "Nome: " + nome;
    }
    
    
}
