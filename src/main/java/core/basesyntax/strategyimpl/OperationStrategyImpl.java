package core.basesyntax.strategyimpl;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        Map<FruitTransaction.Operation, OperationHandler> strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        return strategy.get(operation);
    }
}
