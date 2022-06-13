package mate.academy.service.calculation;

import mate.academy.model.FruitTransaction;
import mate.academy.service.ParseFile;
import mate.academy.storage.Storage;

import java.util.Map;

public class TransactionPurchase implements TransactionCalculation {
    Map<String, Integer> currentData = Storage.storage;

    @Override
    public Map<String, Integer> calculate(ParseFile parseFile) {
        for (FruitTransaction transaction : parseFile.parseFile()) {
            int subtructQuantity = currentData.get(transaction.getFruite()) - transaction.getQuantity();
            if (transaction.getOperation().equals(FruitTransaction.Operation.PURCHASE.getOperations())) {
                currentData.put(transaction.getFruite(),
                        subtructQuantity);
            }
            if (subtructQuantity < 0) {
                throw new RuntimeException("Purchase can't be greater than sum of balance and supply");
            }
        }
        return currentData;
    }
}