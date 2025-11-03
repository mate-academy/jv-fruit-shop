package core.basesyntax.service.impl;

import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<String> fruitData) {
        fruitData.stream()
                .map(FruitParser::parse)
                .forEach(fruitTransaction -> {
                    OperationHandler operationHandler = operationStrategy
                            .get(fruitTransaction.getOperationType());

                    operationHandler.pushToStorage(fruitTransaction);
                });
    }
}
