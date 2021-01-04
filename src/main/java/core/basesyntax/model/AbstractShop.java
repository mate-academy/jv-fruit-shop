package core.basesyntax.model;

import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopActions;

public abstract class AbstractShop<R, T extends AbstractItem> {
    private final AbstractStorage<R, T> shopStorage;
    private final ShopDao<R> shopDao;
    
    public AbstractShop(AbstractStorage<R, T> shopStorage, ShopDao<R> shopDao) {
        this.shopStorage = shopStorage;
        this.shopDao = shopDao;
    }
    
    public abstract void performAction(ShopActions action, T item, int amount);
    
    public AbstractStorage<R, T> getShopStorage() {
        return shopStorage;
    }
    
    public ShopDao<R> getShopDao() {
        return shopDao;
    }
}
