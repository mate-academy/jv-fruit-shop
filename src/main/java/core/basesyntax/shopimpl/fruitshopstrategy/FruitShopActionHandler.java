package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopTransaction;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitShopActionHandler {
    private final Map<ShopTransactionsType, ShopTransaction> strategyMap = new HashMap<>();
    
    public FruitShopActionHandler(AbstractStorage<DataRecord, Fruit> storage,
                                  ShopDao<DataRecord> shopDao) {
        initHandler(strategyMap, storage, shopDao);
    }
    
    public ShopTransaction getAction(ShopTransactionsType actionType) {
        return strategyMap.get(actionType);
    }
    
    private void initHandler(Map<ShopTransactionsType, ShopTransaction> strategyMap,
                             AbstractStorage<DataRecord, Fruit> storage,
                             ShopDao<DataRecord> shopDao) {
        strategyMap.put(ShopTransactionsType.SUPPLY, new SupplyTransaction(storage, shopDao));
        strategyMap.put(ShopTransactionsType.PURCHASE, new PurchaseTransaction(storage, shopDao));
        strategyMap.put(ShopTransactionsType.RETURN, new ReturnTransaction(storage, shopDao));
        strategyMap.put(ShopTransactionsType.BALANCE, new BalanceTransaction(storage, shopDao));
    }
}
