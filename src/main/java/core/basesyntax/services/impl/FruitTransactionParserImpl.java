package core.basesyntax.services.impl;

import core.basesyntax.services.FruitTransactionParser;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    @Override
    public void runOtherOperationsOverFruit(List<String[]> otherOperations,
                                            OperationStrategy operationStrategy) {
        for (String[] strings : otherOperations) {
            operationStrategy.get(strings[0])
                    .getOperation(strings[1], Integer.parseInt(strings[2]));
        }
    }
}
