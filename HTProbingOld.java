public class HTProbingOld {
    private String[] st; // number of key-value pairs
    private int M;
    private int size;
    private int comp;
    // hash table size

    public HTProbingOld(int M) {
        this.M = M;
        st = new String[M];
        size = 0;
        comp=0;
    }
    public int hashCode(String key) {
        int hash = 0;
        int skip = Math.max(1, key.length() / 8);
        for (int i = 0; i < key.length(); i += skip)
            hash = (hash * 37) + key.charAt(i);
        return hash;
    }
    private int hash(String key){
        return (hashCode(key) & 0x7fffffff) % M;
    }


    public boolean has(String key){
        int index = hash(key);
        comp = 0;

        while (st[index] != null) {
            comp++;
            if (st[index].equals(key)) {
                return true;  // Found the word
            }
            index = (index + 1) % M;  // Continue probing if not found
        }
        return false;
    }

    public int getComp() {
        return comp;
    }

    public void insert(String key) {
        if (size >= M) {
            System.out.println("Hash table is full!");
            return;
        }

        int index = hash(key);
        while (st[index] != null) {
            index = (index + 1) % M;
        }

        st[index] = key;
        size++;
    }
}
