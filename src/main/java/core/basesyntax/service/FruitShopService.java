package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FactoryStrategy;
import core.basesyntax.strategy.Operation;
import java.util.List;

public class FruitShopService {
    private final FactoryStrategy factoryStrategy;

    public FruitShopService(FactoryStrategy factoryStrategy) {
        this.factoryStrategy = factoryStrategy;
    }

    public void processing(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            Operation operationService = factoryStrategy
                    .getOperationService(transaction.getOperation());
            operationService.executeOperation(transaction.getFruit(), transaction.getAmount());
        }
    }
}
