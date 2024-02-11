package hashmap;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Hash Table with Array List buckets
 * @author Neil Kulkarni
 */
public class MyHashMapALBuckets<K, V> extends MyHashMap<K, V> {

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
    public V iterator(K key) {
        int  bucketIndex= (int) ((int)key%maxLoad);
        while (this[(K) bucketIndex][key].hasNext()) { //todo

        }
    };
    @Override
    public V get(K key) {
//        Int bucketIndex= (int)key%maxLoad;
        int  bucketIndex= (int) ((int)key%maxLoad);
        iterator
    }

}
