package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.AbstractAction;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.storage.FruitShopStorage;

public class BalanceAction extends AbstractAction {
    
    
    public BalanceAction(FruitShopStorage storage, ShopDao<DataRecord> shopDao) {
        super(storage, shopDao);
    }
    
    @Override
    public void apply(AbstractItem item, int amount) {
        getStorage().put(item, amount);
    }
}
