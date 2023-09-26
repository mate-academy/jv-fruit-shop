package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.OperationHandler;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperatorStrategy;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final OperatorStrategy operatorStrategy;

    public FruitTransactionServiceImpl(OperatorStrategy operatorStrategy) {
        this.operatorStrategy = operatorStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            OperationHandler operationHandler
                    = operatorStrategy.getOperatorHandler(fruitTransaction.getOperation());
            operationHandler.execute(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
