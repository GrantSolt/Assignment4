public class HTChainNew {
    private int N; // number of key-value pairs
    private int M; // hash table size
    private LinearST[] st;// array of ST objects
    private int comp;
    public HTChainNew(){
        this(997);
    }
    public HTChainNew(int M){
        this.M = M;
        st =(LinearST[]) new LinearST[M];
        for (int i = 0; i < M; i++)
            st[i] = new LinearST();
        comp=0;
    }

    public int hashCode(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++)
            hash = (hash * 31) + key.charAt(i);
        return hash;
    }
    private int hash(String key){
        return (key.hashCode() & 0x7fffffff) % M;
    }



    public boolean has(String key){
        comp=0;

        comp=st[hash(key)].getComp();
        return st[hash(key)].has(key);
    }

    public int getComp() {
        return comp;
    }
    public void put(String key, int val){
        st[hash(key)].put(key, val);
    }
}
