package strategy;

import db.ShopStorage;
import model.FruitTransaction;
import java.util.List;
import java.util.Map;

public class FruitShopStrategyImpl implements FruitShopStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> fruitShopStrategyMap;
    private final ShopStorage fruitStorage;

    public FruitShopStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> fruitShopStrategyMap,
                                 ShopStorage fruitStorage) {
        this.fruitShopStrategyMap = fruitShopStrategyMap;
        this.fruitStorage = fruitStorage;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            fruitShopStrategyMap.get(transaction.getOperation()).handle(transaction, fruitStorage);
        }
    }
}
