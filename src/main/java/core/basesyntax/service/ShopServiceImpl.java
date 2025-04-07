package core.basesyntax.service;

import core.basesyntax.service.operationhandler.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        transactionList.stream()
                .forEach(f -> {
                    OperationHandler operationHandler
                            = operationStrategy.getHandler(f.getOperation());
                    operationHandler.process(f);
                });
    }
}
