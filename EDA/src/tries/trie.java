/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tries;

import java.util.Arrays;

/**
 *
 * @author hca
 */
public class trie {
    NodoTrie raiz;
    Character[] simbolos;

    public trie(Character[] simbolos) {        
        raiz = null;
        Arrays.sort(simbolos);
        this.simbolos = simbolos;
    }
    public boolean busca(String llave, NodoTrie actual){
        if(actual == null)
            return false;
        if(llave.equals(""))
            return actual.isFinPalabra();
        return busca(llave.substring(1), actual.getSig(llave.charAt(0), simbolos));  
    }
    public boolean inserta(String llave, NodoTrie actual){
        boolean resp = false;
        NodoTrie temp;
        if(actual==null)
        return resp;
        if( llave.equals("")){
            actual.setFinPalabra(true);
            return resp;
        }        
        NodoTrie sig = actual.getSig(llave.charAt(0), simbolos);
        if(sig == null){
            sig = new NodoTrie();
            //actual.setSig(sig, simbolos);
                               
        }
        inserta(llave.substring(1), sig);
        return false;
    }
    private NodoTrie borra(String llave, NodoTrie actual){
        if(actual==null)
            return null;
        if(llave.equals("")){
            actual.setFinPalabra(false);
            if(actual.estaVacio())
                return null;
            else
                return actual;
        }
        char simbolo = llave.charAt(0);
        NodoTrie sig = actual.getSig(simbolo, simbolos);
        NodoTrie temp = borra(llave.substring(1), sig);
        actual.setSig(simbolo, temp);
        if(actual.isFinPalabra()&&actual.estaVacio())
            return null;
        return actual;
                    
    }
    
}