package deque;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {
    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        for (int i = 0; i < 9; i += 1) {
            L.addFirst(i);
        }
    }

}
