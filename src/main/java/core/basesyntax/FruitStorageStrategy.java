package core.basesyntax;

import core.basesyntax.operation.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorageStrategy {
    public static Map<String, Operation> fruitStorageStrategy = new HashMap<>();

    public static void storageOperation(List<Transaction> transactionList) {
        for (Transaction t : transactionList) {
            fruitStorageStrategy.get(t.getOperation()).provideOperation(t);
        }
    }
}
