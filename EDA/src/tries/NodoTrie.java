/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tries;

/**
 *
 * @author hca
 */
public class NodoTrie {
  NodoTrie[] hijos; 
  boolean finPalabra;
  int contador;
  
  public NodoTrie(){
      hijos = new NodoTrie[26];
      finPalabra= true;   
      contador = 0;
  }

    public NodoTrie(NodoTrie[] hijos) {
        this.hijos = hijos;
        finPalabra= true;   
    }
  

    public NodoTrie[] getHijos() {
        return hijos;
    }

    public boolean isFinPalabra() {
        return finPalabra;
    }

    public void setFinPalabra(boolean finPalabra) {
        this.finPalabra = finPalabra;
    }
    
    public NodoTrie getSig(Character l, Character simbolos[]){
        int i = 0;
        while(i<simbolos.length && l!=simbolos[i]){
            i++;
        }
        if(i==simbolos.length)
            throw new RuntimeException("no existe el símbolo");
        else
            return hijos[i] ;
    }


    public void setSig(NodoTrie sig) {
        if(contador==hijos.length){
            expande();
        }
        hijos[contador]= sig;
        contador++;
    }

    private void expande() {
        NodoTrie[] aux = new NodoTrie[hijos.length*2];
        for(int i = 0; i<hijos.length;i++)
            aux[i] = hijos[i];
        hijos= aux;
    }
    
    public boolean estaVacio() {

        boolean res = true;
        int i = 0;
        while (res && i < hijos.length) {
            if (hijos[i] != null) {
                res = false;
            }
            i++;
        }
        return res;
    }

    void setSig(char simbolo, NodoTrie temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
