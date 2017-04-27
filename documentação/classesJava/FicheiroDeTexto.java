
package examesdei;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que permite manipular os ficheiros de texto através de uma interface simplificada
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class FicheiroDeTexto implements Serializable  {
    
    private BufferedReader fR;
    private BufferedWriter fW;
    
    /**
     * Metodo para abrir ficheiro de texto para leitura
     * @param nomeDoFicheiro
     * @throws IOException
     */
    public void abreLeitura(String nomeDoFicheiro) throws IOException {
        fR = new BufferedReader(new FileReader(nomeDoFicheiro));
    }
    
    /**
     * Metodo para abrir ficheiro de texto para escrita
     * @param nomeDoFicheiro
     * @throws IOException
     */
    public void abreEscrita(String nomeDoFicheiro) throws IOException {
        fW = new BufferedWriter(new FileWriter(nomeDoFicheiro));
    }
    
    /**
     * Metodo para ler linha de um ficheiro de texto
     * @return
     * @throws IOException
     */
    public String leLinha() throws IOException {
        return fR.readLine();
    }
    
    /**
     * Metodo para ler um numero do ficheiro de texto
     * @return
     */
    public int[] leNumeroInt() {
        int[] result = new int[2];
        
        try {
            String st = fR.readLine();
            if (st != null) {
                result[0] = 0;
                result[1] = Integer.parseInt(st);
            } else {
                result[0] = -1;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    /**
     * Método para escrever uma linha no ficheiro
     * @param linha
     */
    public void escreveLinha(String linha) {
        try {
            fW.write(linha,0,linha.length());
            fW.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Método para escrever um número inteiro no ficheiro. Recebe o número a escrever
     * @param num
     * @throws IOException
     */
    public void escreveNumero(int num) throws IOException {
        String st = ""; 
        st = st.valueOf(num); 
        escreveLinha(st);
    }
    
    /**
     * Método para fechar um ficheiro de texto aberto em modo leitura
     * @throws IOException
     */
    public void fechaLeitura() throws IOException { 
        fR.close();
    }
    
    /**
     * Método para fechar um ficheiro de  texto aberto em modo escrita
     * @throws IOException
     */
    public void fechaEscrita() throws IOException { 
        fW.close();
    }
    
    
}
