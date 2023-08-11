package deque;

import org.mockito.internal.matchers.Null;

import java.util.Iterator;
import java.util.Objects;

// slides:https://docs.google.com/presentation/d/1XBJOht0xWz1tEvLuvOL4lOIaY0NSfArXAvqgkrx0zpc/edit#slide=id.g1094ff4355_0_208


//https://blog.csdn.net/qq_45698833/article/details/114770960 可以先参考别人的
public class LinkedListDeque<T> {
    public Node sentinel; //todo 需不需要加private？
    public Integer size;

    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        this.size = 0;
        this.sentinel.next = new Node(null, null, null);
        this.sentinel.prev = new Node(null, null, null);
    }


    public void addFirst(T item) {
        if (this.size == 0) {
            this.sentinel = new Node(null, item, null);
        } else if (this.size == 1) {
            Node newNode = new Node(this.sentinel, item, this.sentinel);
            this.sentinel.prev = newNode;
            this.sentinel.next = newNode;
            this.sentinel = newNode;
        } else {
            Node newNode = new Node(this.sentinel.prev, item, this.sentinel);
            this.sentinel.prev.next = newNode;
            this.sentinel.prev = newNode;
            this.sentinel = newNode;
        }
        this.size += 1;


    }

    public void addLast(T item) {
        if (this.size == 0) {
            this.sentinel = new Node(null, item, null);
        } else if (this.size == 1) {
            Node newNode = new Node(this.sentinel, item, this.sentinel);
            this.sentinel.next = newNode;
            this.sentinel.prev = newNode;
        } else {
            Node newNode = new Node(this.sentinel.prev, item, this.sentinel);
            this.sentinel.prev.next = newNode;
            this.sentinel.prev = newNode;
        }
        this.size += 1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        // ToDo 别让它循环
        Node temp = this.sentinel;
        System.out.println(temp.item + " ");
        while (!Objects.isNull(temp) && temp != this.sentinel) {
            System.out.println(temp.item + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public T removeFirst() {
        if (this.size()==1){
            T a=this.sentinel.item;
            this.sentinel = new Node(null, null, null);
            this.size-=1;
            return a;
        }
        if (this.size<=0){
            return null;
        }
        Node newSentinel = this.sentinel.next;
        Node oldSentinel = this.sentinel;
        this.sentinel.prev.next = this.sentinel.next;
        this.sentinel.next.prev=this.sentinel.prev;
        this.sentinel = newSentinel;
        this.size -= 1;
        return oldSentinel.item;
    }

    public T removeLast1() {

        // todo 要这样分类讨论吗？看看别人怎么弄得
        if (this.size() == 0) {
            return null;
        }
        if (this.size() == 1) {
            T a = this.sentinel.item;
            this.sentinel = new Node(null, null, null);
            this.size -= 1;
            return a;
        }
        Node removeNode = this.sentinel.prev;
        this.sentinel.prev.next = this.sentinel;
        this.size -= 1;
        return removeNode.item;
    }

    public T removeLast() {
        if (this.size()==1){
            T a=this.sentinel.item;
            this.sentinel = new Node(null, null, null);
            this.size-=1;
            return a;
        }
        if (this.size<=0){
            return null;
        }
        Node temp = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return temp.item;
    }


    public T get(int index) {
        if (this.size() <= index) {
            return null;
        }
        Node temp = this.sentinel;
        for (int x = 0; x < index; x = x + 1) {
            temp = temp.next;
        }
        return temp.item;
    }

    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque) {
            LinkedListDeque<T> deque = (LinkedListDeque<T>) o;
            if (deque.size() != this.size()) {
                return false;
            }
            Node temp1 = deque.sentinel;
            Node temp2 = deque.sentinel;
            while (!Objects.isNull(temp1) && !Objects.isNull(temp2) && temp1.item == temp2.item) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return true;
        }
        return false;
    }
//    Creates an empty linked list deque.

    //    public T getRecursive(int index){
//        Node temp=this.sentinel;
//        if (index>0){
//            this.sentinel=this.sentinel.next;
//            return getRecursive(index--);
//        }
//        return this.sentinel.item;
//    }
    public T getRecursive(int index) {
        if (index >= size()) {
            return null;
        }
        Node temp = this.sentinel;
        return nextRecursive(temp, index);


    }

    private T nextRecursive(Node temp, int index) {

        if (index > 0) {
            return nextRecursive(temp.next, --index);
        }
        return temp.item;
    }

    public Iterator<T> iterator() {
        return null; //todo proj1c
    }

    class Node {  // todo Node可以不放到LinkedListDeque这个类里面吗？可以不是private吗？
        Node prev;
        T item;
        Node next;

        Node(Node prev, T item, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}