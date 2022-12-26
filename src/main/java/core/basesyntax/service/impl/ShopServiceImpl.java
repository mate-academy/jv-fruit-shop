package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationStrategy;
import core.basesyntax.strategy.ReturnOperationStrategy;
import core.basesyntax.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    private final Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
    private final OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);

    @Override
    public void makeTransaction(FruitTransaction fruitTransaction) {
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationStrategy());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationStrategy());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationStrategy());
        OperationHandler operationHandler = operationStrategy.get(fruitTransaction.getOperation());
        operationHandler.handle(fruitTransaction);
    }
}
