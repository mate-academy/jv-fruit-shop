package core.basesyntax.service.impl;

import core.basesyntax.service.ProcessingService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ProcessingServiceImpl implements ProcessingService {
    private static final int HEADER_REMOVER = 0;
    private static final String SEPARATOR = ",";
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public void removeHeading(List<String> list) {
        list.remove(HEADER_REMOVER);
    }

    @Override
    public void processData(List<String> dayStatistics, OperationStrategy strategy) {
        for (String datum : dayStatistics) {
            String fruitType = datum.split(SEPARATOR)[FRUIT_TYPE_INDEX];
            Integer quantity = Integer.parseInt(datum.split(SEPARATOR)[QUANTITY_INDEX]);
            strategy.getHandler(datum).operateStorage(fruitType,quantity);
        }
    }
}
