package core.basesyntax;

import core.basesyntax.service.StorageActionsService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionImpl implements FruitTransaction {
    private static final String PROCEDURE = "Addition";
    private static final String SEPARATOR = ",";
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategy strategy;
    private final StorageActionsService storageActions;

    FruitTransactionImpl(OperationStrategy strategy, StorageActionsService storageActions) {
        this.strategy = strategy;
        this.storageActions = storageActions;
    }

    @Override
    public void processData(List<String> dayData) {
        for (String datum : dayData) {
            String fruitType = datum.split(SEPARATOR)[FRUIT_TYPE_INDEX];
            Integer quantity = Integer.parseInt(datum.split(SEPARATOR)[QUANTITY_INDEX]);
            String procedure = strategy.getHandler(datum).getProcedure();
            operateStorage(procedure, fruitType, quantity);
        }
    }

    private void operateStorage(String procedure, String fruitType, Integer quantity) {
        if (procedure.equals(PROCEDURE)) {
            storageActions.addToStorage(fruitType, quantity);
        } else {
            storageActions.removeFromStorage(fruitType, quantity);
        }
    }
}
