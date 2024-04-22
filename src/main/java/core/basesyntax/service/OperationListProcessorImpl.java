package core.basesyntax.service;

import core.basesyntax.operation.StoreOperation;
import core.basesyntax.strategy.QuantityCounterStrategy;
import core.basesyntax.strategy.QuantityCounterStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationListProcessorImpl implements OperationListProcessor {
    private static final int DEFAULT_QUANTITY = 0;
    private QuantityCounterStrategy quantityCounterStrategy = new QuantityCounterStrategyImpl();
    private QuantityCounter quantityCounter;

    @Override
    public Map<String, Integer> process(List<StoreOperation> operationsList) {
        isNullList(operationsList);
        Map<String, Integer> endOfDayQuantityMap = new HashMap<>();
        List<String> storeProductNames = getStoreFruitNames(operationsList);
        for (String product : storeProductNames) {
            endOfDayQuantityMap.put(product, getProductFinalQuantity(operationsList, product));
        }
        return endOfDayQuantityMap;
    }

    private List<String> getStoreFruitNames(List<StoreOperation> operationsList) {
        return operationsList.stream()
                .map(StoreOperation::getFruit)
                .distinct()
                .toList();
    }

    private int getProductFinalQuantity(List<StoreOperation> operationsList, String product) {
        int finalQuantity = DEFAULT_QUANTITY;
        for (StoreOperation operation : operationsList) {
            if (operation.getFruit().equals(product)) {
                isQuantityNegative(operation);
                quantityCounter = quantityCounterStrategy.get(operation);
                finalQuantity = quantityCounter.count(finalQuantity,
                                    operation.getQuantity());
            }
        }
        isFinalQuantityNegative(finalQuantity);
        return finalQuantity;
    }

    private void isFinalQuantityNegative(int finalQuantity) {
        if (finalQuantity < 0) {
            throw new RuntimeException("End of the day quantity can't be negative");
        }
    }

    private void isQuantityNegative(StoreOperation operation) {
        if (operation.getQuantity() < 0) {
            throw new RuntimeException("Quantity can't be negative");
        }
    }

    private void isNullList(List<StoreOperation> operationsList) {
        if (operationsList == null) {
            throw new RuntimeException("No operations in the List");
        }
    }
}
