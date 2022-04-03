package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BPlusTreeTest {
    BPlusTree bplusTree;

    @BeforeEach
    void init(){
        bplusTree = new BPlusTree(7);
    }

    private void bigInsert(int size){
        for(int i = 0; i < size; i++){
            bplusTree.insert(i);
        }
    }

    private void insertOne(int size){
        for(int i = 0; i < size; i++){
            bplusTree.insert(1);
        }
    }

    @Test
    void checkInsert(){
        bplusTree.insert(1);
        assertEquals("[1]", bplusTree.traverse().toString());
    }

    @Test
    void checkTraverseEmpty(){
        assertEquals("[]",bplusTree.traverse().toString());
    }

    @Test
    void checkSearchOfUncreated(){
        assertNull(bplusTree.search(777));
    }

    @Test
    public void checkInsertAndRemove() {
        bplusTree.insert(5);
        bplusTree.insert(1);
        bplusTree.insert(11);
        bplusTree.insert(6);
        bplusTree.insert(2);
        bplusTree.insert(3);
        bplusTree.insert(12);
        bplusTree.insert(10);
        bplusTree.insert(7);
        bplusTree.insert(4);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 10, 11, 12]", bplusTree.traverse().toString());
        bplusTree.remove(3);
        assertEquals("[1, 2, 4, 5, 6, 7, 10, 11, 12]", bplusTree.traverse().toString());
        bplusTree.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", bplusTree.traverse().toString());
        bplusTree.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", bplusTree.traverse().toString());
        bplusTree.insert(3);
        assertEquals("[1, 2, 3, 5, 6, 7, 10, 11, 12]", bplusTree.traverse().toString());
        bplusTree.remove(1);
        assertEquals("[2, 3, 5, 6, 7, 10, 11, 12]", bplusTree.traverse().toString());
    }

    @Test
    public void checkInsertDeleteWithSameNodes(){
        insertOne(20);
        assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]", bplusTree.traverse().toString());
        bplusTree.remove(1);
        assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]", bplusTree.traverse().toString());
    }

    @Test
    void checkSearch(){
        bigInsert(44);
        assertEquals("[7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]", Arrays.toString(bplusTree.search(10).keys));
    }

    @Test
    void checkSearchOfDeleted(){
        bigInsert(44);
        bplusTree.remove(10);
        assertEquals(null, bplusTree.search(10));
    }

    @Test
    void checkDelete(){
        bplusTree.insert(1);
        bplusTree.remove(1);
        assertEquals("[]",bplusTree.traverse().toString());
    }

    @Test
    void checkDeleteOfEmpty(){
        assertEquals(0, bplusTree.remove(777));
    }

    @Test
    void checkDeleteOfUncreated(){
        bigInsert(44);
        assertEquals(0, bplusTree.remove(777));
    }

    @Test
    void checkDeleteOfDeleted(){
        bigInsert(44);
        assertEquals(1, bplusTree.remove(12));
        assertEquals(0, bplusTree.remove(12));
    }



}
