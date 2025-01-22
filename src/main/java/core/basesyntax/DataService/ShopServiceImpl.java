package core.basesyntax.DataService;

import core.basesyntax.tranasctions.FruitTransaction;
import core.basesyntax.tranasctions.OperationHandler;
import core.basesyntax.tranasctions.OperationStrategy;

import java.util.List;

public class ShopServiceImpl implements ShopService{
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.stream()
                .forEach(transaction -> {
                    OperationHandler operationHandler = operationStrategy
                            .getOperation(transaction.getOperation());
                    operationHandler.resultOfOperation(transaction.getFruit(), transaction.getQuantity());

                });
    }
}
