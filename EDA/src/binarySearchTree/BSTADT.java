/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

/**
 *
 * @author hca
 */
public interface BSTADT <T> extends BinaryTreeADT<T> {
    public void add(T elem);
    public boolean remove (T elem);
    public T removeMin();
    public T findMin();
    public T removeMax();
    public T findMax();
}
