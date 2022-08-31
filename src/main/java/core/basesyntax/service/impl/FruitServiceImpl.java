package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;
    private final FruitDao fruitDao;

    public FruitServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap,
                            FruitDao fruitDao) {
        this.operationHandlerMap = operationHandlerMap;
        this.fruitDao = fruitDao;
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
        for (Map.Entry<Fruit, Integer> fruit : fruitDao.getAll().entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue());
        }
        return stringBuilder.toString();
    }
}
