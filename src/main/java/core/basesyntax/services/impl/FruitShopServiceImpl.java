package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handlers.FruitOperationHandler;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.dtos.FruitDtoTransaction;
import core.basesyntax.services.interfaces.FruitShopService;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String FIRST_COLUMN_TITLE = "fruit";
    private static final String SECOND_COLUMN_TITLE = "quantity";
    private static final String COLUMN_SEPARATOR = ",";
    private final Map<OperationType, FruitOperationHandler> operationHandlerMap;

    public FruitShopServiceImpl(Map<OperationType, FruitOperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void applyTransactions(List<FruitDtoTransaction> fruitDtoTransactions) {
        for (FruitDtoTransaction fruitDtoTransaction : fruitDtoTransactions) {
            operationHandlerMap.get(fruitDtoTransaction.getOperationType())
                    .apply(fruitDtoTransaction);
        }
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_COLUMN_TITLE)
                     .append(COLUMN_SEPARATOR)
                     .append(SECOND_COLUMN_TITLE)
                     .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : Storage.getFruits().entrySet()) {
            stringBuilder.append(fruitIntegerEntry.getKey().getName())
                         .append(COLUMN_SEPARATOR)
                         .append(fruitIntegerEntry.getValue())
                         .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
