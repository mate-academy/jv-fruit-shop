package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractAction;
import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.storage.FruitShopStorage;

public class SupplyAction extends AbstractAction {
    
    public SupplyAction(FruitShopStorage storage, ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        getShopDao().addAction(new DataRecord(ShopActions.SUPPLY, item, amount));
        getShopDao().update();
        int update = getStorage().get(item) + amount;
        getStorage().put(item, update);
    }
}
