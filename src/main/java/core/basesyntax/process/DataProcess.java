package core.basesyntax.process;

import core.basesyntax.storage.FruitStorage;
import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.ShopStrategy;
import core.basesyntax.strategyhandler.StrategyHandlerImpl;
import java.util.List;

public class DataProcess {
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_FRUIT_TYPE = 1;
    private static final int INDEX_QUANTITY = 2;

    public void addDataToStorage(List<String> list, FruitStorage fruitStorage) {
        StrategyHandlerImpl cps = new StrategyHandlerImpl();
        list.stream()
                .map(l -> l.split(","))
                .forEach(arr -> {
                    FruitTransaction.Operation operation
                            = FruitTransaction.Operation.getByCode(arr[INDEX_OPERATION_TYPE]);
                    ShopStrategy shopStrategy = cps.strategyHandler(operation);
                    shopStrategy.editFruitStorageData(fruitStorage, arr[INDEX_FRUIT_TYPE],
                            Integer.parseInt(arr[INDEX_QUANTITY]));
                });
    }

}
