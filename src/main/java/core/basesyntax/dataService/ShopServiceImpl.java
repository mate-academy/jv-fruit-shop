package core.basesyntax.dataService;

import core.basesyntax.transactions.FruitTransaction;
import core.basesyntax.transactions.OperationHandler;
import core.basesyntax.transactions.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
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
                    operationHandler.resultOfOperation(transaction.getFruit()
                            , transaction.getQuantity());

                });
    }
}
