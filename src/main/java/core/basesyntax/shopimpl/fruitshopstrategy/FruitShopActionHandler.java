package core.basesyntax.shopimpl.fruitshopstrategy;

import core.basesyntax.model.shopstrategy.ShopTransaction;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import java.util.HashMap;
import java.util.Map;

public class FruitShopActionHandler {
    private final Map<ShopTransactionsType, ShopTransaction> strategyMap = new HashMap<>();
    
    public FruitShopActionHandler() {
        initHandler();
    }
    
    public ShopTransaction getAction(ShopTransactionsType actionType) {
        return strategyMap.get(actionType);
    }
    
    private void initHandler() {
        strategyMap.put(ShopTransactionsType.SUPPLY, new SupplyTransaction());
        strategyMap.put(ShopTransactionsType.PURCHASE, new PurchaseTransaction());
        strategyMap.put(ShopTransactionsType.RETURN, new ReturnTransaction());
        strategyMap.put(ShopTransactionsType.BALANCE, new BalanceTransaction());
    }
}
