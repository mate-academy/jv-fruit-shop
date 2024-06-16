package core.basesyntax.dataservices;

import core.basesyntax.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessImpl implements DataProcess {
    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        Map<String, Integer> balanceMap = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            balanceMap.putIfAbsent(transaction.getFruit(), 0);

            switch (transaction.getOperation()) {
                case BALANCE -> balanceMap.put(transaction.getFruit(), transaction.getQuantity());
                case SUPPLY, RETURN -> balanceMap.put(transaction.getFruit(),
                        balanceMap.get(transaction.getFruit()) + transaction.getQuantity());
                case PURCHASE -> balanceMap.put(transaction.getFruit(),
                        balanceMap.get(transaction.getFruit()) - transaction.getQuantity());
                default -> throw new IllegalArgumentException("Invalid transaction type: "
                        + transaction.getOperation());
            }
        }
        return balanceMap;
    }
}
