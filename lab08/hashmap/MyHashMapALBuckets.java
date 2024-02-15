package hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Hash Table with Array List buckets
 *
 * @author Neil Kulkarni
 */
public class MyHashMapALBuckets<K, V> extends MyHashMap<K, V> {
    public ArrayList<Node> bucket;

    /**
     * Constructor that creates a backing array with default
     * initial size and load factor
     */
    public MyHashMapALBuckets() {
        super();

    }

    /**
     * Constructor that creates a backing array of initialSize
     * and default load factor
     *
     * @param initialSize initial size of backing array
     */
    public MyHashMapALBuckets(int initialSize) {
        super(initialSize);
    }

    /**
     * Constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad     maximum load factor
     */
    public MyHashMapALBuckets(int initialSize, double maxLoad) {
        super(initialSize, maxLoad);
    }

    @Override
    protected Collection<Node> createBucket() {
        return new ArrayList<>(KVsize);
    }

    @Override
    public V get(K key) {
//        先根据hash值求出来在哪个桶，然后从这个桶里拿这个key对应的value
        int bucketIndex = (int) ((int) key % maxLoad);
        if (this.maxLoad <= bucketIndex) {
            return null;
        }
        Node n = this.bucket.get(bucketIndex);
        return n.value;
    }

    public void clear() {
        this.bucket = null;
    }

    @Override
    public boolean containsKey(K key) {
        // 用hash值和桶的个数比较
        int bucketIndex = (int) ((int) key % maxLoad);
        if (this.maxLoad <= bucketIndex) {
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return this.KVsize;
    }

    @Override
    public void put(K key, V value) {
        // todo
        if (!containsKey(key)) {
            return;
        }
        int bucketIndex = (int) ((int) key % maxLoad);
        V val = this.get(key);
        if (val == value) {
            return;
        }
        bucket.set(bucketIndex, new MyHashMap<K, V>((Integer) key, (V)value));
        this.KVsize += 1;
        if (KVsize > bucket.size() * loadFactor) {
            grow();
        } ;

    }
    //todo 根据哈希值去找位置，然后放

    /**
     * Increase number of bins.
     */
    private void grow() {
        MyHashMap<K, V> newMap
                = new MyHashMap(bucket.size() * 2, loadFactor);
        newMap.putAll(this);
        copyFrom(newMap);
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
