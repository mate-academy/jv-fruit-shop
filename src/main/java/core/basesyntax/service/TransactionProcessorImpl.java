package core.basesyntax.service;

import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.QuantityCounterStrategy;
import core.basesyntax.transaction.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private static final int DEFAULT_QUANTITY = 0;
    private QuantityCounterStrategy quantityCounterStrategy;
    private QuantityCounter quantityCounter;

    public TransactionProcessorImpl(QuantityCounterStrategy quantityCounterStrategy) {
        this.quantityCounterStrategy = quantityCounterStrategy;
    }

    @Override
    public void process(List<Transaction> transactions, Storage storage) {
        isNullList(transactions);
        Map<String, Integer> endOfDayQuantityMap = new HashMap<>();
        List<String> storeProductNames = getStoreProductNames(transactions);
        for (String product : storeProductNames) {
            endOfDayQuantityMap.put(product, getProductFinalQuantity(transactions, product));
        }
        storage.setProductsMap(endOfDayQuantityMap);
    }

    private int getProductFinalQuantity(List<Transaction> operationsList, String product) {
        int finalQuantity = DEFAULT_QUANTITY;
        for (Transaction operation : operationsList) {
            if (operation.getProduct().equals(product)) {
                isQuantityNegative(operation);
                quantityCounter = quantityCounterStrategy.get(operation);
                finalQuantity = quantityCounter.count(finalQuantity,
                                    operation.getQuantity());
            }
        }
        isFinalQuantityNegative(finalQuantity);
        return finalQuantity;
    }

    private List<String> getStoreProductNames(List<Transaction> operationsList) {
        return operationsList.stream()
                .map(Transaction::getProduct)
                .distinct()
                .toList();
    }

    private void isFinalQuantityNegative(int finalQuantity) {
        if (finalQuantity < 0) {
            throw new RuntimeException("End of the day quantity can't be negative");
        }
    }

    private void isQuantityNegative(Transaction operation) {
        if (operation.getQuantity() < 0) {
            throw new RuntimeException("Quantity can't be negative");
        }
    }

    private void isNullList(List<Transaction> operationsList) {
        if (operationsList == null) {
            throw new RuntimeException("No operations in the List");
        }
    }
}
