package core.basesyntax.process;

import core.basesyntax.processhandler.ProcessHandler;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategyhandler.StrategyHandlerImpl;
import java.util.List;
import java.util.Map;

public class DataProcess {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public void addDataToStorage(List<String> list, FruitStorage fruitStorage,
                                 Map<FruitTransaction.Operation, OperationHandler> strategyMap) {
        StrategyHandlerImpl strategyHandler = new StrategyHandlerImpl();
        list.stream()
                .map(element -> element.split(","))
                .forEach(arr -> {
                    FruitTransaction.Operation operation
                            = FruitTransaction.Operation.getByCode(arr[OPERATION_TYPE_INDEX]);
                    OperationHandler shopStrategy
                            = strategyHandler.strategyHandler(operation, strategyMap);
                    ProcessHandler processHandler = new ProcessHandler();
                    shopStrategy.editFruitStorageData(fruitStorage,
                            processHandler.fruitTypeHandler(arr[FRUIT_TYPE_INDEX]),
                            processHandler.quantityHandler(arr[QUANTITY_INDEX]));
                });
    }
}
