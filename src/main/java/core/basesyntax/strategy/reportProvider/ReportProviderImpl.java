package core.basesyntax.strategy.reportProvider;

import core.basesyntax.model.FruitTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportProviderImpl implements ReportProvider {

    @Override
    public Map<String, Integer> processData(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitQuantities = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            int quantity = fruitQuantities.getOrDefault(transaction.getFruit(), 0);
            switch (transaction.getOperation()) {
                case BALANCE, SUPPLY, RETURN -> quantity += transaction.getQuantity();
                case PURCHASE -> quantity -= transaction.getQuantity();
                default -> throw new RuntimeException("No such operation");
            }
            fruitQuantities.put(transaction.getFruit(), quantity);
        }
        return fruitQuantities;

    }
}
