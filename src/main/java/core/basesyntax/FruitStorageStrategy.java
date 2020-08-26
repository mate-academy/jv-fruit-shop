package core.basesyntax;

import core.basesyntax.operation.Buy;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.Return;
import core.basesyntax.operation.Supply;

import java.util.List;

public class FruitStorageStrategy {
    public static void storageOperation(List<Transaction> transactionList) {
        Operation operation;
        for (Transaction transaction : transactionList) {
            if (transaction.getOperation().equals("s")) {
                operation = new Supply();
            } else if (transaction.getOperation().equals("b")) {
                operation = new Buy();
            } else if (transaction.getOperation().equals("r")) {
                operation = new Return();
            } else {
                throw new RuntimeException("No such operation");
            }
            operation.provideOperation(transaction);
        }
    }
}
