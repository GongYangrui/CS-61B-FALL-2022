package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void Test() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> M = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                M.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1 && L.size() != 0) {
                //getLast
                int x = L.getLast();
                int y = M.getLast();
                System.out.println("GetLast(" + x + ")");
            } else if (operationNumber == 2 && L.size() != 0) {
                //removeLast
                int x = L.removeLast();
                int y = M.removeLast();
                System.out.println("removeLast(" + x + ")");
            }
        }
    }
}
