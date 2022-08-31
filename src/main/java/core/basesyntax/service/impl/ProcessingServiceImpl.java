package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class ProcessingServiceImpl implements ProcessingService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final FruitStrategy fruitStrategy;
    private final List<String> data;

    public ProcessingServiceImpl(FruitStrategy fruitStrategy, List<String> data) {
        this.fruitStrategy = fruitStrategy;
        this.data = data;
    }

    @Override
    public void process() {
        for (String line : data) {
            String[] splitLine = line.split(COMMA);
            OperationHandler operation = fruitStrategy.getByOperation(splitLine[OPERATION_INDEX]);
            if (operation == null) {
                continue;
            }
            operation.execute(new Fruit(splitLine[FRUIT_INDEX]),
                    Integer.valueOf(splitLine[QUANTITY_INDEX]));
        }
    }
}
