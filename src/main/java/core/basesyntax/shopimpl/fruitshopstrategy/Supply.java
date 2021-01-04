package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractAction;
import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.entity.DataRecord;

public class Supply extends AbstractAction {
    private AbstractStorage<DataRecord, AbstractItem> storage;
    private ShopDao<DataRecord> shopDao;
    
    public Supply(AbstractStorage<DataRecord, AbstractItem> storage, ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        shopDao.addAction(new DataRecord(ShopActions.SUPPLY, item, amount));
        shopDao.update();
        int update = storage.getStorage().get(item) + amount;
        storage.getStorage().put(item, update);
    }
}
