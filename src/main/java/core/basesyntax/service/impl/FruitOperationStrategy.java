package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.impl.strategy.BalanceOperationServiceImpl;
import core.basesyntax.service.impl.strategy.PurchaseOperationServiceImpl;
import core.basesyntax.service.impl.strategy.ReturnOperationServiceImpl;
import core.basesyntax.service.impl.strategy.SupplyOperationServiceImpl;
import java.util.Map;

public class FruitOperationStrategy {
    private static final Map<FruitTransaction.Operation, OperationService<FruitTransaction>>
            operationServiceMap =
            Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationServiceImpl(),
                    FruitTransaction.Operation.RETURN, new ReturnOperationServiceImpl(),
                    FruitTransaction.Operation.PURCHASE, new PurchaseOperationServiceImpl(),
                    FruitTransaction.Operation.SUPPLY, new SupplyOperationServiceImpl());

    public OperationService<FruitTransaction> getOperationService(FruitTransaction transaction) {
        FruitTransaction.Operation inputOperation = transaction.getOperation();

        if (operationServiceMap.containsKey(inputOperation)) {
            return operationServiceMap.get(inputOperation);
        } else {
            throw new InvalidOperationException("Unknown operation value: " + inputOperation);
        }
    }
}
