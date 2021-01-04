package core.basesyntax.model.shopstrategy;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.util.Map;

public abstract class AbstractAction implements ShopAction {
    private AbstractStorage<DataRecord, AbstractItem> storage;
    private ShopDao<DataRecord> shopDao;
    
    public AbstractAction(AbstractStorage<DataRecord, Fruit> storage, ShopDao<DataRecord> shopDao) {
        this.storage = storage;
        this.shopDao = shopDao;
    }
    
    @Override
    public abstract void apply(AbstractItem item, int amount);
    
    public Map<AbstractItem, Integer> getStorage() {
        return storage.getStorage();
    }
    
    public ShopDao<DataRecord> getShopDao() {
        return shopDao;
    }
}
