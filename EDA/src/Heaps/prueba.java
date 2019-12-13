package Heaps;


import Heaps.heapArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sofal
 */
public class prueba <T> {

    /**
     * @param args the command line arguments
     */
    public static <T extends Comparable<T>> void mergeSort(T[] datos, int min, int max) {
        //vas comparando i con j y avanza el que fue menor. si se acaba alguno, copias todo lo que queda del otro
        T[] temp;
        int indice, izq, der;
        if (min == max) {
            return;
        } else {
            int tam = max - min + 1;
            int mitad = (max + min) / 2;
            izq = min;
            der = mitad + 1;
            temp = (T[]) (new Comparable[tam]);
            mergeSort(datos, min, mitad);
            mergeSort(datos, mitad + 1, max);

            for (int i = 0; i < tam; i++) {
                if (izq <= mitad && der <= max) {
                    if (datos[izq].compareTo(datos[der]) < 0) {
                        temp[i] = datos[izq++]; //escibirlo así hace que primero acceda al valor de izq, lo usa, y luego le suma 1. Para que sume 1 primero, se escribe como ++i
                    } else {
                        temp[i] = datos[der++];
                    }
                } else {
                    if (izq <= mitad) {
                        temp[i] = datos[izq++];
                    } else {
                        temp[i] = datos[der++];
                    }
                }

            }
        }
    }
    public static <T> void main(String[] args) {
        /*
        *pruebas previas para verificar las operaciones de heapArray
        String[] letras = {"a", "b","c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u","v","w","x","y","z"};
        heapArray h= new heapArray();        
        Integer[] nums = {50, 1, -5, 75, 50 , 25, 7000};
//        for(int i = 0; i<nums.length; i++)
//            h.inserta(nums[i]);
        
        for(int i = 0; i<letras.length; i++)
            h.inserta(letras[i]);                
        System.out.println(h.toString());
        System.out.println(h.getMin());
        h.eliminaMin();
        System.out.println(h.toString());
        T resp []  = (T[]) h.heapSort(letras);
        StringBuilder print = new StringBuilder();
        for(int i = 0; i<26; i++)
            print.append(resp[i] + " ");
        System.out.println(print.toString()); 
*/
        StringBuilder merge = new StringBuilder();
        StringBuilder heaps = new StringBuilder();
        for (int palabras = 1000; palabras <= 12000; palabras += 200) {
            heapArray h = new heapArray();
            Scanner sc = null;
            String[] lista = new String[120000], aux = new String[120000];
            int i = 0, numPalabras;
            boolean ban;
            double TInicio, TFin, tiempo;
            try {
                File ent = new File("D:\\Users\\sofal\\Documents\\palabras.txt");
                sc = new Scanner(new FileReader(ent));

            } catch (FileNotFoundException e) {
                System.out.println("Input file not found");
                System.exit(1);
            }
            while (i<12000&&sc.hasNext()) {
                String text = sc.nextLine().toLowerCase();
                ban = true;
                if (text != null){
                    lista[i] = text;
                    i++;
                }
            }
            numPalabras = i;

            for (int k = 0; k < i; k++) {
                aux[k] = lista[k];
            }
            TInicio = System.currentTimeMillis();
            h.heapSort(lista);
            TFin = System.currentTimeMillis();
            //System.out.println(Arrays.toString(res));
            tiempo = TFin - TInicio;
            //System.out.println("TRIE: tiempo en insertar y ordenar " + t.contador + " palabras: " + tiempo + "milisegundos");
            heaps.append(tiempo+ "\n");
            
            TInicio = System.currentTimeMillis();            
            mergeSort(aux, 0, palabras - 1);
            TFin = System.currentTimeMillis();
            tiempo = TFin - TInicio;
            //System.out.println("MERGE SORT: se acomodaron " + palabras + " en " + tiempo + " milisegundos");
            merge.append(tiempo + "\n");
            
        }
        System.out.println("HEAPS: " + heaps.toString());
        System.out.println("MERGE: " + merge.toString());

    }     
}
