
package examesdei;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe que permite manipular os ficheiros de objectos através de uma interface simplificada
 * @author Ricardo Filipe Pereira da Cruz - 1995110956
 */
public class FicheiroDeObjectos implements Serializable {
    
    private ObjectInputStream iS;
    private ObjectOutputStream oS;
    
    /**
     * Método para abrir o ficheiro para leitura
     * @param nomeDoFicheiro
     * @return
     */
    public boolean abreLeitura(String nomeDoFicheiro) {
        try {
            iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
            return true;
            
        } catch(IOException e) {
            return false;
            }    
    }
    
    
    /**
     * Método para abrir o ficheiro para escrita
     * @param nomeDoFicheiro
     * @throws java.io.IOException
     */
    public void abreEscrita(String nomeDoFicheiro) throws IOException {
        oS = new ObjectOutputStream(new
        FileOutputStream(nomeDoFicheiro));
        
    }
    
    
    /**
     * Método para leitura de um objecto a partir de um ficheiro
     * @return
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public Object leObjecto() throws IOException, ClassNotFoundException {
        return iS.readObject();
        // o tratamento da eepção ClassNotFound não pode ser tratado aqui
    }
    
    /**
     * Método para escrita de um objecto num ficheiro
     * @param o
     * @throws IOException
     */
    public void escreveObjecto(Object o) throws IOException {
       oS.writeObject(o);
    }
    
    /**
     * Método para fechar um ficheiro aberto em modo leitura 
     * @throws IOException
     */
    public void fechaLeitura() throws IOException {
        iS.close();
    }
    
    /**
     * Método para fechar um ficheiro aberto em modo escrita
     * @throws IOException
     */
    public void fechaEscrita() throws IOException {
        oS.close();
    }
    
    
}
