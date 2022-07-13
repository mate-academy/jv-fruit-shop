package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.stream()
                .filter(transaction ->
                        transaction.getOperation() == FruitTransaction.Operation.BALANCE)
                .forEach(transaction -> {
                    OperationHandler operationHandler
                            = operationStrategy.get(transaction.getOperation());
                    operationHandler.calculate(transaction);
                });

        fruitTransactions.stream()
                .filter(transaction ->
                        transaction.getOperation() == FruitTransaction.Operation.PURCHASE
                                || transaction.getOperation() == FruitTransaction.Operation.RETURN
                                || transaction.getOperation() == FruitTransaction.Operation.SUPPLY)
                .forEach(transaction -> {
                    OperationHandler operationHandler
                            = operationStrategy.get(transaction.getOperation());
                    operationHandler.calculate(transaction);
                });
    }
}
