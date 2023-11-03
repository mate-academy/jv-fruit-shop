
package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceTypeHandler;
import core.basesyntax.strategy.operation.OperationHandlers;
import core.basesyntax.strategy.operation.PurchaseTypeHandler;
import core.basesyntax.strategy.operation.ReturnTypeHandler;
import core.basesyntax.strategy.operation.SupplyTypeHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodStoreServiceImpl implements FoodStoreService {
    private Map<FruitTransaction.Operation, OperationHandlers> operationHandlersMap =
            new HashMap<>() {
                {
                    put(FruitTransaction.Operation.BALANCE, new BalanceTypeHandler());
                    put(FruitTransaction.Operation.SUPPLY, new SupplyTypeHandler());
                    put(FruitTransaction.Operation.PURCHASE, new PurchaseTypeHandler());
                    put(FruitTransaction.Operation.RETURN, new ReturnTypeHandler());
                }
            };
    private OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationHandlersMap);

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionsList) {
        for (FruitTransaction transaction : fruitTransactionsList) {
            operationStrategy.getHandler(transaction.getOperation()).handleTransaction(transaction);
        }
    }
}

