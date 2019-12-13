/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author hca
 */
public class algoritmoOrdenamiento <T extends Comparable <T>> {
    
    public T[] selectionSort(T[] arr){
        T min, aux;
        int pos;
        int j = 0;
        for(int i = 1; i < arr.length; i++){
            min = arr[i];
            pos = i;
            for(j=i+1; j<arr.length;j++){
                if(arr[j].compareTo(min)<0){
                    min = arr[j];
                    pos = j;
                }
            }
            recorre(min, pos, arr, i, j);
        }
        return arr;
    }

    private void recorre(T min, int pos, T[] arr, int i , int j) {
        
    }
//    public T[] insertionSort(T[] arr){
//        T[] nuevo;
//        T min;
//        int j;
//        nuevo = (T[]) new Object[arr.length];
//        nuevo[0] = arr[0];
//        nuevo[1] = arr[1];
//        for(int i = 1; i<arr.length; i++){
//            min = arr[i-1];
//            j = 2;
//            if(arr[i].compareTo(min)<0){
//                while(arr[i].compareTo(arr[i-j])<0)
//                    j++;
//            }
//            T aux = arr[j];
//            
//            
//        }
//        return null;
//        
//    }   
    public T[] insertionSort(T[] arr){
        for(int i = 0; i<arr.length-1; i++){
            int rec = i, pos = i+1;
            T obj;
            while(rec>=0&&arr[rec].compareTo(arr[pos])>0){
                obj = arr[rec];
                arr[rec]= arr[pos];
                arr[pos] = obj;
                rec--;
            }  
        }
        return arr;
    }
    
    public void bubbleSort(T[] arr){
        T aux;
        for(int i = 0; i<arr.length-1; i++){
            for(int j = 0; j<arr.length-1-i;j++){
                if(arr[j].compareTo(arr[j+1])>0){
                    aux = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }
    
    public void bubble(T[] arr){
        T aux; 
        boolean flag = false;
        while(!flag){
            flag=true;
            for(int i = 0; i<arr.length-1; i++){
                if((arr[i].compareTo(arr[i+1]))>0){
                    flag = false;
                    aux = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]=aux;
                }
            }
        }
    }
    
    public void quickSort(T[]arr, int min, int max){
        int indice;
        if(max-min<=0)
            return;
        indice = encuentraPatron(arr, min, max);
        quickSort(arr, min,indice-1);
        quickSort(arr, indice+1, max);
        
    }
    
    public void mergeSort(T[] datos, int min, int max){ //LAS DOS MITADES YA ESTAN ORDENADAS
        //vas comparando i con j y avanza el que fue menor. si se acaba alguno, copias todo lo que queda del otro
        T[] temp;
        int indice, izq, der;
        if(min==max)
            return;
        
        int tam = max-min + 1;
        int mitad = (max + min)/2;
        izq = min;
        der = mitad+1;
        temp=( T[])(new Comparable[tam]);
        mergeSort(datos, min, mitad);
        mergeSort(datos, mitad+1, max);
       
        for(int i = 0; i<tam;i++){
            if(izq<= mitad && der <= max){
                if(datos[izq].compareTo(datos[der])<0)
                    temp[i]= datos[izq++]; //escibirlo así hace que primero acceda al valor de izq, lo usa, y luego le suma 1. Para que sume 1 primero, se escribe como ++i
                else
                    temp[i]=datos[der++];
            }
            else{
                if(izq<=mitad)
                    temp[i]=datos[izq++];
                else
                    temp[i] = datos[der++];
            }
                    
        }
        
        
    }
   
    public static void main(String[] args) {
       
    }
   
    //ANDREA. tiene algo mal en el contador o pivote
//    private void quickSort1(T[]arr, int pivote, int cont){
//        if(arr.length-1-cont == pivote)
//            return;
//        else{
//            if(arr[pivote+1].compareTo(arr[pivote])<0){
//                T val = arr[pivote];
//                arr[pivote] = arr[pivote+1];
//                arr[pivote+1]=val;
//                pivote++;
//            }
//            else{
//                T val = arr[arr.length-1];
//                arr[arr.length-1]= arr[pivote+1];
//                arr[pivote+1]=val;
//                cont++;
//            }
//            quickSort1(arr, pivote, cont);
//        }
//    }

//    private T[] encuentraPatron(T[] arr, int min, int max) { DIANA
//        if(min<max){
//            int iBase=min;
//            T base = arr[min];
//            T aux;
//            for(int i = min+1; i<=max;i++){
//                if((arr[i].compareTo(base))<0){
//                    aux = arr[iBase+1];
//                    arr[iBase] = arr[i];
//                    arr[i]= aux;
//                    arr[iBase+1]=base;
//                    iBase++;
//                }
//            }
//            arr=encuentraPatron(arr, min, iBase-1);
//            arr= encuentraPatron(arr, iBase+1, max);
//        }
//        return arr;
//            
//    }

    private int encuentraPatron(T[] arr, int min, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
