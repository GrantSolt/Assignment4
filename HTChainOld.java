public class HTChainOld {
    private int N; // number of key-value pairs
    private int M; // hash table size
    private LinearST[] st;
    private int comp;// array of ST objects

    public HTChainOld() {
        this(997);
    }

    public HTChainOld(int M) {
        this.M = M;
        st = (LinearST[]) new LinearST[M];
        for (int i = 0; i < M; i++)
            st[i] = new LinearST();
        comp = 0;
    }

    public int hashCode(String key) {
        int hash = 0;
        int skip = Math.max(1, key.length() / 8);
        for (int i = 0; i < key.length(); i += skip)
            hash = (hash * 37) + key.charAt(i);
        return hash;
    }

    private int hash(String key) {
        return (hashCode(key) & 0x7fffffff) % M;
    }


    public boolean has(String key) {
        comp = 0;
        boolean found = st[hash(key)].has(key);
        comp = st[hash(key)].getComp();
        return found;
    }

    public int getComp() {
        return comp;
    }

    public void put(String key, int val) {
        st[hash(key)].put(key, val);
    }
}