package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.factory.OperationHandlerFactory;
import core.basesyntax.factory.impl.OperationHandlerFactoryImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataServiceImpl implements ProcessDataService {
    private static final OperationHandlerFactory operationHandlerFactory =
            new OperationHandlerFactoryImpl();

    @Override
    public void processData(List<Fruit> fruits) {
        Map<String, Integer> storage = new HashMap<>();
        for (Fruit fruit : fruits) {
            OperationHandler handler = operationHandlerFactory.getHandler(fruit.operation());
            int amount = handler.calculate(fruit.quantity());
            storage.merge(fruit.name(), amount, Integer::sum);
        }
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Total amount for "
                        + entry.getKey() + " cannot be negative");
            }
        }
        Storage.setElements(storage);
    }
}
