package hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Hash Table with Array List buckets
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
     * @param maxLoad maximum load factor
     */
    public MyHashMapALBuckets(int initialSize, double maxLoad) {
        super(initialSize, maxLoad);
    }

    @Override
    protected Collection<Node> createBucket() {
        return new ArrayList<>(initialSize);
    }

    @Override
    public V get(K key) {
//        先根据hash值求出来在哪个桶，然后从这个桶里拿这个key对应的value
        int  bucketIndex= (int) ((int)key%maxLoad);
        Node n = this.bucket.get(bucketIndex);
        return n.value;
    }
    public void clear() {
    //todo
    }
    @Override
    public boolean containsKey(K key) {
        // todo
        return get(key) != null;
    }
    @Override
    public int size() {
        // todo
        return 0;
    }

    @Override
    public void put(K key, V value) {
        // todo
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
