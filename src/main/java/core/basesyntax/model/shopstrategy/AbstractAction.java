package core.basesyntax.model.shopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import java.util.Map;

public abstract class AbstractAction<R, I extends AbstractItem> implements ShopAction {
    private AbstractStorage<R, I> storage;
    private ShopDao<R> shopDao;
    
    public AbstractAction(AbstractStorage<R, I> storage, ShopDao<R> shopDao) {
        this.storage = storage;
        this.shopDao = shopDao;
    }
    
    @Override
    public abstract void apply(AbstractItem item, int amount);
    
    public Map<I, Integer> getStorage() {
        return storage.getStorage();
    }
    
    public ShopDao<R> getShopDao() {
        return shopDao;
    }
}
