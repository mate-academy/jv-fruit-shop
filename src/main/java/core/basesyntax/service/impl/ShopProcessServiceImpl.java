package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ShopProcessService;
import java.util.List;

public class ShopProcessServiceImpl implements ShopProcessService {
    private OperationStrategyService operationStrategyService;

    public ShopProcessServiceImpl(OperationStrategyService operationStrategyService) {
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
