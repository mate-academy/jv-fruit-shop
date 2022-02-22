package store.db;

import java.util.HashMap;

public interface StoreFunc<K> {

    Integer transaction(K key,Integer value);

    Integer getItem(K key);

    HashMap<K,Integer> getBalance();

}
