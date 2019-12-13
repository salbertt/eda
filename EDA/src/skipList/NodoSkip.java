/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skipList;

/**
 *
 * @author hca
 */
public class NodoSkip <T>{

    NodoSkip<T> izq;
    NodoSkip<T> der, arriba, abajo;
    T elem;

    public NodoSkip() {
    }

    public NodoSkip(T elem) {
        this.elem = elem;
    }

    public NodoSkip<T> getIzq() {
        return izq;
    }

    public void setIzq(NodoSkip<T> izq) {
        this.izq = izq;
    }

    public NodoSkip<T> getDer() {
        return der;
    }

    public void setDer(NodoSkip<T> der) {
        this.der = der;
    }

    public NodoSkip<T> getArriba() {
        return arriba;
    }

    public void setArriba(NodoSkip<T> arriba) {
        this.arriba = arriba;
    }

    public NodoSkip<T> getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoSkip<T> abajo) {
        this.abajo = abajo;
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }
    
    
}
