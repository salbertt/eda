/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloomFilters;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/**
 *estructura de datos probabilistica
 * compacte (muchos datos, poco espacio)
 * rápido en buscar y en insertar
 * implementación: arreglo binario que indica si el dato está o no
 * posibilidad de usar funciones de hash para disminuir colisiones
 * problema: falsos positivos aprox  (1-e^(-kn/m))^k
 * mientras k sea mayor, más lento es el bloom filter pero menor es el margen de error
 * 
 * ejercicio: Haga un programa para determinar experimentalmente el tamaño mínimo m de un Bloom Filter, 
 * dado n, el número de elementos a almacenar
 * y f, un porcentaje de falsos positivos aceptable
 * @author sofal
 */
public class BloomSet <T extends Comparable <T>>{

	byte[] set;
	int keySize;
        int k; //funciones hash
	int setSize;
	int cont;

	MessageDigest m;

	/**
	 * @param size
	 *            the size(m) of the byte array backing the BloomSet
	 */
	public BloomSet(int size) {
		setSize = size;
		set = new byte[setSize];
		cont = 0;
                keySize = 100; 
		try {
			m = MessageDigest.getInstance("MD5");
		} 
                catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("MD5 Hash not found");
		}
	}

	private int getHash(int i) {
		m.reset();
		byte[] bytes = ByteBuffer.allocate(4).putInt(i).array();
		m.update(bytes, 0, bytes.length);
		return Math.abs(new BigInteger(1, m.digest()).intValue()) % (set.length - 1);
	}
	
	public boolean inserta(T elem) {
		int[] toSet = getSetArray(elem);

		for (int x : toSet)
			set[x] = 1;

		cont++;
		return true;
	}

	public boolean contains(Object obj) {
		int[] toSet = getSetArray(obj);

		for (int x : toSet)
			if (set[x] != 1)
				return false;

		return true;
	}

	private int[] getSetArray(Object obj) {
		int[] toSet = new int[keySize];

		toSet[0] = getHash(obj.hashCode());

		for (int i = 1; i < keySize; i++)
			toSet[i] = (getHash(toSet[i - 1]));

		return toSet;
	}
        
	public int getSize() {
		return cont;
	}

	public boolean isEmpty() {
		return cont < 1;
	}
        /*
        * falsos positivos aprox  (1-e^(-km/n))^k
        k funciones hash 
        m numero de elementos 
        n tamaño del arreglo
        */
        public double falsosPositivos(){
            double resp;
            resp = Math.pow((1 - Math.exp(-k * (double) cont / (double) setSize)), k);
            return resp;
        }
        
        

}
