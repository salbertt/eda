/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

/**
 *
 * @author hca
 */
public class BST <T extends Comparable <T>> extends LinkedBT<T> implements BSTADT <T> {
    NodoBT<T> raiz;
    int cont=0;
     /* incersión: recorrer el arbol viendo si es mayor o menor al calor del actual e insertar como hoja. 
     */
    @Override
    public void add(T elem){ //manera iterativa
        cont++;
        if(raiz==null){
            raiz = new NodoBT(elem);
            return;
        }
            
            NodoBT<T> papa = null;
            NodoBT<T> aux = raiz;
            
            while(aux!=null){
                papa= aux;
                if(elem.compareTo(aux.getElement())>=0)
                    aux = aux.getDer();
                else
                    aux= aux.getIzq();            
        }//while
            aux = new NodoBT(elem);
            papa.cuelga(aux);
    }
    /**
    public void addRecursivo(T elem){
        if(elem!=null)
    }
    
     add(NodoBT)
                if(actual.getElement().compareTo(elem)>0){
                    if(actual.getIzq()!=null)
                        add(actual.getIzq(), elem);
                    
                }
                else{
                    actual.setIzq(elem);
                    actual.getIzq.setPapa(actual.getPapa());
                }}
    else{
    if(actual.getDer()!=nukll)
        add(actual.getDer()); elem;
        else{
    actual.setDer(elem)
            actual-getDer.SetPapa(acutal.getPapa())
                }
    }
    * *
     */
        
//    public void add(T elem) {
//        if(elem!=null){
//            cont++;
//            if(raiz==null)
//                raiz.setElement(elem);
//            else{
//                NodoBT<T> aux = raiz;
//                add(aux, elem);
//            }
//        }
//    }
//    
//    private void add(NodoBT<T> aux, T elem) { //problema con saber quién es el padre
//        if(aux.getElement()==null){
//            aux.setElement(elem);
//        }
//        else{
//            if((aux.getElement()).compareTo(elem)<0){ // aux es menor
//                aux = aux.getIzq();
//                add(aux, elem);
//            }
//            else{
//                aux=aux.getDer();
//                add(aux, elem);
//            }
//        }
//    }

    @Override
    public boolean remove(T elem) { //falta actualizar el apuntador al papá
        NodoBT<T> borrar = busca(raiz, elem);
        if (borrar != null) {
            if (borrar.getDer() == null && borrar.getIzq() == null) { //caso 1: es una hoja
                if (borrar == raiz) { // la jhoja es la raíz
                    raiz = null;
                } else {
                    if (borrar.getPapa().getDer()==(borrar)) {
                        borrar.getPapa().setDer(null);
                    } else {
                        borrar.getPapa().setIzq(null);
                    }
                }
            } else {
                if (borrar.getIzq()==null){ //caso 2: solo tiene hijo derecho
                    if(borrar==raiz){
                        raiz = borrar.getDer();
                        raiz.setPapa(null);
                    }
                    else
                        borrar.getPapa().cuelga(borrar.getDer());
                }
                else{
                    if(borrar.getDer()==null){ //caso 2: solo tiene hijo izquierdo
                        if(borrar==raiz){
                            raiz = borrar.getIzq();
                            raiz.setPapa(null);
                        }
                    else
                        borrar.getPapa().cuelga(borrar.getIzq());
                    }
                    else{ //caso 3: tiene dos hijos
                        /**
                         * encontrar el sucesor inorden y ponerlo en donde esta el que quieres borrar
                         * eliminar ese nodo pero antes hacer cuelga
                         */
                        NodoBT<T> suc = borrar.getDer();
                        while(suc.getIzq()!=null)
                            suc = suc.getIzq();
                        borrar.setElement(suc.getElement());
                        if(suc==borrar.getDer())
                            borrar.setDer(suc.getDer());
                        else
                            suc.getPapa().setIzq(suc.getDer());
                        
                    }
                }
                    
            }
            cont--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T removeMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMin() {
        throw new UnsupportedOperationException("si me embarazo se  lo doy a mis papas, yeeey no hay problema ;)"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMax() {
        throw new UnsupportedOperationException("jorge es .03 genial"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMax() {
        throw new UnsupportedOperationException("ola "); //To change body of generated methods, choose Tools | Templates.j
    }
    
    private NodoBT<T> busca(NodoBT<T> actual, T elem){ //iterativo
        boolean encontre = false;
        while(!encontre && actual!=null){
            if(elem.compareTo(actual.getElement())<0)
                actual = actual.getIzq();
            else{
                if(elem.compareTo(actual.getElement())>0)
                    actual = actual.getDer();
                else
                    encontre = true;
            }
        }
        return actual;
            
    }

    
}
