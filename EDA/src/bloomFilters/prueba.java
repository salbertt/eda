/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomFilters;



/**
 *
 * @author sofal
 */
public class prueba {

    /**
     *ejercicio: Haga un programa para determinar experimentalmente el tamaño mínimo m de un Bloom Filter, 
      dado n, el número de elementos a almacenar
      y f, un porcentaje de falsos positivos aceptable
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        int tamañoMin = 1;
        StringBuilder resp = new StringBuilder();
        BloomSet<String> bloom;
        boolean ban =true;
        int i=1;
        int f; 
        int n = 5;
            for(f = 90; f>=5; f = f-5){
                while(ban){
                    i++;
                    bloom= new BloomSet<>(n+i);
                    ban= bloom.falsosPositivos()>=f;
                }
            resp.append(n + "\t" +(n+i) +"\t" + f +" \n");
            }        
        System.out.println(resp.toString());
    }

}

    

