package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.AbstractAction;
import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.storage.FruitShopStorage;

public class ReturnAction extends AbstractAction<DataRecord, Fruit> {
    
    public ReturnAction(FruitShopStorage storage, FruitShopDao shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        super.getShopDao().addTransaction(new DataRecord(ShopActions.SUPPLY, item, amount));
        super.getShopDao().updateDatabase();
        int update = super.getStorage().get(item) + amount;
        super.getStorage().put((Fruit) item, update);
    }
}
