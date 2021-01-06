package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Arrays;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String[] HEADER = {"type", "fruit", "quantity"};

    @Override
    public void processActivities(List<String[]> incomeAlgorithm) {
        for (String[] algorithm : incomeAlgorithm.subList(1, incomeAlgorithm.size())) {
            Operation operation = Operation.fromString(algorithm[OPERATION_INDEX]);
            Fruit fruit = new Fruit(algorithm[FRUIT_INDEX]);
            Integer quantity = Integer.parseInt(algorithm[QUANTITY_INDEX]);
            TransactionDto dto = new TransactionDto(operation, fruit, quantity);
            OperationStrategy.chooseTheStrategy(dto);
        }
    }
}
