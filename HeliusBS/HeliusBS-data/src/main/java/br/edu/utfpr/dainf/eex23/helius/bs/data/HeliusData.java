package br.edu.utfpr.dainf.eex23.helius.bs.data;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class HeliusData {
    private static HeliusData hd;
    private HeliusData () {
        
    }
    
    public static HeliusData getInstance() {
        if(hd == null) {
            hd = new HeliusData();
        }
        return hd;
    }
    
    public synchronized boolean add(HeliusData data) {
        
        return false;
    }
    
    
}
