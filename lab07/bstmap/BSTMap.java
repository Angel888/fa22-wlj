package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    BSTMap() {
//     BSTMap(K extends Comparable<K>, V){  //todo 为啥构造函数不能这么写？


    }

    int size = 0;
    BST root; //todo 怎样初始化吗？树和map的关系没有理清，应该是每个map都是一个树，只是多了value

    /**
     *
     */
    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(K key) {
        if ((key.compareTo((K) this.root. key) > 0) && this.root.left != null) {
            this.containsKey((K) this.root.left. key);
        } else if (key.compareTo((K) this.root. key) < 0 && this.root.right != null) {
            this.containsKey((K) this.root.right. key);
        } else {
            return true;
        }
        // todo 这里还需要定义成K吗？我不是在BST定义的时候已经写成泛型K了吗？
        return false;
    }

    /**
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
//        if (root == null) {
        return null;
//        }
//        ULLMap.Entry lookup = this.get(key);  //todo map的get 方法还需要定义吗？？这么底层的方法不会写
//        if (lookup == null) {
//            return null;
//        }
//        return lookup.val;
    }

    /**
     * @return
     */
    @Override
    public int size() {

        return size; //todo size是在哪加的？
    }


    /**
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new BST(null, null, key,value);
        } else {
            this.root.insert(root,key,value);
        }
    }

    /**
     * @return
     */
    @Override
    public Set<K> keySet() {
        throw  new UnsupportedOperationException();
    }

    /**
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        throw  new UnsupportedOperationException();
    }

    /**
     * @param key
     * @param value
     * @return
     */
    @Override
    public V remove(K key, V value) {
        throw  new UnsupportedOperationException();
    }

    /**
     * @return
     */
    @Override
//  ToDo  Your implementation is required to implement all of the methods given in Map61B except for remove, iterator and keySet. For these methods you should throw an UnsupportedOperationException.
    public Iterator<K> iterator() {
        return null;
    }


}

class BST<V> {
    public BST left; //todo 这里有必要写成private吗？
    public BST right;
    public Comparable key;
    public V value;


    BST(BST left, BST right, Comparable val,V value) {
        left = left;
        right = right;
        key = key;
        value = value;

    }

    BST insert(BST T, Comparable ik,V value ) { //todo   不知道对不对
        if (T == null) {
            return new BST(null, null, ik,value);
        }
        if ((ik.compareTo(T.key) < 0)) {
            T.left = insert(T.left, ik,value);
        } else if ((ik.compareTo(T.key) > 0)) {
            T.right = insert(T.right, ik,value);
            return T;
        }
        return T;
    }
}
