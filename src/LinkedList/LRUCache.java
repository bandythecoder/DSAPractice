package LinkedList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LRUCache {
    LinkedHashMap<Integer,Integer> lsm;
    int capacity = 0;
    public LRUCache(int capacity) {
        lsm = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(lsm.containsKey(key)) return lsm.get(key);
        MakeRecently(key);
        return -1;
    }

    public void put(int key, int value) {
        if(lsm.containsKey(key))
        {
            lsm.put(key,value);
            MakeRecently(key);
            return;
        }

        if(lsm.size() == capacity)
        {
            int oldkey = lsm.keySet().iterator().next();
            lsm.remove(oldkey);
        }
        lsm.put(key,value);

    }

    private void MakeRecently(int key)
    {
        var value = lsm.get(key);
        lsm.remove(key);
        lsm.put(key,value);

    }


}
