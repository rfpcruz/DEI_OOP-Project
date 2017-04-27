
package examesdei;

import java.io.Serializable;

/**
 * Classe aluno
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class Aluno extends Pessoa {
    /**
     * Atributos da Classe Aluno
     */
    private int numeroAluno;
    private Curso curso;
    private int anoMatriculaCurso;
    private String regime;
    
    
    /**
     * Construtor por omissão
     */
    public Aluno(){}

    /**
     * Construtor da Classe Aluno
     * @param nome Nome do aluno
     * @param email endereço de email do aluno
     * @param numeroAluno Número de aluno
     * @param curso Curso a que pertence o aluno
     * @param anoMatriculaCurso - Ano de matrícula no curso
     * @param regime Regime de inscrição: normal, trabalhador-estudante, atleta, dirigente associativo ou finalista
     */
    public Aluno(String nome, String email, int numeroAluno, Curso curso, int anoMatriculaCurso, String regime) {
        super(nome,email);
        this.numeroAluno = numeroAluno;
        this.curso = curso;
        this.anoMatriculaCurso = anoMatriculaCurso;
        this.regime = regime;
    }

    
    /**
     * Construtor da Classe Aluno - sem atributo curso
     * @param nome Nome do aluno
     * @param email endereço de email do aluno
     * @param numeroAluno Número de aluno
     * @param anoMatriculaCurso Ano de matrícula no curso
     * @param regime Regime de inscrição: normal, trabalhador-estudante, atleta, dirigente associativo ou finalista
     */
    public Aluno(String nome, String email, int numeroAluno, int anoMatriculaCurso, String regime) {
        super(nome,email);
        this.numeroAluno = numeroAluno;
        this.anoMatriculaCurso = anoMatriculaCurso;
        this.regime = regime;
    }
    
    /**
     * Devolve o número de aluno
     * @return numeroAluno  Número de aluno
     */
    public int getNumeroAluno() {
        return numeroAluno;
    }

    /**
     * Devolve o curso
     * @return curso Curso em que o aluno está inscrito
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * Devolve o ano de matricula no curso (1, 2, 3 ....)
     * @return anoMatriculaCurso Ano de matrícula no curso
     */
    public int getAnoMatriculaCurso() {
        return anoMatriculaCurso;
    }

    /**
     * Devolve o regime (normal, trabalhador-estudante, atletas,
dirigentes associativos ou finalistas)
     * @return regime Regime de inscrição
     */
    public String getRegime() {
        return regime;
    }

    /**
     * Define o número de aluno
     * @param numeroAluno Número de Aluno
     */
    public void setNumeroAluno(int numeroAluno) {
        this.numeroAluno = numeroAluno;
    }

    /**
     * Define o curso
     * @param curso Curso em que o aluno está inscrito
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * Define o ano de matrícula no curso (1, 2, 3, ...)
     * @param anoMatriculaCurso Ano de matrícula no curso
     */
    public void setAnoMatriculaCurso(int anoMatriculaCurso) {
        this.anoMatriculaCurso = anoMatriculaCurso;
    }

    /**
     * Define o regime (normal, trabalhador-estudante, atletas,
dirigentes associativos ou finalistas)
     * @param regime Regime de inscrição
     */
    public void setRegime(String regime) {
        this.regime = regime;
    }

    @Override
    public String toString() {
        return "Nº" + numeroAluno + "\t" + "Curso: " + curso.getNome() + "\t" +  "Ano Matricula:" + anoMatriculaCurso + "\t" + "Regime:" + regime + "\t" + "Nome:" + nome ;
    }
    
    /**
     * Método 'fantasma' por causa da class abstracta
     * @return 
     */
    @Override
    public String getCategoria(){
        return "";
    }
   
       
}
