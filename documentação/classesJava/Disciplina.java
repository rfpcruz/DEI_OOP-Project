
package examesdei;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Disciplina
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class Disciplina implements Serializable{
    
    /**
     * Atributos da Classe Disciplina
     */
    private String nome;
    private Docente docente;
    private ArrayList<Docente> outrosDocentes;
    private ArrayList<Aluno> alunosInscritosDisciplina;
    
    /**
     * Construtor por omissão
     */
    public Disciplina(){}

    /**
     * Construtor da Classe Disciplina
     * @param nome
     * @param docente
     * @param outrosDocentes
     * @param alunosInscritosDisciplina
     */
    public Disciplina(String nome, Docente docente, ArrayList<Docente> outrosDocentes, ArrayList<Aluno> alunosInscritosDisciplina) {
        this.nome = nome;
        this.docente = docente;
        this.outrosDocentes = outrosDocentes;
        this.alunosInscritosDisciplina = alunosInscritosDisciplina;
    }

    
    /**
     * Construtor da Classe Disciplina apenas com o atributo nome
     * @param nome
     */
    public Disciplina (String nome) {
        this.nome = nome;
    }
    
    
    
    /**
     * Devolve o nome da disciplina
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o docente responsável pela disciplina
     * @return docente
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * Devolve o(s) outro(s) docente(s) responsáveis pela cadeira
     * @return outrosDocentes
     */
    public ArrayList<Docente> getOutrosDocentes() {
        return outrosDocentes;
    }

    /**
     * Devolve os alunos inscritos na disciplina
     * @return alunosInscritosDisciplina
     */
    public ArrayList<Aluno> getAlunosInscritosDisciplina() {
        return alunosInscritosDisciplina;
    }

    /**
     * Define nome da disciplina
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o docente responsável pela cadeira (Regente)
     * @param docente
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    /**
     * Define o(s) outro(s) docente(s) responsáveis pela cadeira
     * @param outrosDocentes
     */
    public void setOutrosDocentes(ArrayList<Docente> outrosDocentes) {
        this.outrosDocentes = outrosDocentes;
    }

    /**
     * Define os alunos que estão inscritos na disciplina
     * @param alunosInscritosDisciplina
     */
    public void setAlunosInscritosDisciplina(ArrayList<Aluno> alunosInscritosDisciplina) {
        this.alunosInscritosDisciplina = alunosInscritosDisciplina;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + "\t" + "Docente: " + docente + "\t" + "Outros Docentes: " + outrosDocentes + "\t" + "Alunos Inscritos Disciplina: " + alunosInscritosDisciplina;
    }
    
}
