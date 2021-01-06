package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String HEAD_OF_REPORT = "fruit,quantity";
    private static final String SPLITTER = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveToStorage(List<String> rows) {
        for (int i = 1; i < rows.size(); i++) {
            String[] data = rows.get(i).split(SPLITTER);
            operationStrategy.get(Operations.valueOf(data[OPERATION].toUpperCase()))
                    .doOperation(new Fruit(data[FRUIT]), Integer.parseInt(data[AMOUNT]));
        }
    }

    @Override
    public List<String> getFromStorage() {
        List<String> list = new ArrayList<>();
        list.add(HEAD_OF_REPORT);
        for (Map.Entry<Fruit, Integer> entry: Storage.getFruits().entrySet()) {
            StringBuilder row = new StringBuilder();
            row.append(System.lineSeparator())
                    .append(entry.getKey().getName()).append(SPLITTER).append(entry.getValue());
            list.add(row.toString());
        }
        return list;
    }
}
