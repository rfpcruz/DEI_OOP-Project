
package examesdei;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Curso
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class Curso implements Serializable{
    
    /**
     * Atributos da Classe Curso
     */
    
    private String nome;
    private int duracao;
    private String grau;
    private ArrayList<Disciplina> disciplinas;
    
    /**
     * Construtor por omissão
     */
    public Curso(){}

    /**
     * Construtor da classe Curso
     * @param nome Nome do curso
     * @param duracao Duração do curso (em anos)
     * @param grau Grau do Curso (Licenciatura, Mestrado ou Doutoramento)
     * @param disciplinas Disciplinas do Curso
     */
    public Curso(String nome, int duracao, String grau, ArrayList<Disciplina> disciplinas) {
        this.nome = nome;
        this.duracao = duracao;
        this.grau = grau;
        this.disciplinas = disciplinas;
    }
    
    /**
     * Construtor da Classe Curso sem o atributo 'disciplinas'
     * @param nome Nome do Curso
     * @param duracao Duração do curso (em anos)
     * @param grau Grau do Curso (Licenciatura, Mestrado ou Doutoramento)
     */
    public Curso(String nome, int duracao, String grau) {
        this.nome = nome;
        this.duracao = duracao;
        this.grau = grau;
        
    }

    /**
     * Devolve o nome do curso
     * @return nome Nome do urso
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a duração do curso em anos
     * @return duracao Duração do curso (em anos)
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Devolve o grau do curso
     * @return grau
     */
    public String getGrau() {
        return grau;
    }

    /**
     * Devolve as disciplinas do curso
     * @return disciplinas
     */
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * Define o nome do Curso
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define a duracao do curso
     * @param duracao
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Define o grau do curso
     * @param grau
     */
    public void setGrau(String grau) {
        this.grau = grau;
    }

    /**
     * Define as diciplinas do curso
     * @param disciplinas
     */
    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Curso{" + "nome=" + nome + ", duracao=" + duracao + ", grau=" + grau + ", disciplinas=" + disciplinas + '}';
    }
    
    
        
}
