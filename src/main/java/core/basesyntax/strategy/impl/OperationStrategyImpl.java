package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitInputData;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.StorageUpdateHandler;
import java.util.List;

public class OperationStrategyImpl implements OperationStrategy {
    private static final String HANDLER_SELECTION_FAILURE = "Cannot find operation with code {%s}!";
    private final List<StorageUpdateHandler> handlersList;

    public OperationStrategyImpl(List<StorageUpdateHandler> handlersList) {
        this.handlersList = handlersList;
    }

    @Override
    public void manageStorageCells(FruitInputData fruitInputData) {
        StorageUpdateHandler storageUpdateService = handlersList.stream()
                .filter(service -> service.isServiceApplicable(fruitInputData.getOperationCode()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String
                        .format(HANDLER_SELECTION_FAILURE, fruitInputData.getOperationCode())));
        storageUpdateService.updateStorage(fruitInputData.getFruitName(),
                fruitInputData.getAmount());
    }
}
