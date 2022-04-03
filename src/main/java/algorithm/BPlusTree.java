package algorithm;


import java.util.ArrayList;

public class BPlusTree implements Tree{
        public ArrayList<Integer> result = new ArrayList<>();
        BPlusTreeNode root;
        int MinDeg;

        // Constructor
        public BPlusTree(int deg){
                this.root = null;
                this.MinDeg = deg;
        }

        @Override
        public ArrayList<Integer> traverse() {
                result.clear();
                if (root != null) {
                        result.addAll(root.traverse());
                }
                System.out.println();
                return result;
        }

        @Override
        // Function to find key
        public BPlusTreeNode search(int key){
                return root == null ? null : root.search(key);
        }

        @Override
        public void insert(int key){

                if (root == null){

                        root = new BPlusTreeNode(MinDeg,true);
                        root.keys[0] = key;
                        root.num = 1;
                }
                else {
                        // When the root node is full, the tree will grow high
                        if (root.num == 2*MinDeg-1){
                                BPlusTreeNode s = new BPlusTreeNode(MinDeg,false);
                                // The old root node becomes a child of the new root node
                                s.children[0] = root;
                                // Separate the old root node and give a key to the new node
                                s.splitChild(0,root);
                                // The new root node has 2 child nodes. Move the old one over there
                                int i = 0;
                                if (s.keys[0]< key)
                                        i++;
                                s.children[i].insertNotFull(key);

                                root = s;
                        }
                        else
                                root.insertNotFull(key);
                }
        }

        @Override
        public int remove(int key){
                if (root == null){
                        System.out.println("The tree is empty");
                        return 0;
                }

                int ans = root.remove(key);

                if (root.num == 0){ // If the root node has 0 keys
                        // If it has a child, its first child is taken as the new root,
                        // Otherwise, set the root node to null
                        if (root.isLeaf)
                                root = null;
                        else
                                root = root.children[0];
                }
                return ans;
        }
}
