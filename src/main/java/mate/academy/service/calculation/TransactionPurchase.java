package mate.academy.service.calculation;

import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ParseFile;
import mate.academy.storage.Storage;

public class TransactionPurchase implements TransactionCalculation {
    private Map<String, Integer> currentData = Storage.storage;

    @Override
    public Map<String, Integer> calculate(ParseFile parseFile) {
        for (FruitTransaction transaction : parseFile.parseFile()) {
            int subtQuantity = currentData.get(transaction.getFruit()) - transaction.getQuantity();
            if (transaction.getOperation()
                             .equals(FruitTransaction.Operation.PURCHASE.getOperations())) {
                currentData.put(transaction.getFruit(),
                        subtQuantity);
            }
            if (subtQuantity < 0) {
                throw new RuntimeException("Purchase can't be "
                        + "greater than sum of balance and supply");
            }
        }
        return currentData;
    }
}
