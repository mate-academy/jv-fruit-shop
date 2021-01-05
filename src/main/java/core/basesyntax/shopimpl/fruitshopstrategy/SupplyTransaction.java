package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractTransaction;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;

public class SupplyTransaction extends AbstractTransaction<DataRecord, Fruit> {
    
    public SupplyTransaction(AbstractStorage<DataRecord, Fruit> storage,
                             ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        getShopDao().addTransaction(new DataRecord(ShopTransactionsTypes.SUPPLY, item, amount));
        getShopDao().updateDatabase();
        
        if (getStorage().containsKey(item)) {
            int update = getStorage().get(item) + amount;
            getStorage().put((Fruit) item, update);
            return;
        }
        getStorage().put((Fruit) item, amount);
    }
}
