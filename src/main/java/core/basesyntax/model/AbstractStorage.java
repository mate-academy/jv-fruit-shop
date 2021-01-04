package core.basesyntax.model;

import core.basesyntax.model.shopdao.ShopDao;
import java.util.Map;

public abstract class AbstractStorage<R, I extends AbstractItem> {
    private final Map<I, Integer> storage;
    private final ShopDao<R> shopDao;
    
    public AbstractStorage(ShopDao<R> shopDao) {
        this.shopDao = shopDao;
        storage = initStorage(shopDao);
    }
    
    protected abstract Map<I, Integer> initStorage(ShopDao<R> shopDao);
    
    public Map<I, Integer> getStorage() {
        return storage;
    }
}
