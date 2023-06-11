package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Operations;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String COMMA = ",";
    private final FruitStorage fruitStorage;

    public FruitServiceImpl(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            Operations operation = Operations.valueOf(transaction.getOperation()
                    .toString().toUpperCase());
            OperationHandler handler = operation.getHandler();
            handler.handleOperation(transaction, fruitStorage);
        }
    }

    @Override
    public void generateReport() {
        System.out.println(HEADER_LINE);
        for (Fruit fruit : fruitStorage.getAllFruits()) {
            System.out.println(fruit.getName() + COMMA + fruit.getQuantity());
        }
    }
}
