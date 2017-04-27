
package examesdei;

import java.util.Scanner;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;


/**
 * Classe que faz a Gestão dos Exames
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class GestorExames {
    
    /**
     * Atributos da Classe GestorExames
     */
    private ArrayList<Sala> arraySalas = new ArrayList();
    private ArrayList<Aluno> arrayAlunos = new ArrayList();
    private ArrayList<Funcionario> arrayFuncionarios = new ArrayList();   //inlui Docente e NaoDocente
    private ArrayList<Disciplina> arrayDisciplinas = new ArrayList();
    private ArrayList<Exame> arrayExames = new ArrayList<Exame>();
    private ArrayList<Curso> arrayCursos = new ArrayList();


    /**
     * Função main
     * @param args
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        new GestorExames();
    }

    /**
     *
     * @throws ParseException
     */
    public GestorExames() throws ParseException {
        
        ArrayList <Sala> arraySalas = new ArrayList <Sala>();
        ArrayList <Exame> arrayExames = new ArrayList <Exame>();
        ArrayList <Funcionario> arrayFuncionarios = new ArrayList <Funcionario>();
        ArrayList <Disciplina> arrayDisciplinas = new ArrayList <Disciplina>();
        ArrayList <Curso> arrayCursos = new ArrayList <Curso>();
        ArrayList <Aluno> arrayAlunos= new ArrayList <Aluno>();
        


        // Carregar estruturas para a memória a partir dos ficheios em /database
       setArrayAlunos(); 
       setArrayExames();       
       setArrayDisciplinas(); 
       setArrayCursos();
       setArraySalas();
       setArrayfuncionarios();
       
      
       //CriadorBd.BaseDeDados();  // descomentar para criação da BD inicial       
        
        
        // Menu
        
        while(true) {
            int option = menu();  //tive de meter o menu a static
            
            switch(option) {
                case 0: 
                    
                    sair();
                    
                    System.exit(0);
                    break;
                        
                case 1: 
                    criarExame();  
                    break;
                
                case 2:
                    configurarSalaExame();
                    break;
                    
                case 3:
                    convocarFuncionarios();
                    break;
                
                    
                case 4:
                    inscreverAlunos();
                    break;
                    
                case 5:
                    lancarNotasExame();
                    break;    
                    
                case 6:
                    listaExames();
                    break;
                    
                case 7:
                    listarAlunosExame();
                    break;
                
                case 8:
                    listarExamesAluno();
                    break;
                
                case 9:
                    docentesFuncionariosExame();
                    break;    
                
                case 10:
                    listarExamesDocenteFuncionario();
                    break; 
                    
                case 11:
                    pautaExame();
                    break;
                    
            }
            
        }
        
    }
    
    
    
    /**
     * Método que carrega para a estrutura arrayExames os exames constantes no 
     * ficheiro exames.dat
     */
    public void setArrayExames(){        
        
        FicheiroDeObjectos fileExames = new FicheiroDeObjectos();
        
        try {
            if (fileExames.abreLeitura("database/exames.dat")) {
                arrayExames = (ArrayList<Exame>) fileExames.leObjecto();
                fileExames.fechaLeitura();
            } else{
                System.out.println(" ✗ Ocorreu um erro! Não foi possível abrir o ficheiro exames.dat");
            }
         
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro: " + e);
        }      
         
    }
    
    
        
    /**
     * Método que carrega para a estrutura arraySalas as salas constantes no 
     * ficheiro salas.txt
     */
    public  void setArraySalas(){ 
        try{
           File fileSalas = new File ("database/salas.txt");  
           FileReader frSalas = new FileReader(fileSalas);
           BufferedReader brSalas = new BufferedReader(frSalas);
           
           String line;
           
           for (int i = 0; (line = brSalas.readLine()) != null ; i++) {                      
               String[] token = line.split(";");
               arraySalas.add(new Sala (token[0], Integer.valueOf(token [1])));                           
           } 
                             
        } catch (IOException e) {
           System.out.println(" ✗ Ocorreu um erro! Não foi possível abrir o ficheiro salas.txt");
        }
                     
        
    }
    
    
    /**
     * Método que carrega para a arrayFuncionarios que inclui todos as docentes e 
     * não docentes constantes no ficheiro funcionarios.dat
     *  
     */
    public void setArrayfuncionarios(){        
  
        FicheiroDeObjectos fileFuncionarios = new FicheiroDeObjectos();
        
        try {
            if (fileFuncionarios.abreLeitura("database/funcionarios.dat")) {
                arrayFuncionarios = (ArrayList<Funcionario>) fileFuncionarios.leObjecto();
                fileFuncionarios.fechaLeitura();
            } else{
                System.out.println(" ✗ Ocorreu um erro! Não foi possível abrir o ficheiro funcionários.dat");
            }
                        
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro: " + e);
        }
        
    }
    
    /**
     * Método que carrega para a estrutura arrayEstudantesque todos os alunos constantes
     * no ficheiro alunos.dat
     *  
     */
    public void setArrayAlunos(){        
        
        FicheiroDeObjectos fileAlunos = new FicheiroDeObjectos();
        
        try {
            if (fileAlunos.abreLeitura("database/alunos.dat")) {
                arrayAlunos = (ArrayList<Aluno>) fileAlunos.leObjecto();
                fileAlunos.fechaLeitura();
            }  else{
                System.out.println(" ✗ Ocorreu um erro! Não foi possível abrir o ficheiro alunos.dat");
            }
                        
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro: " + e);
        } 
        
        
    }
    
    
    /**
     * Método que carrega para a estrutura arrayDisciplinastodas as disciplinas 
     * do ficheiro discipinas.dat
     *  
     */
    public  void setArrayDisciplinas(){        
        
        FicheiroDeObjectos fileDisciplinas = new FicheiroDeObjectos();
        
        try {
            if (fileDisciplinas.abreLeitura("database/disciplinas.dat")) {
                arrayDisciplinas = (ArrayList<Disciplina>) fileDisciplinas.leObjecto();
                fileDisciplinas.fechaLeitura();
            } else{
                System.out.println(" ✗ Ocorreu um erro! Não foi possível abrir o ficheiro disciplinas.dat");
            }
                        
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro: " + e);
        }        
    }
    
    /**
     * Método que carrega para a estrutura arrayCursos os cursos constantes do 
     * ficheiro curso.dat
     */
    public  void setArrayCursos(){
                
        FicheiroDeObjectos fileCursos = new FicheiroDeObjectos();
        
        try {
            if (fileCursos.abreLeitura("database/cursos.dat")) {
                arrayCursos = (ArrayList<Curso>) fileCursos.leObjecto();
                fileCursos.fechaLeitura();
            }            
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro: " + e);
        }
    }
    
    
    /**
     * Menu principal do programa
     * @return Opção escolhida pelo utilizador
     */
    public static int menu() {
        int option;
        Scanner console = new Scanner(System.in);
        String input;
        int number;
        boolean isValid;   
        System.out.println("\n\n");
        System.out.println("                            ╔═══════════════════════════════════════════╗                            ");
        System.out.println("╔═══════════════════════════╣   PROJECTO POAO     -    EXAMES @ DEI     ╠═══════════════════════════╗");
        System.out.println("║                           ╚═══════════════════════════════════════════╝                           ║");
        System.out.println("║                                                                                                   ║");
        System.out.println("║    [1] Criar Exame                                   [7] Listar alunos inscritos num exame        ║");
        System.out.println("║                                                                                                   ║");
        System.out.println("║    [2] Configurar sala de exame                      [8] Listar exames de um aluno                ║");
        System.out.println("║                                                                                                   ║");
        System.out.println("║    [3] Convocar Vigilantes/Funcionários              [9] Listar docentes/funcionários de um exame ║");
        System.out.println("║                                                                                                   ║");
        System.out.println("║    [4] Inscrever alunos                             [10] Listar exames de docente ou funcionário  ║");
        System.out.println("║                                                                                                   ║");
        System.out.println("║    [5] Lançar notas de um exame                     [11] Listar notas de um exame                 ║");
        System.out.println("║                                                                                                   ║");
        System.out.println("║    [6] Listar exames                                                                              ║");
        System.out.println("║                                                                                                   ║");
        System.out.println("║                                             [0] SAIR                                              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");

        
        do {
            isValid = true;
            System.out.print("     Introduza uma opção (0 - 11): ");
            input = console.nextLine();
            try {
                number = Integer.parseInt(input);
                if (number < -1 || number > 11) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a 11.        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a 11.        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        option = Integer.parseInt(input);
        
    return option;
    }
    
    /**
     * Método que cria um exame no arrayExames. Pede ao utilizador a Disciplina,
     * a data e a época. Verifica a disponibilidade do Docente responsável pela disciplina e caso
     * ele tenha, cria o exame  atribui o Docente. Depois atribui os outros Docentes ao exame 
     * (caso tenham disponibilide).
     * @throws java.text.ParseException
     */
    @SuppressWarnings("empty-statement")
    private void criarExame() throws ParseException{
        
              Scanner console= new Scanner(System.in);
        int numeroDisciplinas = arrayDisciplinas.size();
        boolean isValid;
       
        String input;
        String epocaExameInput;
        String duracaoExameInput;
        String epocaExame  = "";
        int optionDuracao = 0;
        SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 1 -  CRIAR EXAME                                                         │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ ");
        
        //mostra disciplinas
        System.out.println("\n   ...... DISCIPLINAS DISPONÍVEIS ");
        System.out.println("\n\tID   DISCIPLINA                          ");
        System.out.println("\t---------------------------------------------------------");
        
        for (int i = 0; i < numeroDisciplinas; i++){
            System.out.println(String.format("\t%-4s%-12s", i+1, arrayDisciplinas.get(i).getNome() ));
            
        }
        
        //seleciona disciplina
        do {
            isValid = true;
            System.out.print("\n    Escolha o ID da DISCIPLINA (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroDisciplinas) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroDisciplinas + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroDisciplinas + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);        
        
        
        
        int option = Integer.parseInt(input);
            if (option == 0){
                System.out.println("\n\n");
           
        
            } else {
              
            int posicaoDisciplina = option - 1; //posição da disciplina seleccionada no arrayDisciplinas
            Disciplina disciplinaSelecionada = arrayDisciplinas.get(posicaoDisciplina);
            
            //data do exame
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm");
            System.out.print("\n    Introduza a data do exame (yyyy-MM-dd HH:mm):  ");

            Date dataExame = null;
            Date tday = new Date();
            
            boolean dataExameT =false;
            
            String line = null;
            
            while (dataExameT == false) {
                line = console.nextLine();
                dataExameT = isThisDateValid(line, "yyyy-MM-dd' 'HH:mm");
                
            }
            
            dataExame = format.parse(line);
                       
            boolean disponivel = disponibilidadeDocente( arrayDisciplinas.get(posicaoDisciplina).getDocente(), dataExame);       

            if (disponivel == true) {

                //pedir época           
                do {
                isValid = true;
                System.out.print("\n    Introduza a época do exame ( 1 - Normal    2 - Recurso  3 - Especial ): ");
                epocaExameInput = console.nextLine();
                try {
                    int number = Integer.parseInt(epocaExameInput);
                    if (number < 0 || number > 3) {
                        isValid = false; 
                      System.out.println((char)27 + "[31m         ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a 3!        \n" + (char)27 + "[0m");


                    }
                } catch (NumberFormatException e) {
                    isValid = false;
                    System.out.println((char)27 + "[31m             ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a 3!        \n" + (char)27 + "[0m");

                }

                } while (!isValid); 


                int optionEpoca = Integer.parseInt(epocaExameInput);

                      switch (optionEpoca) {
                          case 1:
                              epocaExame = "Normal";
                              break;
                          case 2:
                              epocaExame = "Recurso";
                              break; 
                          case 3:
                              epocaExame = "Especial";
                              break;
                          default:
                              break;
                      }



                // pedir duração do exame em minutos
                do {
                isValid = true;
                System.out.print("\n    Introduza a duraçao do exame em minutos (min: 30 ,  max 180): ");
                duracaoExameInput = console.nextLine();
                try {
                    int number = Integer.parseInt(duracaoExameInput);
                    if (number < 29 || number > 181) {
                        isValid = false; 
                      System.out.println((char)27 + "[31m         ✗ DURAÇÃO INVÁLIDA! A duração de um exame tem de ser enre 30m e 180m!        \n" + (char)27 + "[0m");


                    }
                } catch (NumberFormatException e) {
                    isValid = false;
                    System.out.println((char)27 + "[31m            ✗ DURAÇÃO INVÁLIDA! A duração de um exame tem de ser enre 30m e 180m!        \n" + (char)27 + "[0m");

                }

                } while (!isValid); 

                optionDuracao= Integer.parseInt(duracaoExameInput); 

                //criar array de vigilantes para o exame. São os docentes da disciplina, se nao tiverem vigilâncias sobrepostas
                ArrayList <Docente> vigilantesExames = new ArrayList <>();

                 for (int l =0; l <  disciplinaSelecionada.getOutrosDocentes().size(); l++) {
                    if (disponibilidadeDocente( disciplinaSelecionada.getOutrosDocentes().get(l), dataExame) == true){
                        vigilantesExames.add(disciplinaSelecionada.getOutrosDocentes().get(l));
                    }
                }

                //criar exame no arrayExames
                System.out.println("\n");
                System.out.println("          ─────────────────────────────────────────────────────────────────────────────────");
                System.out.println("                            ✓  Foi criado um exame com os seguintes dados:                 \n");
                System.out.println("            Disciplina:  " + disciplinaSelecionada.getNome());
                System.out.println("            Docente Responsável: " + arrayDisciplinas.get(posicaoDisciplina).getDocente().getNome());
                System.out.println("            Data: " + format.format(dataExame));
                System.out.println("            Época: " + epocaExame);
                System.out.println("            Vigilantes (docentes da disciplina): ");
                for (int j = 0; j < vigilantesExames.size(); j++) {
                    System.out.println("                    " + vigilantesExames.get(j).getNome());
                }
                System.out.println("          ──────────────────────────────────────────────────────────────────────────────────\n\n");

                arrayExames.add(new Exame(disciplinaSelecionada, epocaExame, dataExame, optionDuracao, new ArrayList<Sala>(), arrayDisciplinas.get(posicaoDisciplina).getDocente(), vigilantesExames, new ArrayList<NaoDocente>(), new HashMap<>() )); 



            } else if (disponivel == false) {
                System.out.println("");
                System.out.println((char)27 + "[31m         ✗ EXAME NÃO CRIADO! O Docente Responsável da disciplina já tem vigilância marcada nesse horário!        \n" + (char)27 + "[0m");

            }

       }
    
       
    }
    
    /**
     * Método que permite adicionar uma sala a um exame (opçao 2)
     */
    private void configurarSalaExame(){
        
        boolean isValid;
        String input;
        Scanner console = new Scanner(System.in);
        int numeroExames = arrayExames.size();
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 2 -  CONFIGURAR SALA DE EXAME                                            │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n\n");
        
        
        //lista exames
       
        System.out.println("\n   ...... EXAMES DISPONVEIS ");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
            System.out.println("\n\tID   Época                 Disciplina                       Horário             ");
            System.out.println("\t------------------------------------------------------------------------------------");
            for (int i = 0; i < arrayExames.size(); i++) {      
                System.out.println(String.format("\t%-4s %-12s %-40s %-10s",i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getDataHora()));
                
            }
            System.out.println("\n\n");
        
        //seleccionar o exame
        do {
            isValid = true;
            System.out.print("    Escolha o ID do exame que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroExames) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int option = Integer.parseInt(input);
        int posicaoExame = option -1;
      
        if (option == 0) {
            System.out.println("\n\n");
            
            
        } else {
            // lista sala disponiveis para aquela hora
            System.out.println("\n   ------ Salas disponiveis para o horário: " + dt.format(arrayExames.get(posicaoExame).getDataHora()));
            
            
            ArrayList<String> salasLivres = salasLivres(arrayExames.get(posicaoExame).getDataHora());
            

            System.out.println("\n\tID       Sala       ");
            System.out.println("\t---------------------");

            int numeroSalasLivres = salasLivres.size();
            for (int i =0; i < numeroSalasLivres; i++) {
               System.out.println("\t" +(i+1) + "\t" + salasLivres.get(i));

            }
        
            // seleccionar sala
            do {
            isValid = true;
            System.out.print("\n    Escolha o ID da SALA que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroSalasLivres) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroSalasLivres + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroSalasLivres + ".        \n" + (char)27 + "[0m");

            }

             } while (!isValid);
            
            int opcao = Integer.parseInt(input);
            
            if (opcao == 0) {
            System.out.println("\n\n");  //sai
            
            } else if (opcao != 0) {
               
                int posicaosala = opcao -1;
                //System.out.println(salasLivres.get(posicaosala));
                
                //ver qual é a sala do arraySalas cujo nome  é igual a salasLivres.get(posicaosala)
                int indice = 0;
                for (int j =0; j < arraySalas.size(); j++) {
                    if (arraySalas.get(j).getNomeSala().equals(salasLivres.get(posicaosala))) {
                        indice = j;
                    } 
                }
                
                //arrayExames.get(posicaoExame).getSala().set(0, arraySalas.get(indice));
                arrayExames.get(posicaoExame).getSala().add(0, arraySalas.get(indice));
                
                
            }
           
        
       }
        
    }
    
    /**
     * Método que convoca funcionários (docentes e não docentes) para um exame
     */
    private void convocarFuncionarios(){
        
        boolean isValid;
        String input;
        Scanner console = new Scanner(System.in);
        int numeroExames = arrayExames.size();
        int numeroFuncionarios = arrayFuncionarios.size();
        
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 3 -  CONVOCAR VIGILANTES E FUNCIONÁRIOS                                  │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n\n");
        
        //lista exames
       
        System.out.println("\n   ...... EXAMES DISPONVEIS ");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
            System.out.println("\n\tID   Época                 Disciplina                       Horário             ");
            System.out.println("\t------------------------------------------------------------------------------------");
            for (int i = 0; i < arrayExames.size(); i++) {      
                System.out.println(String.format("\t%-4s %-12s %-40s %-10s",i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getDataHora()));
                
            }
            System.out.println("\n\n");
        
        //seleccionar o exame
        do {
            isValid = true;
            System.out.print("    Escolha o ID do exame que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroExames) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int option = Integer.parseInt(input);
        int posicaoExame = option -1;

        if (option == 0) {
            System.out.println("\n\n");
            
        } else {
            Date dataExame = arrayExames.get(posicaoExame).getDataHora();
            
            ArrayList <Funcionario> funcionariosAux = new ArrayList <>();
            
            
            for (int i = 0; i < numeroFuncionarios; i++){
                if (arrayFuncionarios.get(i) instanceof NaoDocente) {
                    funcionariosAux.add(arrayFuncionarios.get(i));
                }
                
                else if (arrayFuncionarios.get(i) instanceof Docente) {
                    if ((disponibilidadeDocente((Docente) arrayFuncionarios.get(i), dataExame) == true )) {
                        funcionariosAux.add(arrayFuncionarios.get(i));
                    }
                    
                    else {
                        
                    }
                    
                }else {
                    System.out.println("Ocorreu um problema de consistência da Base deDados!");
                }
            }
        
            int sizeFuncionariosAux = funcionariosAux.size();
            
            System.out.println("\n   ...... FUNCIONÁRIOS DISPONÍEIS NESTE HORÁRIO: "+ dt.format(dataExame)  + "\n");
            
            for (int j=0; j < sizeFuncionariosAux; j++) {
                System.out.println(String.format("\t%-4s %-46s %-40s",(j+1) ,funcionariosAux.get(j).getNome() , funcionariosAux.get(j).getCategoria()));
            }
            
            
            do {
            isValid = true;
            System.out.print("\n       > Quantos FUNCIONÁRIOS (Docentes e não Docentes) pretende adicionar?  (0: sair)  ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > sizeFuncionariosAux) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + sizeFuncionariosAux + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + sizeFuncionariosAux + ".        \n" + (char)27 + "[0m");

            }
            } while (!isValid);
        
            int opcao = Integer.parseInt(input);
            
            if (opcao == 0) {
                
            }
            
            else {
              
                for (int i = 0; i < opcao; i++) {
                    do {
                    isValid = true;
                    System.out.print("          Introduza ID do " + (i+1) + "º Funcionário: ");
                    input = console.nextLine();
                    try {
                        int number = Integer.parseInt(input);
                        if (number < 0 || number > sizeFuncionariosAux) {
                        isValid = false;
                    System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 1 a " + sizeFuncionariosAux + ".        \n" + (char)27 + "[0m");


                }
                 } catch (NumberFormatException e) {
                    isValid = false;
                    System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 1 a " + sizeFuncionariosAux + ".        \n" + (char)27 + "[0m");

                }

                } while (!isValid);
                
                int opcaoEscolhida = Integer.parseInt(input);
                int posicaoFuncionaroListagemAux = opcaoEscolhida -1; 
                
                if (funcionariosAux.get(posicaoFuncionaroListagemAux) instanceof Docente) {
                    arrayExames.get(posicaoExame).getVigilantes().add((Docente)funcionariosAux.get(posicaoFuncionaroListagemAux));
                }
                
                else {
                    arrayExames.get(posicaoExame).getFuncionarios().add((NaoDocente) funcionariosAux.get(posicaoFuncionaroListagemAux));
                    
                } 
                    
                }
                
                
                
                
            }
            
            
        }
    }
    
     
    /**
     * Método que inscreve alunos num determinado exame escolhido pelo utilizador.
     * Faz a validação se o aluno está inscrito na disciplina e naépoca do exame
     */
    private void inscreverAlunos(){
        
        boolean isValid;
        String input;
        Scanner console = new Scanner(System.in);
        int numeroExames = arrayExames.size();
        int numeroAlunos = arrayAlunos.size();
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 4 -  INSCREVER ALUNOS NUM EXAME                                          │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n\n");
        
        
        //lista exames
       
        System.out.println("\n   ...... EXAMES DISPONVEIS ");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
            System.out.println("\n\tID   Época                 Disciplina                       Horário             ");
            System.out.println("\t------------------------------------------------------------------------------------");
            for (int i = 0; i < arrayExames.size(); i++) {      
                System.out.println(String.format("\t%-4s %-12s %-40s %-10s",i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getDataHora()));
                
            }
            System.out.println("\n\n");
        
        //seleccionar o exame
        do {
            isValid = true;
            System.out.print("    Escolha o ID do exame que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroExames) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int option = Integer.parseInt(input);
        int posicaoExame = option -1;
      
        if (option == 0) {
            System.out.println("\n\n");
            
        } else {
            
            String regimeExame = arrayExames.get(posicaoExame).getEpoca();
            
            
            ArrayList <String> listagemAux = new ArrayList<String>();
            
            
            
            if (regimeExame.equalsIgnoreCase("Normal") || regimeExame.equalsIgnoreCase("Recurso")) {
                
                for (int i = 0; i < numeroAlunos;i++) {
                    if ((alunoInscritoDisciplina(arrayAlunos.get(i), arrayExames.get(posicaoExame).getDisciplina()) == true)) {
                    listagemAux.add(arrayAlunos.get(i).getNome());
                } else {
                        
                    }
                    
                }
               
            }
            
            else if (regimeExame.equalsIgnoreCase("Especial")) {
                for (int i = 0; i < numeroAlunos;i++) {
                     if ((alunoInscritoDisciplina(arrayAlunos.get(i), arrayExames.get(posicaoExame).getDisciplina()) == true) && (estatutoEstudante(arrayAlunos.get(i))).equalsIgnoreCase(regimeExame)) {
                         listagemAux.add(arrayAlunos.get(i).getNome());
                     
                     } else {
                         //System.out.println("Aluno nao inscrito na cadeira ou nao inscrito nese regime");
                     } 
                }
            }
            
            int sizeListagemAux = listagemAux.size();
            
            System.out.println("\n   ...... ALUNOS DISPONIVEIS PARA INSCRIÇÃO: \n");
            for (int k=0; k < sizeListagemAux; k++) {
                System.out.println("\t\t" + (k+1) + "\t" + listagemAux.get(k));
            }
            
            System.out.println("");
           
            
            do {
            isValid = true;
            System.out.print("    Quantos alunos pretende inscrever?  ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 1 || number > sizeListagemAux) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 1 a " + sizeListagemAux + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 1 a " + sizeListagemAux + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int opcao = Integer.parseInt(input);
        
        
        for (int i = 0; i < opcao; i++){
            do {
            isValid = true;
            System.out.print("\n          Introduza ID do " + (i+1) + "º aluno: ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > sizeListagemAux) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 1 a " + sizeListagemAux + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 1 a " + sizeListagemAux + ".        \n" + (char)27 + "[0m");

            }

            } while (!isValid);
        
            int opcaoEscolhida = Integer.parseInt(input);
            int alunoListagemAux = opcaoEscolhida -1;
            int alunoPos = 0;
            
            if (opcaoEscolhida == 0) {
                
            } else {
                
                // aluno no arrayALunos
            for (int j=0; j < numeroAlunos; j++) {
                if (arrayAlunos.get(j).getNome().equalsIgnoreCase(listagemAux.get(alunoListagemAux))) {
                    alunoPos = j;
                    break;
                } else {
                    
                }
            }
           
            arrayExames.get(posicaoExame).getAlunosInscritosExame().put(arrayAlunos.get(alunoPos), 0.0);
            
            System.out.println("              ✓  Aluno inserido com êxito!");
                  
        }
     
       }
        
     }
       
    }
    
    
  
    /**
     * Método que permite lançar notas de um exame (opção 5)
     */
    private void lancarNotasExame(){
        
        boolean isValid;
        String input;
        int option;
        Scanner console = new Scanner(System.in);
        int numeroExames = arrayExames.size();
        double nota = 0;
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 5 -  LANÇAR NOTAS DE UM EXAME                                            │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n\n");
       
        //lista exames
       
        System.out.println("\n   ...... EXAMES DISPONVEIS ");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
            System.out.println("\n\tID   Época                 Disciplina                         Horário             ");
            System.out.println("\t------------------------------------------------------------------------------------");
            for (int i = 0; i < arrayExames.size(); i++) {      
                System.out.println(String.format("\t%-4s %-12s %-40s %-10s", (i+1), arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome() , dt.format(arrayExames.get(i).getDataHora())));
                
            }
            System.out.println("\n\n");
        
        //seleccionar o exame
        do {
            isValid = true;
            System.out.print("    Escolha o ID do exame que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroExames) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        option = Integer.parseInt(input);
        int posicaoExame = option -1;
      
        if (option == 0) {
           
        } else {
            
            if (arrayExames.get(posicaoExame).getAlunosInscritosExame().isEmpty()) {
                System.out.println("\n");
                System.out.println((char)27 + "[31m       ✗  O EXAME ainda não tem alunos associados. Utilize a opção (4) para adicionar alunos!\n\n" + (char)27 + "[0m");

                
            } else {
                for (Aluno key : arrayExames.get(posicaoExame).getAlunosInscritosExame().keySet()) {
                System.out.println("\n\t" + key.nome);
                
                do {
                isValid = true;
                System.out.print("\t     Introduza a NOTA (0 - 20): ");
                input = console.nextLine();
                try {
                nota = Integer.parseInt(input);
                if (nota < -1 || nota > 21) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha uma nota entre 0 a 20.        \n" + (char)27 + "[0m");


                }
                 } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha uma nota entre 0 a 11.        \n" + (char)27 + "[0m");

                }

                } while (!isValid);
             
                arrayExames.get(posicaoExame).getAlunosInscritosExame().put(key, nota);
            }
     }
   
            
    }
        
     
       
  }
    
  
    
    /**
     * Método que lista todos os exames (opçao 6)
     * @throws java.text.ParseException
     */
    private void listaExames() throws ParseException{
             
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 6 - LISTAR EXAMES                                                        │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n");
        
        String resposta = perguntaGravacaoFicheiro();
            
        if ("N".equalsIgnoreCase(resposta)) {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
            System.out.println("\nID   Época                 Disciplina                     Data/Hora          Duração     Sala     Nº Vigilantes     N.º Alunos");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < arrayExames.size(); i++) {
                System.out.println(String.format("%-4s%-12s%-40s%-23s%-10s%-15s%-15s%-10s", i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome(), dt.format(arrayExames.get(i).getDataHora()), arrayExames.get(i).getDuracao(),  arrayExames.get(i).getSala() == null ? "n/a": arrayExames.get(i).getSala() ,  arrayExames.get(i).getVigilantes() == null ? "n/a" :arrayExames.get(i).getVigilantes().size(), arrayExames.get(i).getAlunosInscritosExame() == null ? "n/a"  : arrayExames.get(i).getAlunosInscritosExame().size()  ));
           
                  
            }
            System.out.println("\n\n");
            
            
            
        } else if ("s".equalsIgnoreCase(resposta)) {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date data = new Date();            
            String fileName = "lista_exames " + dt.format(data);
            FicheiroDeTexto report = new FicheiroDeTexto();
            try {
                report.abreEscrita("reports/" + fileName);
                
                report.escreveLinha("LISTAGEM DE TODOS OS EXAMES MARCADOS");
                report.escreveLinha("Ficheiro gerado em: " + dt.format(data) + "\n\n");
                
                System.out.println("\nID   Época                 Disciplina                     Data/Hora          Duração     Sala     Nº Vigilantes     N.º Alunos");
                report.escreveLinha("\nID   Época                 Disciplina                     Data/Hora          Duração     Sala     Nº Vigilantes     N.º Alunos");
                        
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                report.escreveLinha("-------------------------------------------------------------------------------------------------------------------------------");
                
                for (int i = 0; i < arrayExames.size(); i++) {      
                     
                    System.out.println(String.format("%-4s%-12s%-40s%-23s%-10s%-15s%-15s%-10s", i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome(), dt.format(arrayExames.get(i).getDataHora()), arrayExames.get(i).getDuracao(),  arrayExames.get(i).getSala() == null ? "n/a": arrayExames.get(i).getSala() ,  arrayExames.get(i).getVigilantes() == null ? "n/a" :arrayExames.get(i).getVigilantes().size(), arrayExames.get(i).getAlunosInscritosExame() == null ? "n/a"  : arrayExames.get(i).getAlunosInscritosExame().size()  ));
                    report.escreveLinha(String.format("%-4s%-12s%-40s%-23s%-10s%-15s%-15s%-10s", i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome(), dt.format(arrayExames.get(i).getDataHora()), arrayExames.get(i).getDuracao(),  arrayExames.get(i).getSala() == null ? "n/a": arrayExames.get(i).getSala() ,  arrayExames.get(i).getVigilantes() == null ? "n/a" :arrayExames.get(i).getVigilantes().size(), arrayExames.get(i).getAlunosInscritosExame() == null ? "n/a"  : arrayExames.get(i).getAlunosInscritosExame().size()  ));
                }
                
                
                report.fechaEscrita();
                
            } catch (Exception e) {
                 System.out.println("Ocorreu uma excepção: " + e);
                }
            
            System.out.println("\n\n\n                                  ✓ Ficheiro gravado com o nome: " + fileName +"\n");
            
        }  
        
        
        Scanner s=new Scanner(System.in);
        System.out.println("                                          >>>   Prima [ENTER] para continuar   <<<");
        s.nextLine();
    }
    
    /**
     * Método que lista alunos inscritos num determinado exame (opção 7)
     */
    private void listarAlunosExame(){
        Scanner console = new Scanner(System.in);
        int numeroExames  = arrayExames.size();
        boolean isValid;
        String input;
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 7 - LISTAR ALUNOS INSCRITOS NUM EXAME                                    │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n");
        
        //lista exames disponiveis
        System.out.println("\n   ...... EXAMES DISPONÍVEIS ");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
            System.out.println("\n\tID   Época                 Disciplina                 ");
            System.out.println("\t---------------------------------------------------------");
            for (int i = 0; i < arrayExames.size(); i++) {      
                System.out.println(String.format("\t%-4s%-12s%-40s",i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome() ));
                
            }
            System.out.println("\n\n");
        
    
        //selecciona exame        
        do {
            isValid = true;
            System.out.print("    Escolha o ID do exame que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroExames) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int option = Integer.parseInt(input);
        if (option == 0) {
            System.out.println("\n\n");
           
        }
        else if (option != 0) {
            int posicaoExame = option -1;
            
            System.out.println("");
            String resposta = perguntaGravacaoFicheiro();
            
            if ("N".equalsIgnoreCase(resposta)) {
                System.out.println("\n\n   ...... OPÇÃO ESCOLHIDA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                System.out.println("\n                    NOME                                NOTA");
                System.out.println("-----------------------------------------------------------------");
                
                arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key, value) -> System.out.println(String.format("%-50s%10s", key.nome  , value)));
                System.out.println("\n\n");
                
            } else if ("s".equalsIgnoreCase(resposta)) {
                
                SimpleDateFormat dt7 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date data7 = new Date();            
                String fileName7 = "lista_alunos_exame " + dt7.format(data7);
                FicheiroDeTexto report7 = new FicheiroDeTexto();
                try {
                    report7.abreEscrita("reports/" + fileName7);
                    
                    report7.escreveLinha("LISTAGEM DE ALUNOS INSCRITOS NO EXAME: " + arrayExames.get(posicaoExame).getDisciplina().getNome() + " da Época " + arrayExames.get(posicaoExame).getEpoca());
                    report7.escreveLinha("Ficheiro gerado em: " + dt7.format(data7) + "\n");
                    
                    System.out.println("\n\n   ...... OPÇÃO ESCOLHIDA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                    
                    
                    System.out.println("\n                    NOME                                NOTA");
                    report7.escreveLinha("\n                    NOME                                NOTA");
                    
                    System.out.println("-----------------------------------------------------------------");
                    report7.escreveLinha("-----------------------------------------------------------------");
                    
                    arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key, value) -> System.out.println(String.format("%-50s%10s", key.nome , value)));
           
                    arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key, value) -> report7.escreveLinha(String.format("%-50s%10s", key.nome , value))); 
                    
                    
                    report7.fechaEscrita();
                    
                 } catch (Exception e) {
                     System.out.println("Ocorreu uma excepção: " + e);
                    }
            
                System.out.println("\n\n\n               ✓ Ficheiro gravado com o nome: " + fileName7 +"\n");
                
                
                
            }
            
            
        Scanner s=new Scanner(System.in);
        System.out.println("                                          >>>   Prima [ENTER] para continuar   <<<");
        s.nextLine();
        System.out.println("\n\n\n");
            
        }
        
     
        
    }
    
    /**
     * Método que lista os docentes e funcionários associados a um determinado exame
     */
    private void docentesFuncionariosExame(){
        Scanner console = new Scanner(System.in);
        int numeroExames  = arrayExames.size();
        boolean isValid;
        String input;
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 9 - LISTAR DOCENTES E FUNCIONÁRIOS DE UM EXAME                           │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n");
        
        //lista exames disponiveis
        System.out.println("\n   ...... EXAMES DISPONVEIS ");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
            System.out.println("\n\tID   Época                 Disciplina                 ");
            System.out.println("\t---------------------------------------------------------");
            for (int i = 0; i < arrayExames.size(); i++) {      
                System.out.println(String.format("\t%-4s%-12s%-40s",i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome() ));
                
            }
            System.out.println("\n\n");
        
        //seleccionar o exame
        do {
            isValid = true;
            System.out.print("    Escolha o ID do exame que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroExames) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int option = Integer.parseInt(input);
      
        if (option == 0) {
           
        }
        else if (option != 0) {
            System.out.println("");
            int posicaoExame = option -1;
            
            String resposta = perguntaGravacaoFicheiro();
            
            if ("N".equalsIgnoreCase(resposta)) {
            
                System.out.println("\n\n   ...... OPÇÃO ESCOLHIDA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                System.out.println("\n      NOME                    Nº Mecanográfico                  Observações");
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println(String.format("%-35s%-23s%-20s", arrayExames.get(posicaoExame).getDocenteResponsavel().getNome() , arrayExames.get(posicaoExame).getDocenteResponsavel().getNumeroMecnografico() , "Docente Responsável"));
            
                //imprime vigilantes
                for (int i=0; i < arrayExames.get(posicaoExame).getVigilantes().size(); i++) {
                    System.out.println(String.format("%-35s%-23s%-20s",arrayExames.get(posicaoExame).getVigilantes().get(i).getNome(), arrayExames.get(posicaoExame).getVigilantes().get(i).getNumeroMecnografico(), "Docente Vigilante"));
                }

                //imprime funcionarios
                for (int i=0; i < arrayExames.get(posicaoExame).getFuncionarios().size(); i++) {
                    System.out.println(String.format("%-35s%-23s%-20s",arrayExames.get(posicaoExame).getFuncionarios().get(i).getNome(), arrayExames.get(posicaoExame).getFuncionarios().get(i).getNumeroMecnografico(), "Funcionário de Apoio"));
                }
                
                System.out.println("\n\n");
            } else if ("s".equalsIgnoreCase(resposta)) {
                SimpleDateFormat dt9 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date data9 = new Date();            
                String fileName9 = "lista_docentes_funcionarios_exames " + dt9.format(data9);
                FicheiroDeTexto report9 = new FicheiroDeTexto();
                try {
                    report9.abreEscrita("reports/" + fileName9);
                    
                             
                    System.out.println("\n\n   ...... OPÇÃO ESCOLHIDA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                
                    report9.escreveLinha("Lista de Docentes e Funcionários do exame: " + arrayExames.get(posicaoExame).getDisciplina().getNome() + " - Época: " + arrayExames.get(posicaoExame).getEpoca());
                    report9.escreveLinha("Ficheiro gerado em: " + dt9.format(data9) + "\n");
                    
                    
                    System.out.println("\n      NOME                    Nº Mecanográfico                  Observações");
                    report9.escreveLinha("\n      NOME                    Nº Mecanográfico                  Observações");
                
                    System.out.println("-----------------------------------------------------------------------------------------");
                    report9.escreveLinha("-----------------------------------------------------------------------------------------");

                    System.out.println(String.format("%-35s%-23s%-20s", arrayExames.get(posicaoExame).getDocenteResponsavel().getNome() , arrayExames.get(posicaoExame).getDocenteResponsavel().getNumeroMecnografico() , "Docente Responsável"));
                    report9.escreveLinha(String.format("%-35s%-23s%-20s", arrayExames.get(posicaoExame).getDocenteResponsavel().getNome() , arrayExames.get(posicaoExame).getDocenteResponsavel().getNumeroMecnografico() , "Docente Responsável"));

                //imprime vigilantes
                    for (int i=0; i < arrayExames.get(posicaoExame).getVigilantes().size(); i++) {
                        System.out.println(String.format("%-35s%-23s%-20s",arrayExames.get(posicaoExame).getVigilantes().get(i).getNome(), arrayExames.get(posicaoExame).getVigilantes().get(i).getNumeroMecnografico(), "Docente Vigilante"));
                        report9.escreveLinha(String.format("%-35s%-23s%-20s",arrayExames.get(posicaoExame).getVigilantes().get(i).getNome(), arrayExames.get(posicaoExame).getVigilantes().get(i).getNumeroMecnografico(), "Docente Vigilante"));

                    }

                //imprime funcionarios
                    for (int i=0; i < arrayExames.get(posicaoExame).getFuncionarios().size(); i++) {
                        System.out.println(String.format("%-35s%-23s%-20s",arrayExames.get(posicaoExame).getFuncionarios().get(i).getNome(), arrayExames.get(posicaoExame).getFuncionarios().get(i).getNumeroMecnografico(), "Funcionário de Apoio"));
                        report9.escreveLinha(String.format("%-35s%-23s%-20s",arrayExames.get(posicaoExame).getFuncionarios().get(i).getNome(), arrayExames.get(posicaoExame).getFuncionarios().get(i).getNumeroMecnografico(), "Funcionário de Apoio"));
                    }
           
                    report9.fechaEscrita();
                
                } catch (Exception e) {
                     System.out.println("Ocorreu uma excepção: " + e);
                    }
            
            
            System.out.println("\n\n\n        ✓ Ficheiro gravado com o nome: " + fileName9 +"\n");
           
        }
        Scanner s=new Scanner(System.in);
        System.out.println("                                          >>>   Prima [ENTER] para continuar   <<<");
        s.nextLine();
        System.out.println("\n\n\n");
 
        }
    }
    
    
    /**
     * Método que lista os exames em que um funcionario (Docente ou Não Docente) está envolvido
     * (opção 10)
     * 
     */
    private void listarExamesDocenteFuncionario(){
        
        Scanner console = new Scanner(System.in);
        int numeroFuncionarios  = arrayFuncionarios.size();
        int numeroExames = arrayExames.size();
        boolean isValid;
        String input;
        boolean presente = false; //flag que indica se funcionario está escalado para um exame
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 10 - LISTAR EXAMES DE DOCENTE OU FUNCIONÁRIO                             │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n");
        
        //listagem de Docentes/Funcionários
        System.out.println("\n   ...... LISTAGEM  DE DOCENTES E NÃO DOCENTES");
        System.out.println("\n\tID                Nome                                    Categoria                 ");
        System.out.println("\t----------------------------------------------------------------------------------");
        for (int i=0; i < numeroFuncionarios; i++){
            System.out.println(String.format("\t%-4s%-50s%-10s", i+1 , arrayFuncionarios.get(i).getNome() ,arrayFuncionarios.get(i).getCategoria()));
        }
        
        
        //selecciona funcionário        
        do {
            isValid = true;
            System.out.print("\n\n    Escolha o ID do Funcionário que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroFuncionarios) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroFuncionarios + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroFuncionarios + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int option = Integer.parseInt(input);
        if (option == 0) {
            System.out.println("\n\n");
           
        } else if (option != 0) {
            
            System.out.println("");
            
            int posicaoFuncionario = option -1;
            String nomeFuncionarioEscolhido = arrayFuncionarios.get(posicaoFuncionario).getNome();
            
            String resposta = perguntaGravacaoFicheiro();
            
            
            if ("N".equalsIgnoreCase(resposta)) {
                
            System.out.println("\n\n   ...... OPÇÃO ESCOLHIDA:    " + nomeFuncionarioEscolhido + "  -  " + arrayFuncionarios.get(posicaoFuncionario).getCategoria());
            System.out.println("\n EXAME                                        EPOCA            DATA/HORA");
            System.out.println("---------------------------------------------------------------------------------");   
            
             /* if ( arrayFuncionarios.get(posicaoFuncionario) instanceof Docente ) {  // so procura no arrayVigilantes e docenteResponsável
                     }
                    */
                for (int i=0; i < numeroExames; i++){
                    if (arrayExames.get(i).getDocenteResponsavel().getNome().equalsIgnoreCase(nomeFuncionarioEscolhido)){
                        System.out.println(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                        presente = true;
                    }
                    
                    for( int j=0; j < arrayExames.get(i).getVigilantes().size(); j++){
                        if (arrayExames.get(i).getVigilantes().get(j).getNome().equalsIgnoreCase(nomeFuncionarioEscolhido)) {
                            System.out.println(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                            presente = true;
                        }
                    }
                
                    for( int k=0; k < arrayExames.get(i).getFuncionarios().size(); k++){
                        if (arrayExames.get(i).getFuncionarios().get(k).getNome().equalsIgnoreCase(nomeFuncionarioEscolhido)) {
                            System.out.println(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                            presente = true; 
                        }                      
                    }
                 }    
                
            }
               
            else if ("s".equalsIgnoreCase(resposta)) {
                Date data10 = new Date();
                String fileName10 = "lista_exames_funcionario " + dt.format(data10);
                FicheiroDeTexto report10 = new FicheiroDeTexto();
                
                try {
                    report10.abreEscrita("reports/" + fileName10);
                    
                    System.out.println("\n\n   ...... OPÇÃO ESCOLHIDA:    " + nomeFuncionarioEscolhido + "  -  " + arrayFuncionarios.get(posicaoFuncionario).getCategoria());
                    report10.escreveLinha("\n  Lista de exames onde o(a) Funcionário(a) " + nomeFuncionarioEscolhido + " - " + arrayFuncionarios.get(posicaoFuncionario).getCategoria() + " está envolvido(a):");
                    report10.escreveLinha("  Ficheiro gerado em: " + dt.format(data10) + "\n\n");
                    
                    System.out.println("\n EXAME                                        EPOCA            DATA/HORA");
                    report10.escreveLinha("\n EXAME                                        EPOCA            DATA/HORA");
                                        
                    System.out.println("------------------------------------------------------------------------------------------------");   
                    report10.escreveLinha("------------------------------------------------------------------------------------------------");   
            
                    
                    for (int i=0; i < numeroExames; i++){
                    if (arrayExames.get(i).getDocenteResponsavel().getNome().equalsIgnoreCase(nomeFuncionarioEscolhido)){
                        System.out.println(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                        report10.escreveLinha(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                        presente = true;
                    }
                    
                    for( int j=0; j < arrayExames.get(i).getVigilantes().size(); j++){
                        if (arrayExames.get(i).getVigilantes().get(j).getNome().equalsIgnoreCase(nomeFuncionarioEscolhido)) {
                            System.out.println(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                            report10.escreveLinha(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                            presente = true;
                        }
                    }
                
                    for( int k=0; k < arrayExames.get(i).getFuncionarios().size(); k++){
                        if (arrayExames.get(i).getFuncionarios().get(k).getNome().equalsIgnoreCase(nomeFuncionarioEscolhido)) {
                            System.out.println(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                            report10.escreveLinha(String.format("%-45s%-16s%-20s",arrayExames.get(i).getDisciplina().getNome() , arrayExames.get(i).getEpoca() , dt.format(arrayExames.get(i).getDataHora())));
                            presente = true; 
                        }                      
                    }
                 } 
                
                    
                if (presente == false) {
                    report10.escreveLinha("\n \n    ✖ O(a) funcionario(a) " + nomeFuncionarioEscolhido +" não está escalado(a) para nenhum exame!");
                }    
                
                report10.fechaEscrita();   
                    
                    
                } catch (Exception e) {
                     System.out.println("Ocorreu uma excepção: " + e);
                    }
            
                System.out.println("\n\n\n        ✓ Ficheiro gravado com o nome: " + fileName10 +"\n");
                
                }
            
            if (presente == false) {
                System.out.println("\n \n    ✖ O(a) funcionario(a) " + nomeFuncionarioEscolhido +" não está escalado(a) para nenhum exame!");
            } else {
                 
            }
                
            Scanner s=new Scanner(System.in);
            System.out.println("\n\n                                          >>>   Prima [ENTER] para continuar   <<<");
            s.nextLine();
        
    }   
        System.out.println("\n\n\n\n\n\n");
    }
    
    /**
     * Método que mostra as notas de um exame - Pauta de exame
     */
    private void pautaExame(){
       
        Scanner console = new Scanner(System.in);
        int numeroExames  = arrayExames.size();
        boolean isValid;
        String input;
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 11 - LISTAR NOTAS DE UM EXAME                                            │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n");
        
        //lista exames disponiveis
        System.out.println("\n   ...... EXAMES DISPONÍVEIS ");
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");   
            System.out.println("\n\tID   Época                 Disciplina                 ");
            System.out.println("\t---------------------------------------------------------");
            for (int i = 0; i < arrayExames.size(); i++) {      
                System.out.println(String.format("\t%-4s%-12s%-40s",i+1, arrayExames.get(i).getEpoca(), arrayExames.get(i).getDisciplina().getNome() ));
                
            }
            System.out.println("\n\n");
        
    
        //selecciona exame        
        do {
            isValid = true;
            System.out.print("    Escolha o ID do exame que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroExames) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroExames + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int option = Integer.parseInt(input);
        if (option == 0) {
            System.out.println("\n\n");
           
        }
        else if (option != 0) {
            int posicaoExame = option -1;
            
            System.out.println("");
            String resposta = perguntaGravacaoFicheiro();
            
            if ("N".equalsIgnoreCase(resposta)) {
                
                
                           
                ArrayList <Integer> pautaNumero = new ArrayList<>();
                ArrayList <String> pautaNome = new ArrayList<>();
                ArrayList <Integer> pautaNota = new ArrayList<>();
                        
                arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key , value) -> pautaNumero.add(key.getNumeroAluno())); 
                arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key , value) -> pautaNome.add(key.nome)); 
                arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key , value) -> pautaNota.add(value.intValue())); 
     
                System.out.println("\n\n   ...... OPÇÃO ESCOLHIDA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                
                 
                ArrayList <String> last = new ArrayList <String>();
                for (int i = 0; i < arrayExames.get(posicaoExame).getAlunosInscritosExame().size(); i++) {
                    last.add(String.format("%-50s%-20s%4s",  pautaNome.get(i) , pautaNumero.get(i), pautaNota.get(i)));
                }
                
               Collections.sort(last);
                
                Date today = new Date();
                System.out.println("\n");
                System.out.println("==============================================================================");
                System.out.println("  PAUTA EXAME DA DISCIPLINA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                System.out.println("  ÉPOCA: " + arrayExames.get(posicaoExame).getEpoca());
                System.out.println("  DATA: " + dt1.format(arrayExames.get(posicaoExame).getDataHora()));
                System.out.println("------------------------------------------------------------------------------");
                                    
                System.out.println("                NOME                          Nº DE ESTUDANTE          NOTA     ");
                System.out.println("------------------------------------------------------------------------------");
                for (int i = 0; i < last.size(); i++) {
                    System.out.println(last.get(i));
                }
                System.out.println("==============================================================================\n\n");
                
                
                
                
                
                
                
            } else if ("s".equalsIgnoreCase(resposta)) {
                
                SimpleDateFormat dt7 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date data7 = new Date();            
                String fileName7 = "PAUTA " + arrayExames.get(posicaoExame).getDisciplina().getNome() + " " +dt7.format(data7);
                FicheiroDeTexto report7 = new FicheiroDeTexto();
                
                ArrayList <Integer> pautaNumero = new ArrayList<>();
                ArrayList <String> pautaNome = new ArrayList<>();
                ArrayList <Integer> pautaNota = new ArrayList<>();
                        
                arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key , value) -> pautaNumero.add(key.getNumeroAluno())); 
                arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key , value) -> pautaNome.add(key.nome)); 
                arrayExames.get(posicaoExame).getAlunosInscritosExame().forEach((key , value) -> pautaNota.add(value.intValue())); 
     
                System.out.println("\n\n   ...... OPÇÃO ESCOLHIDA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                
                 
                ArrayList <String> last = new ArrayList <String>();
                for (int i = 0; i < arrayExames.get(posicaoExame).getAlunosInscritosExame().size(); i++) {
                    last.add(String.format("%-50s%-20s%-4s",  pautaNome.get(i) , pautaNumero.get(i), pautaNota.get(i)));
                }
                
               Collections.sort(last);
                
                
                try {
                    report7.abreEscrita("reports/" + fileName7);
                    
                    Date today = new Date();
                    System.out.println("\n");
                    
                    System.out.println("==============================================================================");
                    report7.escreveLinha("==============================================================================");
                    
                    System.out.println("  PAUTA EXAME DA DISCIPLINA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                    report7.escreveLinha("  PAUTA EXAME DA DISCIPLINA: " + arrayExames.get(posicaoExame).getDisciplina().getNome());
                    
                    System.out.println("  ÉPOCA: " + arrayExames.get(posicaoExame).getEpoca());
                    report7.escreveLinha("  ÉPOCA: " + arrayExames.get(posicaoExame).getEpoca());
                    
                    System.out.println("  DATA: " + dt1.format(arrayExames.get(posicaoExame).getDataHora()));
                    report7.escreveLinha("  DATA: " + dt1.format(arrayExames.get(posicaoExame).getDataHora()));
                    
                    System.out.println("------------------------------------------------------------------------------");
                    report7.escreveLinha("------------------------------------------------------------------------------");

                    System.out.println("                NOME                          Nº DE ESTUDANTE        NOTA     ");
                    report7.escreveLinha("                NOME                          Nº DE ESTUDANTE        NOTA     ");
                    
                    System.out.println("------------------------------------------------------------------------------");
                    report7.escreveLinha("------------------------------------------------------------------------------");
                    
                    
                    for (int i = 0; i < last.size(); i++) {
                        System.out.println(last.get(i));
                        report7.escreveLinha(last.get(i));
                    }
                    System.out.println("==============================================================================\n\n");
                    report7.escreveLinha("==============================================================================\n\n");

                    
                    report7.escreveLinha("Ficheiro gerado em: " + dt7.format(data7) + "\n");
                    report7.fechaEscrita();
                    
                 } catch (Exception e) {
                     System.out.println("Ocorreu uma excepção: " + e);
                    }
            
                System.out.println("\n ✓ Ficheiro gravado com o nome: " + fileName7 +"\n");
                
                
                
            }
            
            
        Scanner s=new Scanner(System.in);
        System.out.println("                   >>>   Prima [ENTER] para continuar   <<<");
        s.nextLine();
        System.out.println("\n\n\n");
            
        }
        
            
        }
    
  
    /**
     * Método que lista os exames em que aluno está inscrito
     * (opção 8)
     * 
     */
    private void listarExamesAluno(){
        
        Scanner console = new Scanner(System.in);
        int numeroAlunos  = arrayAlunos.size();
        int numeroExames = arrayExames.size();
        boolean isValid;
        String input;
        boolean presente = false; //flag que indica se o aluno está inscrito num exame
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        
        System.out.println("\n");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────┐ ");
        System.out.println("│  OPÇÃO 8 - LISTAR EXAMES EM QUE O ALUNO ESTÁ INSCRITO                           │ ");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────┘ \n");
        
        //lista todos os alunos
        System.out.println("\n   ...... LISTAGEM  DE ANUNOS");
        System.out.println("\n\tID                NOME                                    Nº ESTUDANTE                 ");
        System.out.println("\t----------------------------------------------------------------------------------");
        for (int i=0; i < numeroAlunos; i++){
            System.out.println(String.format("\t%-4s%-50s%-10s", i+1 , arrayAlunos.get(i).getNome() ,arrayAlunos.get(i).getNumeroAluno()));
        }
        
        //escolher aluno
        do {
            isValid = true;
            System.out.print("\n\n    Escolha o ID do ALUNO que pretende (0 para sair): ");
            input = console.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < 0 || number > numeroAlunos) {
                    isValid = false;
                  System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroAlunos + ".        \n" + (char)27 + "[0m");


                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println((char)27 + "[31m       ✗ OPÇÃO INVÁLIDA! Escolha um número de 0 a " + numeroAlunos + ".        \n" + (char)27 + "[0m");

            }

        } while (!isValid);
        
        int option = Integer.parseInt(input);
        
        if (option == 0) {
            System.out.println("\n\n");
           
        } else if (option != 0) {
            
            System.out.println("");
            
            int posicaoAluno = option -1;
            String nomeAlunoEscolhido = arrayAlunos.get(posicaoAluno).getNome();  //string nome do aluno_escolhido
            Aluno alunoEscolhido = arrayAlunos.get(posicaoAluno); // objecto ALUNO
            System.out.println("       Escolheu o aluno: " + nomeAlunoEscolhido );
            
            
            
            // workaround para questão dos hascodes serem diferentes no arrayAlunos e arrayExames
            // arrayExames.get(0).getAlunosInscritosExame().forEach((key, value) ->  copy.add(arrayExames.get(0).getDisciplina().getNome() +";" +  key.nome   +";" + value));
            
            ArrayList <String> copyHashMap = new ArrayList<>();
            
            ArrayList <String> valores = new ArrayList<>();
            for(int k=0; k < arrayExames.size(); k++) {
                ArrayList <Double> copy = new ArrayList<>(arrayExames.get(k).getAlunosInscritosExame().values());
                for (int j=0; j< copy.size(); j++) {
                    valores.add(arrayExames.get(k).getDisciplina().getNome() + " - " +arrayExames.get(k).getEpoca()+";" +copy.get(j).toString());
                 }
            }
            
            ArrayList <Aluno> keys = new ArrayList<>();
            for(int k=0; k < arrayExames.size(); k++) {
                ArrayList <Aluno> copy1 = new ArrayList<>(arrayExames.get(k).getAlunosInscritosExame().keySet());
                for (int j=0; j< copy1.size(); j++) {
                    keys.add(copy1.get(j));
                 }
            
            }
            
            ArrayList <String> nomes = new ArrayList<>();
            for (int j = 0; j < keys.size(); j++) {
                nomes.add(keys.get(j).nome);
                
            }
            
            
           
            for (int o = 0; o < nomes.size(); o ++) {
                copyHashMap.add(nomes.get(o) + ";" + valores.get(o));
            }
            
            
            //gravar em ficheiro?
            
            System.out.println("\n");
            String resposta = perguntaGravacaoFicheiro();
            
            
            if ("N".equalsIgnoreCase(resposta)) {
                
                boolean existe = false;
            
                System.out.println("\n DISCIPLINA / ÉPOCA                                       NOTA      ");
                System.out.println("--------------------------------------------------------------------");   


                String line;     
                for (int i = 0; i < copyHashMap.size(); i++) {

                        line = copyHashMap.get(i);
                        String[] token = line.split(";");
                       if (token[0].equalsIgnoreCase(nomeAlunoEscolhido)) {
                            System.out.println(String.format("%-55s%6s", token [1] , token [2]));
                            existe = true;
                        }
                        else {

                        }
                    }

                if (existe == false) {
                    System.out.println("                  O aluno não está inscrito em nenhum exame!");
                }
                
            } else if ("s".equalsIgnoreCase(resposta)) {
                
                boolean existe = false;
                FicheiroDeTexto report8 = new FicheiroDeTexto();
                SimpleDateFormat dt7 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date data7 = new Date();            
                String fileName8 = "Listagem de Exames do aluno " + nomeAlunoEscolhido + " " +dt7.format(data7);
                
                
                try {
                    
                    report8.abreEscrita("reports/" + fileName8);
                    
                    System.out.println("\n DISCIPLINA / ÉPOCA                                       NOTA      ");
                    report8.escreveLinha("\n DISCIPLINA / ÉPOCA                                       NOTA      ");
                    
                    System.out.println("-------------------------------------------------------------------");   
                    report8.escreveLinha("-------------------------------------------------------------------");

                    String line;     
                    for (int i = 0; i < copyHashMap.size(); i++) {

                            line = copyHashMap.get(i);
                            String[] token = line.split(";");
                           if (token[0].equalsIgnoreCase(nomeAlunoEscolhido)) {
                                System.out.println(String.format("%-55s%6s", token [1] , token [2]));
                                report8.escreveLinha(String.format("%-55s%6s", token [1] , token [2]));
                                
                                existe = true;
                            }
                            else {

                            }
                        }

                    if (existe == false) {
                        System.out.println("                ✗ O aluno não está inscrito em nenhum exame!");
                        report8.escreveLinha("                ✗ O aluno não está inscrito em nenhum exame!");
                    }
                    
                    
                    report8.escreveLinha("\n\nFicheiro gerado em: " + dt7.format(data7) + "\n");
                    report8.fechaEscrita();
                    
                    
                } catch (Exception e) {
                     System.out.println("Ocorreu uma excepção: " + e);
                    }
                
                
                System.out.println("\n ✓ Ficheiro gravado com o nome: " + fileName8 +"\n");
                
                
            
                
                
            }
                      
        Scanner s=new Scanner(System.in);
        System.out.println("\n\n                                          >>>   Prima [ENTER] para continuar   <<<");
        s.nextLine();   
       
        }
    }
        

    
    
    /**
     * Método que pergunta ao utilizador se pretende gravar a listagem em ficheiro
     * @return resposta Resposta do utiliador (s ou n)
     */
    private String perguntaGravacaoFicheiro(){
        System.out.print("    Pretende guardar a informação num ficheiro? (s/n): ");  
        Scanner sc= new Scanner(System.in);
        String resposta = sc.nextLine();
        
        while (!"S".equalsIgnoreCase(resposta) && !"N".equalsIgnoreCase(resposta)) {
            System.out.println((char)27 + "[31m           \n     ✗ Resposta inválida! Deverá responder s ou n !       " + (char)27 + "[0m");
            System.out.print("\n    Pretende guardar a informação num ficheiro? (s/n): "); 
            resposta = sc.nextLine();
        }
         return resposta;   
    }
    
    /**
     * Método que verifica se um Docente tem disponibilidade para vigiar um exame numa determinada data/hora
     * @param docente Docente
     * @param dataExame Data e hora do exame
     * @return
     */
    private boolean disponibilidadeDocente(Docente docente, Date dataExame){
        
        
        
        Calendar quatroHoraDepois = Calendar.getInstance();
        //quatroHoraDepois.setTime(dataExame);
        //quatroHoraDepois.add(Calendar.HOUR_OF_DAY, 3);
        //Date dataquatroHoraDepois = quatroHoraDepois.getTime();
        
        boolean disponivel = true;
        
        
        for (int i=0; i < arrayExames.size(); i++){
  
            if (arrayExames.get(i).getDocenteResponsavel().getNome().equalsIgnoreCase(docente.nome) && ((arrayExames.get(i).getDataHora().equals(dataExame) ))){
             
            disponivel = false;    
            
            break;
            
            }             
           
            for (int j=0; j < arrayExames.get(i).getVigilantes().size(); j++){
                if (arrayExames.get(i).getVigilantes().get(j).nome.equalsIgnoreCase(docente.nome)&& ((arrayExames.get(i).getDataHora().equals(dataExame)))) {
                    disponivel = false;
                    
                }
            
            }
            }        
        
        return disponivel;
    }
    
    /**
     * Método que recebe um data de um exame e devolve as salas livres para aquele horário
     * @param data Devolve array de strings com o nome das salas
     * @return
     */
    private ArrayList <String> salasLivres(Date data){
        
                
        ArrayList <String> salaAux = new ArrayList<String>();
     
        for (int i = 0; i < arraySalas.size(); i++) {
            salaAux.add(arraySalas.get(i).getNomeSala());
        }
        
       
                      
        ArrayList <String> salasOcupadas = new ArrayList<>();        
        
        for (int i = 0; i < arrayExames.size(); i++) {
            if(arrayExames.get(i).getSala().isEmpty()){
                          
            } else if (!arrayExames.get(i).getSala().isEmpty()) {
                
                if (arrayExames.get(i).getDataHora().equals(data)){
                                       
                    salasOcupadas.add(arrayExames.get(i).getSala().get(0).getNomeSala());
                }
            }           
            
        }
              
        
        
        salaAux.removeAll(salasOcupadas);
        return salaAux;
               
    }
    
    
    
    /**
     * Método que verifica se um dado aluno está inscrito numa disciplina
     * @param aluno 
     * @param disciplina
     * @return
     */
    private boolean alunoInscritoDisciplina(Aluno aluno, Disciplina disciplina){
        
        boolean inscrito = false;
        
        for (int i = 0; i < arrayDisciplinas.size(); i++) {
            if (arrayDisciplinas.get(i).getNome().equalsIgnoreCase(disciplina.getNome())) {
                for (int j=0; j < arrayDisciplinas.get(i).getAlunosInscritosDisciplina().size(); j++) {
                    if (arrayDisciplinas.get(i).getAlunosInscritosDisciplina().get(j).getNome().equalsIgnoreCase(aluno.nome)) {
                        inscrito = true;
                    } else {
                        
                    }
                }
                    
                
            } else {
                
            }
        }
        return inscrito;
    }                
               
    /**
     * Método que devolve o estatuto do estudante (Normal ou Especial)
     * @param estudante Recebe um objecto Aluno
     * @return
     */
    private String estatutoEstudante (Aluno estudante) {
        String estatuto ="";
        
        if (estudante.getRegime().equalsIgnoreCase("Trabalhador-Estudante") || estudante.getRegime().equalsIgnoreCase("Eramus") || estudante.getRegime().equalsIgnoreCase("Atleta") || estudante.getRegime().equalsIgnoreCase("Dirigente Associativo")) {
            estatuto = "Especial";
        }
        
        else if (estudante.getRegime().equalsIgnoreCase("Normal")) {
            estatuto = "Normal";
        }
       
        return estatuto;
    }
    
    /**
     * Método que valida se data introduzida pelo utilizador é válida
     * @param dateToValidate Data para validar
     * @param dateFromat Formato da data yyyy-MM-dd HH:mm
     * @return
     */
    private static boolean isThisDateValid(String dateToValidate, String dateFromat){
         
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
                
	if(dateToValidate == null){
            
            return false;
	} 

	SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
	sdf.setLenient(false);

	try {

            // se não for válida vai para a excepção
            Date date = sdf.parse(dateToValidate);
        
        } catch (ParseException e) {
            
            System.out.println((char)27 + "[31m       DATA INVÁLIDA! Introduza a data do exame no formato yyyy-MM-dd HH:mm       " + (char)27 + "[0m");
            System.out.println((char)27 + "[31m       Por exemplo:       " + dt.format(new Date()) + (char)27 + "[0m");
            System.out.print("    Introduza a data do exame (yyyy-MM-dd HH:mm):  ");     
			
            return false;
	}

	return true;
     }
     
    private void sair(){
        
        
        //Gravar exames em disco
        FicheiroDeObjectos fileExames = new FicheiroDeObjectos();
        try {
            fileExames.abreEscrita("database/exames.dat");
            fileExames.escreveObjecto(arrayExames);
            fileExames.fechaEscrita();
        
        } catch (Exception e) {
            System.out.println("      ✗ Ocorreu uma erro ao escrever no ficheiro exames.dat.\n      ✗ Os dados não foram gravados!");
        }
        
        System.out.println("\n            A sair.... Até à próxima! \n\n");
                   
    }
    }

