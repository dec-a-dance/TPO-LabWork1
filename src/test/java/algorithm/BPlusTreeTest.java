package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BPlusTreeTest {
    Tree bplusTree;

    @BeforeEach
    void init(){
        bplusTree = new BPlusTree(7);
    }

    @Test
    void checkInsert(){
        bplusTree.insert(1, 1);
        int expectedVal = 1;
        assertEquals(expectedVal, bplusTree.search(1));
    }

    @Test
    void checkSearchOfUncreated(){
        assertNull(bplusTree.search(777));
    }

    @Test
    void checkDeleteOfUncreated(){
        bplusTree.insert(1, 1);
        assertThrows(NullPointerException.class, () -> bplusTree.delete(777));
    }

    @Test
    void checkDeleteWhileEmpty(){
        assertThrows(NullPointerException.class, () -> bplusTree.delete(777));
    }

    @Test
    void checkDoubleKeyInsertion(){
        bplusTree.insert(1, 1);
        bplusTree.insert(1, 2);
        int expectedVal = 1;
        assertEquals(expectedVal, bplusTree.search(1));
    }

    @Test
    void checkDelete(){
        bplusTree.insert(1, 1);
        bplusTree.delete(1);
        assertNull(bplusTree.search(1));
    }

    @Test
    void checkDeleteOfDouble(){
        bplusTree.insert(1, 1);
        bplusTree.insert(2, 2);
        bplusTree.insert(2, 3);
        bplusTree.delete(2);
        int expectedValue = 3;
        assertEquals(expectedValue, bplusTree.search(2));
    }
}
