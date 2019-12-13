/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolAVL;

/**
 *
 * @author hca
 */
public class NodoAVL <T extends Comparable<T>> {
    private T element;
    private NodoAVL<T> izq, der, papa;
    private int fe;
    NodoAVL(T elem){
        element = elem;
        izq = null;
        der = null;
        papa = null;
        fe = 0;
    }
    
   
    public T getElement() {
        return element;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }
    
    public void calculaFe(){
        fe= getAltura(der)-getAltura(izq);
    }
    
    public NodoAVL<T> getIzq() {
        return izq;
    }
    public NodoAVL<T> getDer() {
        return der;
    }
    public void setElement(T element) {
        this.element = element;
    }
    public void setPapa(NodoAVL<T> papa){
        this.papa= papa;
    }

    public NodoAVL<T> getPapa() {
        return papa;
    }
    
    public void setIzq(NodoAVL<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoAVL<T> der) {
        this.der = der;
    }    
    /*
     * para direccionarlo a su papá
     */
    public void cuelga(NodoAVL<T> n){
        if(n!=null){
            if(n.getElement().compareTo(element)<0)
                izq = n;
            else
                der = n;
            n.setPapa(this);
        }
        
    }

    private int getAltura(NodoAVL<T> actual) {
        if(actual == null)
            return 0;
        else
            return Math.max(hijosIzq(), hijosDer());
    }
    private int hijosIzq(){
        int resp = 0;
        if(izq !=null){
            resp = 1 + izq.hijosIzq();
        }
        return resp;
    }
    private int hijosDer(){
        int resp = 0;
        if(der !=null){
            resp = 1 + der.hijosDer();
        }
        return resp;
    }
    
    
}
