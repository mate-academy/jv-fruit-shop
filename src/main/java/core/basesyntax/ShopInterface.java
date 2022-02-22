package core.basesyntax;

import java.util.HashMap;

public interface ShopInterface<K> {

    Integer storeBalance(K key,Integer value);

    Integer storeSupply(K key, Integer value);

    Integer storePurchase(K key,Integer value);

    Integer storeReturn(K key,Integer value);

    Integer storeProcessCsvData(K key,Integer value,String ptype);

    HashMap<K,Integer> getBalaceReport();

}
