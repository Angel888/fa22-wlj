package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class ArrayDequeTest {
    //todo copy lab03 的test? for SList and AList
    // https://fa22.datastructur.es/materials/lab/lab03/
    // randomsized test
    public   static void  randomizedTest(){
        ArrayDeque<Integer> L = new ArrayDeque<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2); // 0到2之间的数
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
        }
    }
    @Test
    public void randomized1Test() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();
        ArrayDeque<Integer> broken = new ArrayDeque<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {

            }
        }}
    public static void main(String[] args) {
        randomizedTest();
    }
}
