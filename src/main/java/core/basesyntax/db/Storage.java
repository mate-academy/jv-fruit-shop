package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class Storage {
    private Map<Fruit, Integer> shopStorage;

    public Storage(Map<Fruit, Integer> shopStorage) {
        this.shopStorage = shopStorage;
    }

    public Map<Fruit, Integer> getShopStorage() {
        return shopStorage;
    }

    public void setShopStorage(Map<Fruit, Integer> shopStorage) {
        this.shopStorage = shopStorage;
    }
}
