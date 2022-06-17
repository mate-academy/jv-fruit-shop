package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.StorageService;
import java.util.List;

public class StorageServiceImpl implements StorageService {

    @Override
    public void saveAll(List<String[]> fruits, OperationStrategy operationStrategy) {
        for (String[] line: fruits) {
            operationStrategy.getOperationHandler(line[0])
                    .execute(line[1], Integer.parseInt(line[2]));
        }
    }

    @Override
    public void add(String fruit, Integer amount) {
        if (Storage.fruits.containsKey(fruit)) {
            Integer newAmount = Storage.fruits.get(fruit) + amount;
            Storage.fruits.put(fruit, newAmount);
        } else {
            Storage.fruits.put(fruit, amount);
        }
    }

    @Override
    public void subtract(String fruit, Integer amount) {
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) - amount);
        } else {
            Storage.fruits.put(fruit, amount);
        }
    }
}
