package core.basesyntax.shopimpl;

import core.basesyntax.model.AbstractShop;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.fruitshopstrategy.FruitShopActionHandler;

public class FruitShop extends AbstractShop<DataRecord, Fruit> {
    private FruitShopActionHandler handler;
    
    public FruitShop(AbstractStorage<DataRecord, Fruit> shopStorage, ShopDao<DataRecord> fruitShopDao) {
        super(shopStorage, fruitShopDao);
        handler = new FruitShopActionHandler(shopStorage, fruitShopDao);
    }
    
    @Override
    public void performAction(ShopTransactionsTypes action, Fruit item, int amount) {
        handler.getAction(action).apply(item, amount);
    }
}
