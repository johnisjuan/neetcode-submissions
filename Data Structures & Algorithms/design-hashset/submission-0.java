class MyHashSet {

    ArrayList<ArrayList<Integer>> set;

    public MyHashSet() {
        set = new ArrayList<>();
        
        for (int i = 0; i < 100; ++i) {
            set.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int x = key % 100;

        if (!contains(key)) {
            set.get(x).add(key);
        }
    }
    
    public void remove(int key) {
        int x = key % 100;

        for (int i = 0; i < set.get(x).size(); ++i) {
            if (set.get(x).get(i) == key) {
                set.get(x).remove(i);
                return;
            }
        }
    }
    
    public boolean contains(int key) {
        int x = key % 100;

        for (int i = 0; i < set.get(x).size(); ++i) {
            if (set.get(x).get(i) == key) {
                return true;
            }
        }

        return false;
    }
}