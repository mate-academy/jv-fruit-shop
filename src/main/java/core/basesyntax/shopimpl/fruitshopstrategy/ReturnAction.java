package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractAction;
import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.storage.FruitShopStorage;

public class ReturnAction extends AbstractAction {
    
    public ReturnAction(FruitShopStorage storage, FruitShopDao shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        super.getShopDao().addAction(new DataRecord(ShopActions.SUPPLY, item, amount));
        super.getShopDao().update();
        int update = super.getStorage().get(item) + amount;
        super.getStorage().put(item, update);
    }
}
