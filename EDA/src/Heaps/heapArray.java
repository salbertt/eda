package Heaps;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Heaps
 * árboles binarios, todos sus niveles están llenos excepto, posiblemente, el úñtimo
 * todas las hojas recargadas hacia la izquierda
 * cada nodo es menor o igual a su hijo
 * @author sofal
 */
public class heapArray <T extends Comparable<T>>{
    private T[] heap;
    private int cont, max;
    private boolean fijo;

    public heapArray() {
        heap = (T[]) (new Comparable[100]);
        cont = 0;
        max = 100;
        fijo = false;
        for(int i = 0; i<max; i++)
            heap[i] = null;
    }

    public heapArray(int max) {
        cont = 0;
        this.max = max;
        heap = (T[]) new Comparable[max+1];
        int cont = 0;
        fijo = true;
        for(int i = 0; i<max; i++)
            heap[i] = null;
    }
    //métodos para acceder a información del "nodo" heap
    public T getPapa(int pos){
        return heap[pos/2];
    }
    public T getIzq(int pos){
        if(cont>=pos*2)
            return heap[pos*2];
        else
            return null;
    }
    public T getDer(int pos){
        if(cont >= pos *2 +1)
            return heap[pos*2 +1];
        else
            return null;
    }
    //operaciones del heap
    public boolean inserta(T elem){
        boolean resp = false;
        if(elem!=null){
            if(fijo && cont<max || !fijo){
                resp = true;
                if(cont==max){
                    T[] aux;
                    aux = (T[]) new Object[max*2+1];
                    for(int i = 0; i<max; i++)
                        aux[i] = heap[i];
                    heap = aux;
                    max = max*2;
                } //expandir
                    cont++;
                    heap[cont] = elem; 
                    //acomodamos con bubble sort
                    int k = cont;                   
                    while(getPapa(k)!=null&&heap[k].compareTo(getPapa(k)) < 0) {
                        swap(k, k/2);
                        k = k/2;
                    }
                }//cabe
            }//no nulo
            return resp;
        }//inserta
    private void swap(int pos, int cambio) {
        T aux = heap[pos];
        heap[pos] = heap[cambio];
        heap[cambio] = aux;
    }
    public T getMin(){
        return heap[1];
    }
    public T eliminaMin(){
        T resp = heap[1];
        heap[1]= heap[cont];
        heap[cont] = null;
        cont--;
        //re-ordenar el arreglo
        reordena(1);
        return resp;
    }
    /*
    *String preorden
    */
    public String toString(){
        StringBuilder resp = new StringBuilder();
        for(int i = 0; i<cont; i++)
            resp.append(heap[i+1].toString() + "\t");
        return resp.toString();
    }
/**
 * @param pos 
 */
    private void reordena(int pos) {
        if(pos<cont){
            if (heap[pos] != null && !esHoja(pos)) {
                //checar cuál de sus hijos es menor y cambiarlo con ese
                if(getIzq(pos)!=null && getDer(pos)!=null){
                    if(getIzq(pos).compareTo(getDer(pos))<0){ //der es mayor entonces intercambiamos con izq
                        if(heap[pos].compareTo(getIzq(pos))>0){
                            swap(pos, pos*2);
                            reordena(pos*2);
                        }
                    }
                    else{ //izq es mayor entonces intercambiamos con der
                        if(heap[pos].compareTo(getDer(pos))>0){
                            swap(pos, pos*2+1);
                            reordena(pos*2+1);
                        }
                    }
                }
                else{ //solo tiene 1 hijo
                    if(getDer(pos)!=null && heap[pos].compareTo(getDer(pos))>0){ //hijo der
                        swap(pos, pos*2+1);
                        reordena(pos*2+1);
                    }
                    else{
                        if(heap[pos].compareTo(getIzq(pos))>0){ //hijo izq
                        swap(pos, pos*2);
                        reordena(pos*2);
                        }
                    }
                }
            }
        }
    }
    private boolean esHoja(int pos) {
        if(getDer(pos)!=null || getIzq(pos)!=null)
            return false;
        else
            return true;
    }
    
    /**
     * Implementar el heap-sort (insertar n datos a ordenar y luego ejecutar n borra min
     */
    public T[] heapSort(T[] datos){
        heapArray h =new heapArray(datos.length);
        T[] resp = (T[]) new Comparable[datos.length];
        int i = 0;
        while(i<datos.length && datos[i]!=null){
            h.inserta(datos[i]);
            i++;
        }
        int n = h.cont;
        for(int k = 0; k<n; k++)
            resp[k] = (T) h.eliminaMin();
        return resp;
    }
}
