package core.basesyntax.service.impl;

import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int LINE_OF_FIRST_OPERATION = 1;
    private static final int QUANTITY_INDEX = 2;
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<String> lines) {
        for (int i = LINE_OF_FIRST_OPERATION; i < lines.size(); i++) {
            String[] splittedLine = lines.get(i).split(",");
            int parseQuantityToInt = Integer.parseInt(splittedLine[QUANTITY_INDEX]);
            operationStrategy.get(splittedLine[OPERATION_INDEX])
                    .handle(splittedLine[NAME_INDEX], parseQuantityToInt);
        }
    }
}
