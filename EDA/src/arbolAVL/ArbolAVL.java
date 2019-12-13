package arbolAVL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ArbolAVL <T extends Comparable <T>>{
    NodoAVL<T> raiz, papa;
    int cont=0;

    public ArbolAVL() {
        raiz = null;
        papa = null;
        cont = 0;
    }

    public void inserta (T elem){
        cont++;
        
        NodoAVL<T> actual = new NodoAVL(elem), temp = null;
        if(raiz==null)
            raiz = actual;
        else{ //hay que recorrer el arbol y ver dónde insertarlo
            NodoAVL<T> aux = raiz;
            while(aux!=null){
                temp = aux;
                if(elem.compareTo(aux.getElement())<0){ 
                    aux = aux.getIzq();
                }
                else
                    aux = aux.getDer();
            }
            temp.cuelga(actual);
            actual.setPapa(actual);
            
            //ahora hay que actualizar el factor de equilibrio
            if(temp.getDer()==actual)
                actualizaFeInserta(temp, 1);
            else
                actualizaFeInserta(temp, -1);
            
        }
    }
    /**
     * 
     * @param actual
     * Recibe el nodo con fe = 2 y regresa la nueva raiz de ese subarbol
     * entonces, en insertar, dices  raiz = rotacion(actual) donde actual es 
     * lo que factor equilibrio regresa (el primer nodo con fe ==2
     * @return 
     */
    private NodoAVL<T> rotacion(NodoAVL<T> actual) { // analizar lo que hay en la clase arbol avl
        NodoAVL<T> alfa, beta, gamma, A, B, C, D, papa;
        if(actual!=null){
            //iz-izq
            if(actual.getFe() ==-2 &&(actual.getIzq()!=null && actual.getIzq().getFe()<=0)){
                System.out.println("izq izq");
                alfa = actual;
                papa = actual.getPapa();
                beta = alfa.getIzq();
                gamma = beta.getIzq();
                A = gamma.getIzq();
                B = gamma.getDer();
                C= beta.getDer();
                D = alfa.getDer();

                gamma.cuelga(A);
                gamma.cuelga(B);
                alfa.cuelga(C);
                alfa.cuelga(D);
                beta.cuelga(alfa);
                beta.cuelga(gamma);

                if(papa!=null){
                    papa.cuelga(beta);
                }
                else{
                    beta.setPapa(null);
                    raiz = beta;
                }
                alfa.calculaFe();
                beta.calculaFe();
                gamma.calculaFe();
                return beta;
            }
            //der-der
            if(actual.getFe()==2 &&(actual.getDer()!=null && actual.getDer().getFe()>=0)){
                System.out.println("der der");
                alfa = actual;
                beta = alfa.getDer();
                gamma = beta.getDer();
                papa = actual.getPapa();
                A=alfa.getIzq();
                B = beta.getIzq();
                C = gamma.getDer();
                D=gamma.getIzq();

                alfa.cuelga(A);
                alfa.cuelga(B);
                beta.cuelga(alfa);
                beta.cuelga(gamma);
                gamma.cuelga(C);
                gamma.cuelga(D);

                if(papa!=null)
                    papa.cuelga(beta);
                else{
                    beta.setPapa(null);
                    raiz = beta;
                }
                alfa.calculaFe();
                beta.calculaFe();
                gamma.calculaFe();
                return beta;
            }
            //izq-der
            if(actual.getFe()==-2&&(actual.getIzq()!=null && actual.getIzq().getFe()==1)){
                System.out.println("izq der");
                alfa = actual;
                beta = alfa.getIzq();
                gamma = beta.getDer();
                papa=alfa.getPapa();
                A = beta.getIzq();
                B= gamma.getIzq();
                C=gamma.getDer();
                D = alfa.getDer();

                beta.cuelga(A);
                beta.cuelga(B);
                alfa.cuelga(C);
                alfa.cuelga(D);
                gamma.cuelga(alfa);
                gamma.cuelga(beta);

                if(papa!=null)
                    papa.cuelga(gamma);
                else{
                    gamma.setPapa(null);
                    raiz = gamma;
                }
                alfa.calculaFe();
                beta.calculaFe();
                gamma.calculaFe();
                return gamma;
            }
            //der-izq
            if(actual.getFe()==2&&(actual.getDer()!=null && actual.getDer().getFe()==-1)){
                System.out.println("der izq");
                alfa= actual;
                beta = alfa.getDer();
                gamma=beta.getIzq();
                papa = alfa.getPapa();
                A=alfa.getIzq();
                B=gamma.getIzq();
                C = gamma.getDer();
                D = beta.getDer();

                gamma.cuelga(alfa);
                gamma.cuelga(beta);
                alfa.cuelga(A);
                alfa.cuelga(B);
                beta.cuelga(C);
                beta.cuelga(D);

                if(papa!=null)
                    papa.cuelga(gamma);
                else{
                    gamma.setPapa(null);
                    raiz= gamma;
                }
                alfa.calculaFe();
                beta.calculaFe();
                gamma.calculaFe();
                return gamma;
            }
        }
        return null;
        
    }
    
    public boolean borrar(T elem){ 
        NodoAVL<T> actual = new NodoAVL(elem);
        actual = busca(actual);
        
        if(actual==null)
            return false;
        
        NodoAVL<T> papa = actual.getPapa();
        cont--;
        
        if(actual.getDer()!=null && actual.getIzq()!=null){//tiene dos hijos
           //encontrar sucesor inorden para ponerlo en la pos de actual
            NodoAVL<T> aux = actual.getDer();
            while(aux.getIzq()!=null)
                aux=aux.getIzq();
            actual.setElement(aux.getElement());
            if(aux==actual.getDer()){
                actual.setDer(aux.getDer());
                actualizaFe(actual, -1);
            }
            else{
                aux.getPapa().setIzq(aux.getDer());
                actualizaFe(actual, 1);
            }
            
            aux.setPapa(null);
            aux.setIzq(null);
            aux.setDer(null);
            
            
        }
        else{
            if(actual.getDer()==null && actual.getIzq()==null){ //es una hoja. solo la borramos
                if(actual==raiz)
                    raiz=null;
                else{
                    actual.setElement(null);
                    actual.setPapa(null);
                    if(papa.getDer().getElement().equals(elem)){ 
                        papa.setDer(null);
                        actualizaFe(papa, -1);
                    }
                    else{
                        papa.setIzq(null);
                        actualizaFe(papa, 1);
                    }
                }
            }
            else{ //solo tiene 1 hijo. lo pasamos al papá
               
                actual.setElement(null);
                
                if(actual.getDer()!=null){ //hijo derecho (factor de equilibrio -1)
                    if(actual==raiz){
                        raiz = actual.getDer();
                        raiz.setPapa(null);
                    }
                    else{
                        papa.cuelga(actual.getDer());
                        actualizaFe(papa,-1);
                    }
                    actual.setDer(null);
                }
                
                else{ //hijo izquierdo (factor de equilibrio +1)
                    if(actual==raiz){
                        raiz = actual.getDer();
                        raiz.setPapa(null);
                    }
                    else{
                        papa.cuelga(actual.getIzq());
                        actualizaFe(papa, 1);
                    }
                    actual.setIzq(null);
                }
                actual.setPapa(null);
            }
        }
        
        return true;
    }
    /**
     * 
     * @param nodo desde donde hay que empezar a viajar a la raíz checando el factor de equilibrio
     * @param nuevoFe dice si se borró el hijo izq (1) o der (-1)
     */
   private void actualizaFe(NodoAVL<T> nodo, int nuevoFe){
       boolean termine = false;
       while(nodo!=null && !termine){
           nodo.setFe(nodo.getFe()+nuevoFe);
           if(Math.abs(nodo.getFe())==1) //saliste del 0 entonces ya acabaste
               termine = true;
           else{
              if(Math.abs(nodo.getFe())==2){ //cuando rotas ya acabaste
                  nodo = rotacion(nodo);
                  termine = true;
              }
              else{ //significa que tengo que seguir viajando hacia la raíz
                  if(nodo.getElement().compareTo(nodo.getPapa().getElement())<0) //o sea, nodo es el hijo izq y fe +1
                      nuevoFe = 1;
                  else
                      nuevoFe = -1;
                  nodo = nodo.getPapa();
              }
           }
       }
   }
   private NodoAVL<T> busca(NodoAVL<T> actual){ //iterativo
        boolean encontre = false;
        T elem=actual.getElement();
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
    
   public String toString(){
       if(raiz!=null){
           StringBuilder sb;
           sb= new StringBuilder();
           ArrayList<String> resp = new ArrayList();
           resp = agregaLista(resp);
           int i = 0;
           while(i < resp.size())
               sb.append(resp.get(i));
           return sb.toString();
       }
       else
           return "";
   }



    private void actualizaFeInserta(NodoAVL<T> nodo, int i) {
        boolean termine = false;
       while(nodo!=null && !termine &&nodo.getPapa()!=null){
           nodo.setFe(nodo.getFe()+i);
           if(nodo.getFe()==0) //entras del 0 entonces ya acabaste
               termine = true;
           else{
              if(Math.abs(nodo.getFe())==2){ //cuando rotas ya acabaste
                  nodo = rotacion(nodo);
                  termine = true;
              }
              else{ //significa que tengo que seguir viajando hacia la raíz
                  if(nodo.getElement().compareTo(nodo.getPapa().getElement())<0) 
                      i = -1;
                  else
                      i = 1;
                  nodo = nodo.getPapa();
              }
           }
       }
    }

    private ArrayList<String> agregaLista(ArrayList<String> resp) {
        ArrayList<NodoAVL<T>> listaNodo = new ArrayList<>();
        NodoAVL<T> aux = raiz;
        listaNodo.add(aux);
        int i = 0;
        while(!listaNodo.isEmpty()){
            aux = listaNodo.remove(0);            
            System.out.println(aux.getElement().toString());
            resp.add("Dato: " + aux.getElement() + " factor de equilibrio: " + aux.getFe() + "\n");
            if(aux.getIzq()!=null)
                listaNodo.add(aux.getIzq());
            if(aux.getDer()!=null)
                listaNodo.add(aux.getDer());
            System.out.println("aux: " + aux.getElement());
        }
        return resp;

    }

    

    


 
}
