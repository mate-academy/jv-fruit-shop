package core.basesyntax.model;

import core.basesyntax.model.shopdao.ShopDao;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStorage<I extends AbstractItem> {
    private final Map<I, Integer> storage = new HashMap<>();
    private final ShopDao shopDao;
    
    public AbstractStorage(ShopDao shopDao) {
        this.shopDao = shopDao;
    }
    
    public Map<I, Integer> getStorage() {
        return storage;
    }
}
