package core.basesyntax.servise.impl;

import core.basesyntax.servise.FruitService;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int OFFSET = 1;
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategy strategy;

    public FruitServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processData(List<String> inputData) {
        inputData.stream()
                .skip(OFFSET)
                .map(line -> line.split(","))
                .map(array -> new FruitTransaction(
                        array[TYPE_INDEX],
                        array[FRUIT_INDEX],
                        Integer.parseInt(array[QUANTITY_INDEX])))
                .forEach(transaction -> strategy.getOperationHandler(transaction)
                        .calculation(transaction));
    }
}
