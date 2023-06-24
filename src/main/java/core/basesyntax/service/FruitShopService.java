package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.stragegyfactory.StrategyFactory;
import java.util.List;

public class FruitShopService {

    public void processFruitTransaction(List<FruitTransaction> fruitTransactions) {
        StrategyFactory strategyFactory = new StrategyFactory();
        OperationHandler operationHandler;
        for (FruitTransaction f : fruitTransactions) {
            operationHandler = strategyFactory.getFruitService(f.getOperation());
            operationHandler.moveFruit(f.getFruit(), f.getQuantity());
        }
    }
}
