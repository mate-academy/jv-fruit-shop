package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractTransaction;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;

public class ReturnTransaction extends AbstractTransaction<DataRecord, Fruit> {
    
    public ReturnTransaction(AbstractStorage<DataRecord, Fruit> storage, ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        super.getShopDao()
                .addTransaction(new DataRecord(ShopTransactionsTypes.RETURN, item, amount));
        super.getShopDao().updateDatabase();
        int update = super.getStorage().get(item) + amount;
        super.getStorage().put((Fruit) item, update);
    }
}
