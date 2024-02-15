package hashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {
    protected int initialSize;  //todo 这里不能用private吧
    protected float maxLoad;
    protected float loadFactor;

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {;;
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        // todo 如果子类都继承了父类的get方法 父类的get方法是不是可以不写？
//        V e = this.buckets.get(key);
//        return (e == null) ? null : e.value;
        return  null;

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key)){
            return;
        }
        int h = hash (key);
        Entry<Key,Val> e = find (key, bins.get (h));
        if (e == null) {
            bins.set (h, new Entry<Key,Val> (key, value, bins.get (h)));
            size += 1;
            if (size > bins.size () * loadFactor) grow ();
            return null;
        } else
            return e.setValue (value);
        //todo 根据哈希值去找位置，然后放

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets; // Node 的结构不一样，对应不同的bucket子类
    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        int initialSize=16;
        float loadFactor= 0.75F;
    }

    public MyHashMap(int initialSize) {
        initialSize=initialSize;
        float loadFactor= 0.75F;
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        if (initialSize<1  || maxLoad<=0.0){
            throw new IllegalArgumentException ();
        }
        initialSize=initialSize;
        maxLoad=maxLoad;
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return null;
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return null;
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        // todo
        Collection<Node> bucket=createBucket();
        return null;
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!

}
