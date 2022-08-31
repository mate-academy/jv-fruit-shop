package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class ProcessingServiceImpl implements ProcessingService {
    private static final String CSV_LINE_SPLITERATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final FruitStrategy fruitStrategy;
    private final List<String> data;
    private final Map<String, OperationHandler> strategyMap;

    public ProcessingServiceImpl(FruitStrategy fruitStrategy, List<String> data,
                                 Map<String, OperationHandler> strategyMap) {
        this.fruitStrategy = fruitStrategy;
        this.data = data;
        this.strategyMap = strategyMap;
    }

    @Override
    public void process() {
        for (String line : data) {
            String[] splitLine = line.split(CSV_LINE_SPLITERATOR);
            if (!strategyMap.containsKey(splitLine[OPERATION_INDEX])) {
                continue;
            }
            fruitStrategy.getByOperation(splitLine[OPERATION_INDEX])
                    .execute(new Fruit(splitLine[FRUIT_INDEX]),
                            Integer.valueOf(splitLine[QUANTITY_INDEX]));
        }
    }
}
