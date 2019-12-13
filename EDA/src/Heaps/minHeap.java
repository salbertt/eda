/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Heaps;

/**
 *
 * @author computacion1
 */
public class minHeap <T extends Comparable<T>> implements minheapADT<T> {
    private NodoHeap<T>[] datos;
    private int cont;

    public minHeap() {
        cont = 0;
        datos = new NodoHeap[1000];
    }
    
    @Override
    public  void inserta(T elem) {
        int pos = cont + 1;
        NodoHeap<T> aux = new NodoHeap(elem);
        if (pos == 1) {
            datos[pos].setElem(elem);
            return;
        } else {
            if (pos > datos.length) {
                expande();
            }
            while (datos[pos / 2].getPrioridad().compareTo(aux.getPrioridad()) > 0) {
                datos[pos] = datos[pos / 2];
                datos[pos / 2].setElem(elem);
                pos = pos >> 1;
            }
        }
        cont++;
        
    }
    

    @Override
    public T getMin() {
        return (T)datos[1];
    }
    
    public Integer min(int papa){
        int pos1=papa<<1;
        int pos2 = pos1++;
        if(pos1>cont)
            return null;
        if(pos2>cont)
            return pos1;
        if(datos[pos1].getPrioridad().compareTo(datos[pos2].getPrioridad())<0)
            return pos1;
        return pos2;
    }

    @Override
    public T eliminaMin() {   
        NodoHeap<T> res = datos[1];
        boolean bandera =true;
        if(cont==0)
            return null;
        T elemento = (T) datos[1];
        Integer actual = min(1), papa = 1;
        while(actual!=null && bandera){
            if(datos[actual].getElem().compareTo(datos[papa].getPrioridad())<0){
                swap(actual, papa);
            }
            else
                bandera = false;
            papa = actual;
            actual=min(papa);
        }
        return elemento;
        
    }

    private void expande() {
        NodoHeap<T>[] aux = new NodoHeap[datos.length*2];
        datos = aux;
    }

    private void swap(Integer i, Integer j) {
        NodoHeap<T> aux = datos[i];
        datos[i] = datos[j];
        datos[j] = aux;
    }
    
}
