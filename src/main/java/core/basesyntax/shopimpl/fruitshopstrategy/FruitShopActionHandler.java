package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.shopstrategy.ShopTransaction;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.storage.FruitShopStorage;
import java.util.HashMap;
import java.util.Map;

public class FruitShopActionHandler {
    private final Map<ShopTransactionsTypes, ShopTransaction> strategyMap = new HashMap<>();
    
    public FruitShopActionHandler(FruitShopStorage storage, FruitShopDao shopDao) {
        initHandler(strategyMap, storage, shopDao);
    }
    
    private void initHandler(Map<ShopTransactionsTypes, ShopTransaction> strategyMap,
                             FruitShopStorage storage,
                             FruitShopDao shopDao) {
        strategyMap.put(ShopTransactionsTypes.SUPPLY, new SupplyTransaction(storage, shopDao));
        strategyMap.put(ShopTransactionsTypes.PURCHASE, new PurchaseTransaction(storage, shopDao));
        strategyMap.put(ShopTransactionsTypes.RETURN, new ReturnTransaction(storage, shopDao));
        strategyMap.put(ShopTransactionsTypes.BALANCE, new BalanceTransaction(storage, shopDao));
    }
    
    public ShopTransaction getAction(ShopTransactionsTypes actionType) {
        return strategyMap.get(actionType);
    }
}
