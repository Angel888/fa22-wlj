package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    //todo  YOUR TESTS HERE
    @Test
    public void randomizedTest() {
        BuggyAList bugList = new BuggyAList<>();
        AListNoResizing notResizeList = new AListNoResizing<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3); // 0到2之间的数
//            if (notResizeList.size()>=1000){
//                assertEquals(bugList.removeLast(), notResizeList.removeLast());
//            } else
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                bugList.addLast(randVal);
                notResizeList.addLast(randVal);
            } else if (operationNumber == 1) {
                assertEquals(bugList.size(), notResizeList.size());
                assertEquals(bugList.getLast(), notResizeList.getLast());
            } else if( operationNumber ==2 && (bugList.size() > 0 && notResizeList.size() > 0)) {
                assertEquals(bugList.getLast(), notResizeList.getLast());
                assertEquals(bugList.removeLast(), notResizeList.removeLast());
            }
        }
    }


    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList bugList = new BuggyAList<>();
        AListNoResizing notResizeList = new AListNoResizing<>();
        bugList.addLast(1);
        notResizeList.addLast(1);
        bugList.addLast(2);
        bugList.addLast(3);
        notResizeList.addLast(2);
        notResizeList.addLast(3);
        assertEquals(bugList.removeLast(), notResizeList.removeLast());
        assertEquals(bugList.removeLast(), notResizeList.removeLast());
        assertEquals(bugList.removeLast(), notResizeList.removeLast());
    }
}

