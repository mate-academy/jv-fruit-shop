package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractTransaction;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;

public class BalanceTransaction extends AbstractTransaction<DataRecord, Fruit> {
    
    public BalanceTransaction(AbstractStorage<DataRecord, Fruit> storage, ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        getStorage().put((Fruit) item, amount);
        getShopDao().addTransaction(new DataRecord(ShopTransactionsTypes.BALANCE, item, amount));
        getShopDao().updateDatabase();
    }
}
