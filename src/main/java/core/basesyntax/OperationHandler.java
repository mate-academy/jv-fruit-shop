package core.basesyntax;

import java.util.List;

public class OperationHandler {
    public static void handleOperation(List<Transaction> transactionList) {
        for (Transaction t : transactionList) {
            FruitStorageStrategy.fruitStorageStrategy.get(t.getOperation()).provideOperation(t);
        }
    }
}
