package core.basesyntax.servise;

import core.basesyntax.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessorImpl implements DataProcessor {
    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitStore = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            switch (transaction.getOperation()) {
                case BALANCE:
                case SUPPLY:
                case RETURN:
                    fruitStore.put(transaction.getFruit(),
                            fruitStore.getOrDefault(transaction.getFruit(), 0)
                                    + transaction.getQuantity());
                    break;
                case PURCHASE:
                    fruitStore.put(transaction.getFruit(),
                            fruitStore.getOrDefault(transaction.getFruit(), 0)
                                    - transaction.getQuantity());
                    break;
                default:
                    System.out.println("Error with process transactions" + transaction);
            }
        }
        return fruitStore;
    }
}
