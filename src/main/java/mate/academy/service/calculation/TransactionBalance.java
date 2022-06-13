package mate.academy.service.calculation;

import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ParseFile;
import mate.academy.storage.Storage;

public class TransactionBalance implements TransactionCalculation {
    private Map<String, Integer> currentData = Storage.storage;

    @Override
    public Map<String, Integer> calculate(ParseFile parseFile) {
        for (FruitTransaction transaction : parseFile.parseFile()) {
            if (transaction.getOperation()
                    .equals(FruitTransaction.Operation.BALANCE.getOperations())) {
                currentData.put(transaction.getFruit(), transaction.getQuantity());
            }
        }
        return currentData;
    }
}
