package core.basesyntax.shopimpl;

import core.basesyntax.model.AbstractShop;
import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.fruitshopstrategy.FruitShopActionHandler;
import core.basesyntax.shopimpl.storage.FruitShopStorage;

public class FruitShop extends AbstractShop<DataRecord, Fruit> {
    private FruitShopActionHandler handler;
    
    public FruitShop(FruitShopStorage shopStorage, FruitShopDao fruitShopDao) {
        super(shopStorage, fruitShopDao);
        handler = new FruitShopActionHandler(shopStorage, fruitShopDao);
    }
    
    @Override
    public void performAction(ShopActions action, Fruit item, int amount) {
        handler.getAction(action).apply(item, amount);
    }
}
