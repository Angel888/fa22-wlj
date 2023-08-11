package deque;

import java.util.Objects;

// 可以模仿lab03中alist的写法
// 参考 https://zhuanlan.zhihu.com/p/394975920  感觉只看官方文档做不出来
// https://www.coursehero.com/file/28332886/ArrayDequejava/  也有code  但是不全
//todo 为什么要在add和remove之前resize?
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int capacity;

    // todo 为什么不用first last而是nextfirst nextlast
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 0; //todo 不应该也是0吗 此时为空数组
        capacity = 0;
    }

    public void addFirst(T item) {
        resize();
        // 每个都要往后挪一下吗
        items[this.nextFirst] = item;
        this.nextFirst = plusOne(this.nextFirst);
        size += 1;
    }

    public void addLast(T item) {
        resize();
        items[this.nextLast] = item;
        this.nextLast = minusOne(this.nextFirst);
        size += 1;
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        //todo 不会写 会影响别后面的吗？
        for (int i = 0; i < this.size(); i++) {
            if (!Objects.isNull(this.items[i])) {
                System.out.println(this.items[i]);
            }
        }

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        resize();
        T item = items[minusOne(this.nextFirst)];
        items[minusOne(this.nextFirst)] = null;
        this.nextFirst = minusOne(this.nextFirst);
        size--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        resize();
        T item = items[minusOne(this.nextLast)];
        items[minusOne(this.nextLast)] = null;
        this.nextLast = minusOne(this.nextLast);
        size--;
        return item;

    }

    public T get(int index) {
        if (index < 0 || this.size() <= index) {
            return null;
        }
//        index = Math.floorMod(plusOne(nextFirst) + index, items.length); //todo 這句什麼意思？
        return items[index];
    }

    // 先判断类型，再判断长度，再判断每个值
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque) {
            ArrayDeque<T> arrayDeque = (ArrayDeque<T>) o;
            if (arrayDeque.size() != this.size()) {
                return false;
            }
            for (int i = 0; i < arrayDeque.size(); i++) {
                if (arrayDeque.items[i] != this.items[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /* get the last index */
    public int minusOne(int index) {
        // Math.floorMod 保证索引在合法范围内
        return Math.floorMod(index - 1, items.length);
    }

    /* get the next index */
    public int plusOne(int index) {
        return Math.floorMod(index + 1, items.length);
    }

    private void resize() {
        if (size == items.length) {
            expand();
        }
        if (size < (items.length) * 0.25 && items.length > 8) {
            reduce();
        }
    }

    private void expand() {
        // todo 不应该是先和size比较，然后再判断要不要改capacity吗
        if (this.capacity < items.length * 2) {
            resizeHelper(items.length * 2);
        }
    }

    private void reduce() {
        if (this.capacity > items.length * 2) {
            resizeHelper(items.length / 2);
        }
    }

    private void resizeHelper(int capacity) {
        // 遍历然后放里面
        T[] tempArr = (T[]) new Object[capacity];
        // 列表前后要保证起码留一个空间
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        int start = 0;
        for (int i = begin; i <= end; i++) {
            tempArr[start] = this.items[i];
            start += 1;
        }
        this.capacity = capacity;
        this.items = tempArr;
    }
}
