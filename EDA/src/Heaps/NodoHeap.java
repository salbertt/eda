/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Heaps;

/**
 *
 * @author computacion1
 */
public class NodoHeap<T extends Comparable <T>> {
    private T elem;
    private Comparable key;
    private Integer prioridad;

    public NodoHeap(T elem, Integer prioridad) {
        this.elem = elem;
        this.prioridad = prioridad;
        key = prioridad;
    }

    public NodoHeap(T elem, Comparable key, int prioridad) {
        this.elem = elem;
        this.key = key;
        this.prioridad = prioridad;
    }

    public NodoHeap(T elem) {
        this.elem = elem;
        
    }

    public NodoHeap(Object elem) {
        this.elem = (T) elem;
    }

    public T getElem() {
        return elem;
    }

    public Comparable getKey() {
        return key;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }
    public T getPrioridad(){
        if(prioridad!=null)
            return (T)prioridad;
        if(key!=null)
            return (T)key;
        return elem;
    }
}
