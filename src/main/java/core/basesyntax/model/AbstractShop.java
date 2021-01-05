package core.basesyntax.model;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import java.util.Map;

public abstract class AbstractShop<R, I extends AbstractItem> {
    private final AbstractStorage<R, I> shopStorage;
    private final ShopDao<R> shopDao;
    
    public AbstractShop(AbstractStorage<R, I> shopStorage, ShopDao<R> shopDao) {
        this.shopStorage = shopStorage;
        this.shopDao = shopDao;
    }
    
    public abstract void performAction(ShopTransactionsTypes action, I item, int amount);
    
    public Map<I, Integer> getShopStorage() {
        return shopStorage.getStorage();
    }
    
    public ShopDao<R> getShopDao() {
        return shopDao;
    }
}
