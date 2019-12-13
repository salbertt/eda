/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *tablas de hash se pueden usar para cookies, para saber si algo está o no, para contraseñas
 * para diccionarios
 * @author hca
 */
public class Hash <T>{
    private NodoHash<T>[] tabla;

    public Hash( int num) {
        tabla = (NodoHash<T>[])new NodoHash[num];
    }
    
    
 /**
  * inserta un elemento en la tabla en la posición que la función hash indique
  * @param elem elemento a insertar
  */
    public void insertar( T elem){
        if(elem!=null && !buscar(elem)){
          int key = hashFunction(elem);  
          NodoHash<T> newNode = new NodoHash<T>(elem);
          if(tabla[key]==null)
              tabla[key]=newNode;
          else{
              //if(!buscar(elem){ //hay que decidir si queremos o no aceptar elementos repetidos
              newNode.setSig(tabla[key]);
              tabla[key] = newNode;
          }
        }        
    }
    public void expande(){
        NodoHash <T> [] arreglo = new NodoHash [tabla.length*2];
        NodoHash <T> [] aux = tabla;
        tabla = arreglo;
        for(int i = 0; i< tabla.length; i++){
            NodoHash<T> actual = aux[i];
            while(actual!=null){
                insertar(actual.getElemento());
                actual = actual.getSig();
            }
        }
    }
//    public boolean buscar(T elem){
//        if(elem!=null){
//            int key = hashFunction(elem);
//            if(tabla[key]==null)
//                return false;
//            else
//                //buscar si está en la lista ligada
//        }
//        else
//            return false;
//    }
    public void eliminar(T elem){
        if(elem!=null && buscar(elem)){
            int key = hashFunction(elem);
            NodoHash<T> aux = tabla[key];
            if(aux.getElemento().equals(elem)){ //era el primero 
                tabla[key] = aux.getSig();
                aux.setSig(null);
            }
            else{ //hay que buscar en dónde está
                aux = aux.getSig();
                int i = 1;
                while(!aux.getElemento().equals(elem)){
                    aux = aux.getSig();
                    i++;
                }
                tabla[key+i] = aux.getSig();
                aux.setSig(null);
            }
            
        }
    }
    private int hashFunction(T elem){
        if(elem!=null){
           return (Integer)elem%elem.toString().length();  
        }
        else
            return -1;
    }

    private boolean buscar(T elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}