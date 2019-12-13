
package binarySearchTree;

import java.util.Iterator;

public class LinkedBT <T> implements BinaryTreeADT<T>{
    private NodoBT raiz;
    private int cont;

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T find(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> inorden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> preorden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> postorden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


/**
 * private NodoBT<T> raiz;
    private int cont;
   
    public int size() {
        return cont;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T find(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   public Iterator<T> imorden() {
        ArrayList<T> lista =new ArrayList<T>();
        imorden(raiz, lista);
        return lista. iterator();
       
    }
    private void imorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        imorden(actual.getIzq(),lista);
        imorden(actual.getDer(),lista);
        lista.add(actual.getElement());
    }  
    public Iterator<T> preorden() {
        ArrayList<T> lista =new ArrayList<T>();
        preorden(raiz, lista);
        return lista. iterator();
       
    }
    private void preorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        lista.add(actual.getElement());
        preorden(actual.getIzq(),lista);
        preorden(actual.getDer(),lista);
    }
     public Iterator<T> postorden() {
        ArrayList<T> lista =new ArrayList<T>();
        postorden(raiz, lista);
        return lista. iterator();
       
    }
    private void postorden(NodoBT<T> actual, ArrayList<T> lista){
        if (actual==null)
            return;
        postorden(actual.getIzq(),lista);
        postorden(actual.getDer(),lista);
        lista.add(actual.getElement());
    }
    public Iterator<T> preorden2() {
        Stack<NodoBT<T>> pila =new Stack();
        ArrayList<T> lista =new ArrayList<T>();
        pila.push(raiz);
        
        while(!pila.isEmpty()){
            NodoBT<T> actual= pila.pop();
            lista.add(actual.getElement());
            if(actual.getDer()!=null)
                pila.add(actual.getDer());
            if(actual.getIzq()!=null)
                pila.add(actual.getIzq());
        }
        return lista.iterator();
        
       
    }
  //cambio por colas para tenerlo por niveles
    
   
    public int altura() {
        return altura(raiz, 0, 0); 
       
    }
    private int altura(NodoBT<T> actual, int res, int max){
        if (actual==null){
            if(res>max)
                return res;
        }
        else{
            if(altura(actual.getIzq(),res+1, max)>altura(actual.getDer(),res+1, max ))
                return altura(actual.getIzq(),res+1, max);
            else
                return altura(actual.getDer(),res+1, max );
                
            
        }
        
    }
 */
