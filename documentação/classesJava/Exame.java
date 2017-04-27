
package examesdei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Classe exame
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class Exame implements Serializable {
     /**
     * Atributos da Classe Exame
     */
    private Disciplina disciplina;
    private String epoca;
    private Date dataHora;
    private int duracao;
    private ArrayList<Sala> sala;
    private Docente docenteResponsavel;
    private ArrayList<Docente> vigilantes;
    private ArrayList<NaoDocente> funcionarios;
    private HashMap<Aluno, Double> alunosInscritosExame;
    
    /**
     * Construtor por omissão
     */
    public Exame(){}

    /**
     * Construtor da Classe Exame
     * @param disciplina Disciplina do exame
     * @param epoca Época do Exame: Normal, Recurso ou Especial
     * @param dataHora Data e hora do exame: em formato  yyyy-MM-dd HH:mm
     * @param duracao Duração do exame em minutos (minímo 60 minutos e máximo  180 minutos)
     * @param sala Salas onde decorrerá o exame
     * @param docenteResponsavel Regente da cadeira; é obrigatório a sua presença no exame
     * @param vigilantes Docentes que fazem a vigilància do exame (inclui os Docentes da disciplina)
     * @param funcionarios Funcionários escalados para apoio ao exame
     * @param alunosInscritosExame Alunos inscritos no exame e respecitvas notas
     */
    public Exame(Disciplina disciplina, String epoca, Date dataHora, int duracao, ArrayList<Sala> sala, Docente docenteResponsavel, ArrayList<Docente> vigilantes, ArrayList<NaoDocente> funcionarios, HashMap<Aluno, Double> alunosInscritosExame) {
        this.disciplina = disciplina;
        this.epoca = epoca;
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.sala = sala;
        this.docenteResponsavel = docenteResponsavel;
        this.vigilantes = vigilantes;
        this.funcionarios = funcionarios;
        this.alunosInscritosExame = alunosInscritosExame;
    }
    
    /**
     * Construtor da clase exame - utilizado na opção 1
     * @param disciplina
     * @param epoca
     * @param dataHora
     * @param duracao
     * @param docenteResponsavel
     * @param vigilantes
     */
    public Exame(Disciplina disciplina, String epoca, Date dataHora, int duracao, Docente docenteResponsavel, ArrayList<Docente> vigilantes) {
        this.disciplina = disciplina;
        this.epoca = epoca;
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.docenteResponsavel = docenteResponsavel;
        this.vigilantes = vigilantes;
    }    
    

    /**
     * Devolve a disciplina do exame
     * @return disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * Devolve a época do exame
     * @return epoca
     */
    public String getEpoca() {
        return epoca;
    }

    /**
     * Deveolve a data e hora do exame
     * @return dataHora
     */
    public Date getDataHora() {
        return dataHora;
    }

    /**
     * Devolve a duração do exame
     * @return duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Devolve a lista das salas reservadas para o exame
     * @return sala
     */
    public ArrayList<Sala> getSala() {
        return sala;
    }

    /**
     * Devolve o docuente responsável pelo Exame
     * @return docenteResponsavel
     */
    public Docente getDocenteResponsavel() {
        return docenteResponsavel;
    }

    /**
     * Devolve os docentes responsáveis pela vigilância do exame
     * @return vigilantes
     */
    public ArrayList<Docente> getVigilantes() {
        return vigilantes;
    }

    /**
     * Devolve a lista dos funcionários escalados para o exame
     * @return funcionarios
     */
    public ArrayList<NaoDocente> getFuncionarios() {
        return funcionarios;
    }

    /**
     * Devolve a lista de alunos inscritos no exame e respectivas notas
     * @return alunosInscritosExame
     */
    public HashMap<Aluno, Double> getAlunosInscritosExame() {
        return alunosInscritosExame;
    }

    /**
     * Define a disciplina do exame
     * @param disciplina
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * Define a época do exame
     * @param epoca
     */
    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    /**
     * Define a data e hora do exame
     * @param dataHora
     */
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Define a duração do exame em minutos
     * @param duracao
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Define a(s) sala(s) do exame
     * @param sala
     */
    public void setSala(ArrayList<Sala> sala) {
        this.sala = sala;
    }

    /**
     * Define o docente responsável pelo exame
     * @param docenteResponsavel
     */
    public void setDocenteResponsavel(Docente docenteResponsavel) {
        this.docenteResponsavel = docenteResponsavel;
    }

    /**
     * Define a lista de docentes vigilantes
     * @param vigilantes
     */
    public void setVigilantes(ArrayList<Docente> vigilantes) {
        this.vigilantes = vigilantes;
    }

    /**
     * Define a lista de funcionários escalados para o exame
     * @param funcionarios
     */
    public void setFuncionarios(ArrayList<NaoDocente> funcionarios) {
        this.funcionarios = funcionarios;
    }

    /**
     * Define a lista de alunos inscritos no exame e respectvas nota
     * @param alunosInscritosExame
     */
    public void setAlunosInscritosExame(HashMap<Aluno, Double> alunosInscritosExame) {
        this.alunosInscritosExame = alunosInscritosExame;
    }

    @Override
    public String toString() {
        return "Exame{" + "disciplina=" + disciplina + ", epoca=" + epoca + ", dataHora=" + dataHora + ", duracao=" + duracao + ", sala=" + sala + ", docenteResponsavel=" + docenteResponsavel + ", vigilantes=" + vigilantes + ", funcionarios=" + funcionarios + ", alunosInscritosExame=" + alunosInscritosExame + '}';
    }
    
   
    
}
