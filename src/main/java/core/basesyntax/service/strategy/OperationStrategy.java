package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.impl.BalanceOperationService;
import core.basesyntax.service.strategy.impl.PurchaseOperationService;
import core.basesyntax.service.strategy.impl.ReturnOperationService;
import core.basesyntax.service.strategy.impl.SupplyOperationService;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationService> operationServiceMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperationService(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationService(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationService(),
            FruitTransaction.Operation.RETURN, new ReturnOperationService());

    public OperationService getOperation(FruitTransaction fruitTransaction) {
        return operationServiceMap.get(fruitTransaction.getOperation());
    }
}
