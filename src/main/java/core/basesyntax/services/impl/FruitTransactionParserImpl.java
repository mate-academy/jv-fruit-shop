package core.basesyntax.services.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.FruitTransactionParser;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    @Override
    public void runOperationsOverFruit(List<FruitTransaction> transactions,
                                       OperationStrategy operationStrategy) {
        for (FruitTransaction fruitTransaction : transactions) {
            operationStrategy.get(fruitTransaction.getOperation().);
        }
    }
}
