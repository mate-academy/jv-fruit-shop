package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.AbstractItem;
import core.basesyntax.model.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopAction;
import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.storage.FruitShopStorage;
import java.util.HashMap;
import java.util.Map;

public class FruitShopActionHandler {
    private final Map<ShopActions, ShopAction> strategyMap = new HashMap<>();
    
    public FruitShopActionHandler(FruitShopStorage storage, FruitShopDao shopDao) {
        initHandler(strategyMap, storage, shopDao);
    }
    
    private void initHandler(Map<ShopActions, ShopAction> strategyMap,
                             FruitShopStorage storage,
                             FruitShopDao shopDao) {
        strategyMap.put(ShopActions.SUPPLY, new SupplyAction(storage, shopDao));
        strategyMap.put(ShopActions.PURCHASE, new PurchaseAction(storage, shopDao));
        strategyMap.put(ShopActions.RETURN, new ReturnAction(storage, shopDao));
        strategyMap.put(ShopActions.BALANCE, new BalanceAction(storage, shopDao));
    }
    
    public ShopAction getAction(ShopActions actionType) {
        return strategyMap.get(actionType);
    }
}
