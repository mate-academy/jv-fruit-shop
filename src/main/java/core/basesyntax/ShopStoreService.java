package core.basesyntax;

import java.util.HashMap;
import store.db.StoreDB;

public class ShopStoreService<K> implements ShopInterface<K> {

    private StoreDB<K> shopStore = new StoreDB();

    @Override
    public Integer storeBalance(K key, Integer value) {
        return shopStore.transaction(key,value);
    }

    @Override
    public Integer storeSupply(K key, Integer value) {

        return shopStore.transaction(key,value);
    }

    @Override
    public Integer storePurchase(K key, Integer value) {

        return shopStore.transaction(key,-value);
    }

    @Override
    public Integer storeReturn(K key, Integer value) {

        return shopStore.transaction(key,value);
    }

    @Override
    public Integer storeProcessCsvData(K key, Integer value, String ptype) {
        switch (ptype) {
            case "p":
                return storePurchase(key, value);
            case "s":
                return storeSupply(key, value);
            case "b":
                return storeBalance(key, value);
            case "r":
                return storeReturn(key, value);
            default:
                return null;
        }
    }

    @Override
    public HashMap<K, Integer> getBalaceReport() {
        return shopStore.getBalance();
    }
}
