package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public FruitServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitTransaction
                -> operationHandlerMap.get(fruitTransaction.getOperation())
                .proceed(fruitTransaction));
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruits,quantity");
        for (Map.Entry<Fruit, Integer> fruit : Storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue());
        }
        return stringBuilder.toString();
    }
}
