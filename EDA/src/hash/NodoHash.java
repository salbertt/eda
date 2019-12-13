/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author hca
 */
public class NodoHash <T>{
    Integer llave;
    T elemento;
    NodoHash<T> sig;

    public NodoHash(T elemento) {
        this.elemento = elemento;
        sig = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoHash<T> getSig() {
        return sig;
    }

    public void setSig(NodoHash<T> sig) {
        this.sig = sig;
    }
    
    
}
