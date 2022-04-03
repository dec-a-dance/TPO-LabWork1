package algorithm;

import java.util.ArrayList;

public interface Tree {
    void insert(int key);
    int remove(int key);
    BPlusTreeNode search(int key);
    ArrayList<Integer> traverse();
}
