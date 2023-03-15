package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.FactoryStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {

    @Override
    public void processFruitTransactions(List<FruitTransaction> fruitTransactions) {
        FactoryStrategy factoryStrategy = new FactoryStrategy();
        OperationHandler operationHandler;
        for (FruitTransaction transaction: fruitTransactions) {
            operationHandler = factoryStrategy.getFruitService(transaction.getOperation());
            operationHandler.handleFruitOperation(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
