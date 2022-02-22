package store.db;

import java.util.HashMap;

public class StoreDB<K> implements StoreFunc<K> {
    private HashMap<K,Integer> storelist = new HashMap<K,Integer>();

    @Override
    public Integer transaction(K key, Integer value) {
        if (key == null) {
            return null;
        }
        if (value == null) {
            value = 0;
        }
        Integer storedvalue = getItem(key);
        if (storedvalue != null) {
            value = value + storedvalue;
        }
        return storelist.put(key,value);
    }

    @Override
    public Integer getItem(K key) {
        return storelist.get(key);
    }

    @Override
    public HashMap<K, Integer> getBalance() {
        return (HashMap<K, Integer>) storelist.clone();
    }
}
