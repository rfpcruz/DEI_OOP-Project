
package examesdei;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Classe apenas para criar a Base de dados inicial
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class CriadorBd {
    
    /**
     * Método que cria a Base de Dados inicial da aplicação
     * @throws java.text.ParseException
     */
    public static void BaseDeDados() throws ParseException {
        
        
    //cria o arrayList de Funcionários (Docentes e Não Docentes)
    
    ArrayList <Funcionario> arrayFuncionarios = new ArrayList <Funcionario>();
    
    //adicionar naoDocentes   
    arrayFuncionarios.add(new NaoDocente("ADAMASIO DANILO CORREA PERFETTI","adc@dei.uc.pt",20001,"Assistente Operacional","Secretaria"));
    arrayFuncionarios.add(new NaoDocente("ADELINO GOMES DA SILVA","ags@dei.uc.pt",20002,"Assistente Técnico","Financeiro"));
    arrayFuncionarios.add(new NaoDocente("AFONSO MANUEL CARVALHO MARQUES","amcm@dei.uc.pt",20003,"Técnico Superior","Financeiro"));
    arrayFuncionarios.add(new NaoDocente("AGOSTINHO MANUEL TEIXEIRA","amt@dei.uc.pt",20004,"Assistente Operacional","Secretaria"));
    arrayFuncionarios.add(new NaoDocente("ANA MARIA GONÇALVES DA MOTA","amgm@dei.uc.pt",20005,"Técnico Superior","Secretaria"));
    arrayFuncionarios.add(new NaoDocente("ANA PAULA TOMAS GARCIA","aptg@dei.uc.pt",20006,"Técnico de Informática","Apoio Técnico"));
    arrayFuncionarios.add(new NaoDocente("ANABELA DOS SANTOS MELO MARQUES","asmm@dei.uc.pt",20007,"Assistente Operacional","Financeiro"));
    arrayFuncionarios.add(new NaoDocente("FERNANDO PEDRO RIBEIRO FELIX","fprf@dei.uc.pt",20008,"Especialista de Informática","Apoio Técnico"));
    arrayFuncionarios.add(new NaoDocente("FIRMINO MARQUES DA SILVA","fms@dei.uc.pt",20009,"Assistente Operacional","Financeiro"));
    arrayFuncionarios.add(new NaoDocente("FRANCISCO DEMBEL BALDE","fdmb@dei.uc.pt",20010,"Assistente Técnico","Apoio Técnico"));
    arrayFuncionarios.add(new NaoDocente("OLGA MARIA MIRANDA BARARDO","ommba@dei.uc.pt",20011,"Técnico Superior","Financeiro"));
    arrayFuncionarios.add(new NaoDocente("SANDRA ISABEL BENTO VIEGAS CASCARRINHA","sibvc@dei.uc.pt",20012,"Técnico de Informática","Apoio Técnico"));
    arrayFuncionarios.add(new NaoDocente("SERGIO GUILHERME MENDES","sgm@dei.uc.pt",20013,"Assistente Operacional","Financeiro"));
    arrayFuncionarios.add(new NaoDocente("SERGIO FILIPE GOMES SOARES","sffs@dei.uc.pt",20014,"Assistente Técnico","Apoio Técnico"));
    arrayFuncionarios.add(new NaoDocente("SERGIO FRANCISCO CANILHAS ","sfc@dei.uc.pt",20015,"Especialista de Informática","Apoio Técnico"));

    //adicionar Docentes
    arrayFuncionarios.add(new Docente("MARILIA CURADO", "mar@dei.uc.pt", 10001, "Professor Associado", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("FERNANDO BARROS", "fb@dei.uc.pt", 10002, "Professor Associado", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("LUIS CORDEIRO", "lcord@dei.uc.pt", 10003, "Professor Associado", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("NUNO PIMENTA", "np@dei.uc.pt", 10004, "Professor Associado", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("ANA PAULA DA GLORIA ANTONIO SINTRA", "apdgas@dei.uc.pt", 10005, "Professor Auxiliar", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("RAQUEL ANA AMARO DA CRUZ", "aradc@dei.uc.pt", 10006, "Professor Associado", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("ANA RITA COUTO DA SILVA MAIA", "arcdsm@dei.uc.pt", 10007, "Professor Associado", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("ANA SOFIA MENDES FERREIRA", "asmf@dei.uc.pt", 10008, "Professor Auxiliar", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("ANABELA BARREIROS DE OLIVEIRA", "abdo@dei.uc.pt", 10009, "Professor Associado", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("ANABELA NASCIMENTO JACINTO PAULINO", "anjc@dei.uc.pt", 10010, "Professor Associado", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("ANGELINA DE JESUS DE SOUSA MOISÃO", "adsm11@dei.uc.pt", 10011, "Professor Auxiliar", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("ANIBAL JOÃO CARDOSO CORREIA", "ajcc@dei.uc.pt", 10012, "Professor Associado", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("PEDRO ANSELMO MARIANO RODRIGUES", "amr@dei.uc.pt", 10013, "Professor Associado", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("ANTERO FERNANDO DA SILVEIRA", "afds@dei.uc.pt", 10014, "Professor Auxiliar", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("ANTONIA DA PIEDADE PIRES LEITÃO", "adppl@dei.uc.pt", 10015, "Professor Assistente", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("ANTONINO TEODORE BARTUCCIO", "atn@dei.uc.pt", 10016, "Professor Auxiliar", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("ANTONIO AGOSTINHO DA SILVA ABREU", "aadsa@dei.uc.pt", 10017, "Professor Associado", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("LIBERTINO DE OLIVEIRA SECO", "ldos@dei.uc.pt", 10018, "Professor Associado", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("LIBORIO SEIXAL DA SILVA NUNES", "lsdsn@dei.uc.pt", 10019, "Professor Associado", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("LICINIO RIBEIRO CAROCHA", "lcr@dei.uc.pt", 10020, "Professor Assistente", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("LILIANA MARIA LENTES DA PALMA", "lmldp@dei.uc.pt", 10021, "Professor Assistente", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("CRISTIANA SOFIA REIS MINHOTO", "lsrm@dei.uc.pt", 10022, "Professor Catedrático", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("LIN ZEFA", "lz@dei.uc.pt", 10023, "Professor Auxiliar", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("LINO DE SA FERREIRA", "ldsf@dei.uc.pt", 10024, "Professor Associado", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("LUCIO SILVA DA COSTA", "lsdc@dei.uc.pt", 10025, "Professor Auxiliar", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("SERGIO AFONSO VIEIRA DA COSTA", "lavdc@dei.uc.pt", 10026, "Professor Assistente", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("LUIS ALBERTO FERNANDES CABRITA", "lafc@dei.uc.pt", 10027, "Professor Associado", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("PEDRO ALEXANDRE ALVES QUELHAS", "laaq@dei.uc.pt", 10028, "Professor Assistente", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("MANUEL FRANCISCO BATISTA PRAZERES", "mfbp@dei.uc.pt", 10029, "Professor Assistente", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("MARIA INES SIMÕES DOS SANTOS", "misds@dei.uc.pt", 10030, "Professor Auxiliar", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("MIGUEL SAMUEL KHOMDE PAIS", "mskp@dei.uc.pt", 10031, "Professor Catedrático", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("REINALDO RAMOS DE AZEVEDO", "rrda@dei.uc.pt", 10032, "Professor Auxiliar", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("RUI JOÃO DOS SANTOS TOMAS", "rjdst@dei.uc.pt", 10033, "Professor Associado", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("VERA LISA PEREIRA ROQUE MAIA", "vlprq@dei.uc.pt", 10034, "Professor Auxiliar", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("VITOR MANUEL GONÇALVES PAIVA", "vmgp@dei.uc.pt", 10035, "Professor Catedrático", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("ANA ISABEL MONTEZ PESEIRO SERRÃO", "aimps@dei.uc.pt", 10036, "Professor Assistente", "Sistemas de Informação"));
    arrayFuncionarios.add(new Docente("ANA LUCIA NUNES MONTEIRO BRANDÃO", "alnmb@dei.uc.pt", 10037, "Professor Auxiliar", "Comunicação e Telemática"));
    arrayFuncionarios.add(new Docente("ANA MARGARIDA FERREIRA MARTINS FRANCO LOPES", "amfmfl@dei.uc.pt", 10038, "Professor Catedrático", "Engenharia de Software"));
    arrayFuncionarios.add(new Docente("MARIA DE SOUSA LOPES RODRIGUES", "amdslr@dei.uc.pt", 10039, "Professor Associado", "Comunicação e Telemática"));
 
        
    
    // Cria arrayList de Cursos (ainda sem discilinas)
    ArrayList <Curso> arrayCursos = new ArrayList <Curso>();
    arrayCursos.add(new Curso("Licenciatura em Engenharia Informatica", 3, "Licenciatura"));
    arrayCursos.add(new Curso("Licenciatura em Design e Multimédia", 3, "Licenciatura"));
    arrayCursos.add(new Curso("Mestrado em Engenharia Informática", 2, "Mestrado"));
    arrayCursos.add(new Curso("Mestrado em Design e Multimédia", 2, "Mestrado"));
    arrayCursos.add(new Curso("Doutoramento em Ciências e Tecnologias da Informação", 3, "Doutoramento"));
    
    
    
    //Cria arrayList de Alunos
    
    ArrayList <Aluno> arrayAlunos = new ArrayList <Aluno>();
    arrayAlunos.add(new Aluno ("ADELAIDE DA CONCEIÇÃO MIRANDA ABREU FERNANDES", "30001@student.dei.uc.pt", 30001,arrayCursos.get(0),1, "Normal"));
    arrayAlunos.add(new Aluno ("ADELINA MARIA DA LUZ COUTINHO MATIAS", "30002@student.dei.uc.pt", 30002,arrayCursos.get(1),1, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("ADELINO LAPA MATIAS CADETE", "30003@student.dei.uc.pt", 30003,arrayCursos.get(2),2, "Dirigente Associativo"));
    arrayAlunos.add(new Aluno ("ADELIO ANTONIO DA SILVA PINTO", "30004@student.dei.uc.pt", 30004,arrayCursos.get(3),1, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("ADELIO GOMES FERREIRA DO CABO", "30005@student.dei.uc.pt", 30005,arrayCursos.get(4),4, "Normal"));
    arrayAlunos.add(new Aluno ("ADERITO MANUEL DIAS MACIEL", "30006@student.dei.uc.pt", 30006,arrayCursos.get(1),2, "Normal"));
    arrayAlunos.add(new Aluno ("AFONSO FERNANDO DE MATOS NEVES", "30007@student.dei.uc.pt", 30007,arrayCursos.get(1),1, "Normal"));
    arrayAlunos.add(new Aluno ("AIRES LOURO HORTA", "30008@student.dei.uc.pt", 30008,arrayCursos.get(1),3, "Normal"));
    arrayAlunos.add(new Aluno ("ANA FRANCISCA CARRILHO LEITÃO", "30009@student.dei.uc.pt", 30009,arrayCursos.get(2),1, "Normal"));
    arrayAlunos.add(new Aluno ("ANA GENTIL FILIPE DE OLIVEIRA", "30010@student.dei.uc.pt", 30010,arrayCursos.get(0),2, "Atleta"));
    arrayAlunos.add(new Aluno ("CARLOS ALBERTO CHAVES DA SILVA", "30011@student.dei.uc.pt", 30011,arrayCursos.get(2),1, "Normal"));
    arrayAlunos.add(new Aluno ("DALIA MARIA SEVERINO SIMENTA", "30012@student.dei.uc.pt", 30012,arrayCursos.get(0),3, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("DANIEL ABRAHAM GOLDRAJCH", "30013@student.dei.uc.pt", 30013,arrayCursos.get(0),2, "Normal"));
    arrayAlunos.add(new Aluno ("ELISA DO CARMO SANTOS DA ESTRELA GARÇÃO", "30014@student.dei.uc.pt", 30014,arrayCursos.get(1),1, "Dirigente Associativo"));
    arrayAlunos.add(new Aluno ("ELISABETE MARQUES GONÇALVES", "30015@student.dei.uc.pt", 30015,arrayCursos.get(1),2, "Normal"));
    arrayAlunos.add(new Aluno ("ELISABETH ANTONIA  KERTENS VAN OVERVELD", "30016@student.dei.uc.pt", 30016,arrayCursos.get(2),2, "Erasmus"));
    arrayAlunos.add(new Aluno ("ELISEU ANTONIO GUERREIRO VALENTE", "30017@student.dei.uc.pt", 30017,arrayCursos.get(2),2, "Normal"));
    arrayAlunos.add(new Aluno ("ISABEL CRISTINA DE OLIVEIRA TEIXEIRA HENRIQUES", "30018@student.dei.uc.pt", 30018,arrayCursos.get(0),3, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("JOAQUINA MARQUES DA SILVA", "30019@student.dei.uc.pt", 30019,arrayCursos.get(2),1, "Normal"));
    arrayAlunos.add(new Aluno ("JOEL CASTANHEIRA SOUSA", "30020@student.dei.uc.pt", 30020,arrayCursos.get(3),2, "Normal"));
    arrayAlunos.add(new Aluno ("GEORGE REX CRYSTAL", "30021@student.dei.uc.pt", 30021,arrayCursos.get(0),3, "Erasmus"));
    arrayAlunos.add(new Aluno ("GERALDINE DUFFY", "30022@student.dei.uc.pt", 30022,arrayCursos.get(3),2, "Normal"));
    arrayAlunos.add(new Aluno ("GERALDO FILIPE PIRES", "30023@student.dei.uc.pt", 30023,arrayCursos.get(0),3, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("GRIGOR OROS", "30024@student.dei.uc.pt", 30024,arrayCursos.get(3),1, "Erasmus"));
    arrayAlunos.add(new Aluno ("GUIDO HANS SPEEN", "30025@student.dei.uc.pt", 30025,arrayCursos.get(0),1, "Erasmus"));
    arrayAlunos.add(new Aluno ("GUILHERME ANTONIO COELHO ROSA D ABREU", "30026@student.dei.uc.pt", 30026,arrayCursos.get(1),2, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("HERNANI MIGUEL MARTINS GONÇALVES", "30027@student.dei.uc.pt", 30027,arrayCursos.get(3),2, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("HORACIO CARVALHO ROSA", "30028@student.dei.uc.pt", 30028,arrayCursos.get(3),2, "Normal"));
    arrayAlunos.add(new Aluno ("FRANCISCO RIBEIRO CARDOSO", "30029@student.dei.uc.pt", 30029,arrayCursos.get(3),1, "Normal"));
    arrayAlunos.add(new Aluno ("JOÃO CONCEIÇÃO JUSTINO", "30030@student.dei.uc.pt", 30030,arrayCursos.get(1),2, "Normal"));
    arrayAlunos.add(new Aluno ("JOÃO DA ANUNCIAÇÃO GUARINO", "30031@student.dei.uc.pt", 30031,arrayCursos.get(2),1, "Normal"));
    arrayAlunos.add(new Aluno ("JOÃO DANIEL LERIAS DUARTE", "30032@student.dei.uc.pt", 30032,arrayCursos.get(2),2, "Atleta"));
    arrayAlunos.add(new Aluno ("KOKOU AFONOUVI AMEGNAGLO", "30033@student.dei.uc.pt", 30033,arrayCursos.get(0),1, "Dirigente Associativo"));
    arrayAlunos.add(new Aluno ("LAHCEN EL HIANI", "30034@student.dei.uc.pt", 30034,arrayCursos.get(3),2, "Erasmus"));
    arrayAlunos.add(new Aluno ("MANUEL ALMEIDA NASCIMENTO", "30035@student.dei.uc.pt", 30035,arrayCursos.get(4),1, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("PAULO VALERIO DE OLIVEIRA", "30036@student.dei.uc.pt", 30036,arrayCursos.get(0),1, "Normal"));
    arrayAlunos.add(new Aluno ("PEDRO MARQUES RIBEIRO", "30037@student.dei.uc.pt", 30037,arrayCursos.get(0),2, "Atleta"));
    arrayAlunos.add(new Aluno ("RICARDO FILIPE PEREIRA DA CRUZ", "rfcruz@student.dei.uc.pt", 99999,arrayCursos.get(0),3, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("RICARDO OLIVEIRA CARINHAS", "30038@student.dei.uc.pt", 30038,arrayCursos.get(0),2, "Normal"));
    arrayAlunos.add(new Aluno ("RITA ANDREIA JULIO DIAS", "30039@student.dei.uc.pt", 30039,arrayCursos.get(0),1, "Trabalhador-Estudante"));
    arrayAlunos.add(new Aluno ("SILVINO FERREIRA DOS SANTOS DUARTE", "30040@student.dei.uc.pt", 30040,arrayCursos.get(4),3, "Normal"));

          
   
    //Cria arrayList de Disciplinas
      
    ArrayList <Disciplina> arrayDisciplinas = new ArrayList <Disciplina>();
  
    //POO     
    ArrayList <Docente> auxDocentePoo = new ArrayList <Docente>();
    ArrayList <Aluno> auxAlunoInscritoPoo = new ArrayList <Aluno>();
    auxDocentePoo.add((Docente) arrayFuncionarios.get(16));
    auxDocentePoo.add((Docente) arrayFuncionarios.get(17));
    auxDocentePoo.add((Docente) arrayFuncionarios.get(18));
    auxAlunoInscritoPoo.add(arrayAlunos.get(0));
    auxAlunoInscritoPoo.add(arrayAlunos.get(12));
    auxAlunoInscritoPoo.add(arrayAlunos.get(32));
    auxAlunoInscritoPoo.add(arrayAlunos.get(37));
    auxAlunoInscritoPoo.add(arrayAlunos.get(39));
    arrayDisciplinas.add(new Disciplina("Programação Orientada aos Objectos", (Docente) arrayFuncionarios.get(15), auxDocentePoo, auxAlunoInscritoPoo));
     
     //ED
    ArrayList <Docente> auxDocenteEd = new ArrayList <Docente>();
    ArrayList <Aluno> auxAlunoInscritoEd = new ArrayList <Aluno>();
    auxDocenteEd.add((Docente) arrayFuncionarios.get(39));
    auxDocenteEd.add((Docente) arrayFuncionarios.get(43));
    auxDocenteEd.add((Docente) arrayFuncionarios.get(53));
    auxAlunoInscritoEd.add(arrayAlunos.get(0));
    auxAlunoInscritoEd.add(arrayAlunos.get(9));
    auxAlunoInscritoEd.add(arrayAlunos.get(12));
    auxAlunoInscritoEd.add(arrayAlunos.get(24));
    arrayDisciplinas.add(new Disciplina("Estruturas Discretas", (Docente) arrayFuncionarios.get(50), auxDocenteEd, auxAlunoInscritoEd));

     //Base de Dados     
    ArrayList <Docente> auxDocenteBd = new ArrayList <Docente>();
    ArrayList <Aluno> auxAlunoInscritoBd = new ArrayList <Aluno>();
    auxDocenteBd.add((Docente) arrayFuncionarios.get(22));
    auxDocenteBd.add((Docente) arrayFuncionarios.get(27));
    auxDocenteBd.add((Docente) arrayFuncionarios.get(33));
    auxAlunoInscritoBd.add(arrayAlunos.get(0));
    auxAlunoInscritoBd.add(arrayAlunos.get(12));
    auxAlunoInscritoBd.add(arrayAlunos.get(37));
    auxAlunoInscritoBd.add(arrayAlunos.get(39));
    arrayDisciplinas.add(new Disciplina("Base de Dados", (Docente) arrayFuncionarios.get(47), auxDocenteBd, auxAlunoInscritoBd));
     
     //ACC
    ArrayList <Docente> auxDocentePgi= new ArrayList <Docente>();
    ArrayList <Aluno> auxAlunoInscritoPgi = new ArrayList <Aluno>();
    auxDocentePgi.add((Docente) arrayFuncionarios.get(29));
    auxDocentePgi.add((Docente) arrayFuncionarios.get(20));
    auxDocentePgi.add((Docente) arrayFuncionarios.get(21));
    auxAlunoInscritoPgi.add(arrayAlunos.get(1));
    auxAlunoInscritoPgi.add(arrayAlunos.get(6));
    auxAlunoInscritoPgi.add(arrayAlunos.get(13));
    auxAlunoInscritoPgi.add(arrayAlunos.get(35));
    arrayDisciplinas.add(new Disciplina("Arte e Cultura Contemporânea", (Docente) arrayFuncionarios.get(30), auxDocentePgi, auxAlunoInscritoPgi));

     // SO
    ArrayList <Docente> auxDocenteSo= new ArrayList <Docente>();
    ArrayList <Aluno> auxAlunoInscritoSo = new ArrayList <Aluno>();
    auxDocenteSo.add((Docente) arrayFuncionarios.get(36));
    auxDocenteSo.add((Docente) arrayFuncionarios.get(37));
    auxDocenteSo.add((Docente) arrayFuncionarios.get(38));
    auxAlunoInscritoSo.add(arrayAlunos.get(0));
    auxAlunoInscritoSo.add(arrayAlunos.get(9));
    auxAlunoInscritoSo.add(arrayAlunos.get(12));
    auxAlunoInscritoSo.add(arrayAlunos.get(24));
    auxAlunoInscritoSo.add(arrayAlunos.get(37));
    auxAlunoInscritoSo.add(arrayAlunos.get(39));
    arrayDisciplinas.add(new Disciplina("Sistemas Operativos", (Docente) arrayFuncionarios.get(35), auxDocenteSo, auxAlunoInscritoSo));

     // Tecnologias da Internet
    ArrayList <Docente> auxDocenteTi= new ArrayList <Docente>();
    ArrayList <Aluno> auxAlunoInscritoTi = new ArrayList <Aluno>();
    auxDocenteTi.add((Docente) arrayFuncionarios.get(25));
    auxDocenteTi.add((Docente) arrayFuncionarios.get(26));
    auxDocenteTi.add((Docente) arrayFuncionarios.get(27));
    auxAlunoInscritoTi.add(arrayAlunos.get(0));
    auxAlunoInscritoTi.add(arrayAlunos.get(26));
    auxAlunoInscritoTi.add(arrayAlunos.get(29));
    auxAlunoInscritoTi.add(arrayAlunos.get(37));
    arrayDisciplinas.add(new Disciplina("Tecnologias da Internet", (Docente) arrayFuncionarios.get(24), auxDocenteTi, auxAlunoInscritoTi));

     // MAS
    ArrayList <Docente> auxDocenteMas= new ArrayList <Docente>();
    ArrayList <Aluno> auxAlunoInscritoMas = new ArrayList <Aluno>();
    auxDocenteMas.add((Docente) arrayFuncionarios.get(22));
    auxDocenteMas.add((Docente) arrayFuncionarios.get(40));
    auxDocenteMas.add((Docente) arrayFuncionarios.get(41));
    auxAlunoInscritoMas.add(arrayAlunos.get(2));
    auxAlunoInscritoMas.add(arrayAlunos.get(15));
    auxAlunoInscritoMas.add(arrayAlunos.get(16));
    auxAlunoInscritoMas.add(arrayAlunos.get(18));
    auxAlunoInscritoMas.add(arrayAlunos.get(30));
    auxAlunoInscritoMas.add(arrayAlunos.get(31));
    arrayDisciplinas.add(new Disciplina("Modelação e Análise de Sistemas", (Docente) arrayFuncionarios.get(39), auxDocenteMas, auxAlunoInscritoMas));

      
     // THD
    ArrayList <Docente> auxDocenteThd= new ArrayList <Docente>();
    ArrayList <Aluno> auxAlunoInscritoThd = new ArrayList <Aluno>();
    auxDocenteThd.add((Docente) arrayFuncionarios.get(45));
    auxDocenteThd.add((Docente) arrayFuncionarios.get(46));
    auxAlunoInscritoThd.add(arrayAlunos.get(3));
    auxAlunoInscritoThd.add(arrayAlunos.get(19));
    auxAlunoInscritoThd.add(arrayAlunos.get(21));
    auxAlunoInscritoThd.add(arrayAlunos.get(23));
    auxAlunoInscritoThd.add(arrayAlunos.get(33));
    arrayDisciplinas.add(new Disciplina("Teoria e História do Design", (Docente) arrayFuncionarios.get(44), auxDocenteThd, auxAlunoInscritoThd));

        
    // Adicionar disciplinas a Cursos
    ArrayList <Disciplina> arrayDisciplinasLEI = new ArrayList<Disciplina> ();
    arrayDisciplinasLEI.add(arrayDisciplinas.get(0));
    arrayDisciplinasLEI.add(arrayDisciplinas.get(1));
    arrayDisciplinasLEI.add(arrayDisciplinas.get(2));
    arrayDisciplinasLEI.add(arrayDisciplinas.get(4));
    arrayCursos.get(0).setDisciplinas(arrayDisciplinasLEI);
    
        
    ArrayList <Disciplina> arrayDisciplinasLDM = new ArrayList<Disciplina> ();
    arrayDisciplinasLDM.add(arrayDisciplinas.get(5));  
    arrayDisciplinasLDM.add(arrayDisciplinas.get(3));
    arrayCursos.get(1).setDisciplinas(arrayDisciplinasLDM);
    
    ArrayList <Disciplina> arrayDisciplinasMEI = new ArrayList<Disciplina> ();
    arrayDisciplinasMEI.add(arrayDisciplinas.get(6));
    arrayDisciplinasMEI.add(arrayDisciplinas.get(5));
    arrayCursos.get(2).setDisciplinas(arrayDisciplinasMEI);
    
    
    ArrayList <Disciplina> arrayDisciplinasMDM = new ArrayList<Disciplina> ();
    arrayDisciplinasMDM.add(arrayDisciplinas.get(7));
    arrayDisciplinasMDM.add(arrayDisciplinas.get(5));
    arrayCursos.get(3).setDisciplinas(arrayDisciplinasMDM);
    
    ArrayList <Disciplina> arrayDisciplinasPHD = new ArrayList<Disciplina> ();
    arrayCursos.get(4).setDisciplinas(arrayDisciplinasPHD);
    
    //criar exames iniciais
    ArrayList <Exame> arrayExames = new ArrayList<Exame>();
    
    
    //EXAME0
    ArrayList <Sala> salasExame1 = new ArrayList <Sala>();
    salasExame1.add(new Sala ("EC.A",600));
    
    
    ArrayList <Docente> vigilantesExame1 = new ArrayList <Docente> ();
    vigilantesExame1.add((Docente) arrayFuncionarios.get(16));
    vigilantesExame1.add((Docente) arrayFuncionarios.get(17));
    vigilantesExame1.add((Docente) arrayFuncionarios.get(18));
            
    ArrayList <NaoDocente> funcionariosExame1 = new ArrayList <NaoDocente> ();
    funcionariosExame1.add((NaoDocente) arrayFuncionarios.get(1));
    funcionariosExame1.add((NaoDocente) arrayFuncionarios.get(3));
    funcionariosExame1.add((NaoDocente) arrayFuncionarios.get(5));
    
    HashMap<Aluno, Double> alunosExame1 = new HashMap<Aluno, Double>();
    alunosExame1.put(arrayAlunos.get(12), 0.0);
    alunosExame1.put(arrayAlunos.get(32), 0.0);
    alunosExame1.put(arrayAlunos.get(37), 0.0);
    alunosExame1.put(arrayAlunos.get(39), 0.0);
      
    
    String data = "2017-01-06 14:30";
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm");    
    
    Date date2 = null;    
    date2 = format.parse(data);  
    
    arrayExames.add(new Exame(arrayDisciplinas.get(0), "Normal", date2, 180, salasExame1, (Docente) arrayFuncionarios.get(15), vigilantesExame1, funcionariosExame1, alunosExame1));
    
    
    //EXAME 2
    ArrayList <Sala> salasExame2 = new ArrayList <Sala>();
    salasExame2.add(new Sala ("B1",300));
    
    
    ArrayList <Docente> vigilantesExame2 = new ArrayList <Docente> ();
    vigilantesExame2.add((Docente) arrayFuncionarios.get(20));
    vigilantesExame2.add((Docente) arrayFuncionarios.get(21));
    vigilantesExame2.add((Docente) arrayFuncionarios.get(15));
    
            
    ArrayList <NaoDocente> funcionariosExame2 = new ArrayList <NaoDocente> ();
    funcionariosExame2.add((NaoDocente) arrayFuncionarios.get(3));
    funcionariosExame2.add((NaoDocente) arrayFuncionarios.get(4));
    funcionariosExame2.add((NaoDocente) arrayFuncionarios.get(5));
    
    HashMap<Aluno, Double> alunosExame2 = new HashMap <Aluno, Double>();
    
   
    alunosExame2.put(arrayAlunos.get(1)    , 10.0);
    alunosExame2.put(arrayAlunos.get(6), 12.5);
    alunosExame2.put(arrayAlunos.get(13), 6.0);
    alunosExame2.put(arrayAlunos.get(35), 10.0);
    
       
    String data2 = "2017-01-21 9:30";
    DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm");    
    
    Date date22 = null;    
    date22 = format.parse(data2);  
    
    arrayExames.add(new Exame(arrayDisciplinas.get(3), "Recurso", date22, 180, salasExame2, (Docente) arrayFuncionarios.get(30), vigilantesExame2, funcionariosExame2, alunosExame2));
    
    
               
    // Criar os ficheiros .dat guardados em /database
            
    //copiar arrayList para o file de objectos - file funcionarios.dat    
    FicheiroDeObjectos fileFuncionarios = new FicheiroDeObjectos();
    
    try {
        fileFuncionarios.abreEscrita("database/funcionarios.dat");
        fileFuncionarios.escreveObjecto(arrayFuncionarios);
        fileFuncionarios.fechaEscrita();
        
    } catch (Exception e) {
        System.out.println("Ocorreu uma excepção: " + e);
    }
    
    // gravar para ficheiro alunos.dat    
    FicheiroDeObjectos fileAlunos = new FicheiroDeObjectos();
    
    try {
        fileAlunos.abreEscrita("database/alunos.dat");
        fileAlunos.escreveObjecto(arrayAlunos);
        fileAlunos.fechaEscrita();
        
    } catch (Exception e) {
        System.out.println("Ocorreu uma excepção: " + e);
    }
    
    //gravar para ficheiro disciplinas.dat
    FicheiroDeObjectos fileDisciplinas = new FicheiroDeObjectos();
    
    try {
        fileDisciplinas.abreEscrita("database/disciplinas.dat");
        fileDisciplinas.escreveObjecto(arrayDisciplinas);
        fileDisciplinas.fechaEscrita();
        
    } catch (Exception e) {
        System.out.println("Ocorreu uma excepção: " + e);
    }
    
     //gravar ficheiro cursos.dat
    FicheiroDeObjectos fileCursos = new FicheiroDeObjectos();
    
    try {
        fileCursos.abreEscrita("database/cursos.dat");
        fileCursos.escreveObjecto(arrayCursos);
        fileCursos.fechaEscrita();
        
    } catch (Exception e) {
        System.out.println("Ocorreu uma excepção: " + e);
    }
    
    
    //gravar ficheiro exames.dat
    FicheiroDeObjectos fileExames = new FicheiroDeObjectos();
    
    try {
        fileExames.abreEscrita("database/exames.dat");
        fileExames.escreveObjecto(arrayExames);
        fileExames.fechaEscrita();
        
    } catch (Exception e) {
        System.out.println("Ocorreu uma excepção: " + e);
    }
        
    }
    
    
}
