package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftoversHandlerImpl implements LeftoversHandler {
    private OperationStrategy operationStrategy;

    public LeftoversHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String getLeftovers(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitAmount = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            int newQuantity = operationStrategy
                    .get(transaction.getOperation())
                    .getOperationHandler(fruitAmount
                            .getOrDefault(transaction.getFruit(), 0), transaction.getQuantity());
            fruitAmount.put(transaction.getFruit(), newQuantity);
        }
        isValidQuantity(fruitAmount);
        return mapToString(fruitAmount);
    }

    private void isValidQuantity(Map<String, Integer> fruitAmount) {
        for (Integer value : fruitAmount.values()) {
            if (value < 0) {
                throw new RuntimeException("The total amount of fruit is negative. "
                        + "Please check transactions data");
            }
        }
    }

    private String mapToString(Map<String, Integer> amountFruits) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> amounts : amountFruits.entrySet()) {
            builder.append(amounts.getKey())
                    .append(",")
                    .append(amounts.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
