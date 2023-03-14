package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.implementation.BalanceOperationStrategy;
import core.basesyntax.strategy.implementation.PurchaseOperationStrategy;
import core.basesyntax.strategy.implementation.ReturnOperationStrategy;
import core.basesyntax.strategy.implementation.SupplyOperationStrategy;
import java.util.Map;

public class OperationStrategyServiceImpl implements OperationStrategyService {
    private final Map<FruitTransaction.Operation, OperationStrategy> operationStrategyMap;

    public OperationStrategyServiceImpl() {
        operationStrategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationStrategy(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationStrategy(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationStrategy(),
                FruitTransaction.Operation.RETURN, new ReturnOperationStrategy());
    }

    @Override
    public void applyOperationStrategy(FruitTransaction fruitTransaction) {
        FruitTransaction.Operation operation = fruitTransaction.getOperation();
        if (operation == null || operationStrategyMap.get(operation) == null) {
            throw new RuntimeException("Invalid input operation");
        }
        OperationStrategy strategy = operationStrategyMap.get(operation);
        strategy.apply(fruitTransaction);
    }
}
