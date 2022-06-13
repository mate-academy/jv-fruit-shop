package mate.academy.service.calculation;

import mate.academy.model.FruitTransaction;
import mate.academy.service.ParseFile;
import mate.academy.storage.Storage;

import java.util.Map;

public class TransactionReturn implements TransactionCalculation{
    Map<String, Integer> currentData = Storage.storage;
    @Override
    public Map<String, Integer> calculate(ParseFile parseFile) {
        for (FruitTransaction transaction : parseFile.parseFile()) {
            if (transaction.getOperation().equals(FruitTransaction.Operation.RETURN.getOperations())) {
                currentData.put(transaction.getFruite(),
                        transaction.getQuantity() + currentData.get(transaction.getFruite()));
            }
        }
        return currentData;
    }
}
