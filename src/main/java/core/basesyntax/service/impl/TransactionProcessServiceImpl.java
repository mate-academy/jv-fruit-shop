package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.TransactionProcessService;
import java.util.List;

public class TransactionProcessServiceImpl implements TransactionProcessService {
    private final OperationStrategyService operationStrategyService;

    public TransactionProcessServiceImpl(OperationStrategyService operationStrategyService) {
        this.operationStrategyService = operationStrategyService;
    }

    @Override
    public void processData(List<FruitTransaction> transaction) {
        for (FruitTransaction fruitTransaction : transaction) {
            operationStrategyService.getHandler(fruitTransaction
                    .getOperation()).handle(fruitTransaction);
        }
    }
}
