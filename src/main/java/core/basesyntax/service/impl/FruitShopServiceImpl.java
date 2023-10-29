package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private OperationStrategy strategy;

    public FruitShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitQuantities = new HashMap<>();

        for (FruitTransaction fruitTransaction : transactions) {
            FruitTransaction.Operation operation = fruitTransaction.getOperation();
            OperationHandler handler = strategy.getOperationHandler(operation);

            if (handler != null) {
                fruitQuantities = handler.handleOperation(fruitTransaction, fruitQuantities);
            }
        }
        return fruitQuantities;
    }
}
