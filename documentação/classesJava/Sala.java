
package examesdei;

import java.io.Serializable;

/**
 * Classe Sala
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class Sala implements Serializable{
    /**
     * Atributos da Classe Sala
     */
    private String nomeSala;
    private int lotacao;
    
    
    /**
     * Construtor por omissão
     */
    public Sala(){}

    
    /**
     * Contrutor da classe Sala
     * @param nomeSala
     * @param lotacao 
     */
    public Sala(String nomeSala, int lotacao) {
        this.nomeSala = nomeSala;
        this.lotacao = lotacao;
    }

    /**
     * Devolve a designção da sala
     * @return nomeSala
     */
    public String getNomeSala() {
        return nomeSala;
    }

    /**
     * Devolve a lotação da sala
     * @return lotacao
     */
    public int getLotacao() {
        return lotacao;
    }

    /**
     * define o nome/designcao da sala
     * @param nomeSala
     */
    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    /**
     * define a lotacao da sala
     * @param lotacao 
     */
    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    @Override
    public String toString() {
        //return "Sala{" + "nomeSala=" + nomeSala + ", lotacao=" + lotacao + '}';
        //return "Sala: " + nomeSala + "\t" + "Lotacao: " + lotacao;
        return nomeSala;
        
        
    }

    
}
