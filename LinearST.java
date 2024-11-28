import java.util.ArrayList;
import java.util.List;

public class LinearST{
    private int n;           // number of key-value pairs
    private Node first;
    private int comp;// the linked list of key-value pairs

    private class Node {
        private String key;
        private int val;
        private Node next;

        public Node(String key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }


    public LinearST() {
        comp=0;
    }

    public boolean has(String key) {
        comp=0;

        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (Node x = first; x != null; x = x.next) {
            comp++;
            if (key.equals(x.key))
                return true;
        }
        return false;
    }

    public int getComp() {
        return comp;
    }

    public void put(String key, int val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");


        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
}
