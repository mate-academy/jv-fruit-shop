package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void runOtherOperationsOverFruit(List<String[]> otherOperations,
                                            OperationStrategy operationStrategy) {
        for (String[] strings : otherOperations) {
            operationStrategy.get(strings[0])
                    .getOperation(strings[1], Integer.parseInt(strings[2]));
        }
    }
}
