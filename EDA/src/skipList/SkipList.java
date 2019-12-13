package skipList;
//import.java.flipcoin;
/**
 *
 * @author hca
 */
public class SkipList <T extends Comparable <T>>  {
    NodoSkip<T> cabeza, cola;
    int cont, numListas;

    public SkipList() {
        cont = 0;
    }

    public void Insertar(T elem){
        if(elem!=null){
            int numVolados = 1;
            NodoSkip <T> nuevo = new NodoSkip(elem);
            NodoSkip<T> actual = busca(elem);
            NodoSkip<T> nuevo2;
            boolean termine = false;
            cont++;
            do{
                meteNodo(actual, nuevo);
                if(numVolados<Math.log(cont+2)/Math.log(2) && Math.random()>0.5){
                    nuevo2 = nuevo;
                    if(numVolados>numListas){
                        nuevo = new NodoSkip(null);
                        nuevo.setAbajo(cabeza);
                        cabeza.setArriba(nuevo);
                        cabeza = nuevo;
                        nuevo = new NodoSkip(null);
                        nuevo.setAbajo(cola);
                        cola.setArriba(nuevo);
                        cola = nuevo;
                        cabeza.setDer(cola);
                        cola.setIzq(cabeza);
                        numListas++;
                    }
                    numVolados ++;
                    nuevo = new NodoSkip(elem);
                    nuevo2.setArriba(nuevo);
                    nuevo.setAbajo(nuevo2);
                    while(actual.getArriba()==null)
                        actual = actual.getIzq();
                    actual = actual.getArriba();
                }
                else
                    termine = true;
            }while(!termine);
        }
    }   
    private NodoSkip<T> busca(T elem){
        NodoSkip<T> aux = cabeza.getDer();
        int i = 1;
        while(i<=numListas){
            while(aux.getElem()!=null&&elem.compareTo(aux.getElem())<0){
                aux = aux.getDer();
            }
            if(i!=numListas){
                aux = aux.getIzq();
                aux = aux.getAbajo();
            }
            else{
                aux = aux.getIzq();
            }
            if(aux.getElem().equals(elem))
                i++;
        }
        return aux;
    }
    private NodoSkip<T> buscar(T elem){
        NodoSkip<T> actual = cabeza.getDer();
        int i = 1;
        while(i<=numListas){
            while(actual.elem!=null && elem.compareTo(actual.getElem())<0){
                actual = actual.getDer();
                if(i!=numListas){
                    if(actual.getElem().equals(elem))
                        actual = actual.getAbajo();
                    else{
                        actual = actual.getIzq();
                        actual = actual.getAbajo();
                    }
                }else{
                    if(!actual.getElem().equals(elem)){
                        actual = actual.getIzq();
                    }
                    i++;
                }
            }
        }
        return actual;
    }

    private void meteNodo(NodoSkip<T> actual, NodoSkip<T> nuevo) {
        nuevo.setIzq(actual);
        nuevo.setDer(actual.getDer());
        actual.setDer(nuevo);
        nuevo.getDer().setIzq(nuevo);
    }
    
}