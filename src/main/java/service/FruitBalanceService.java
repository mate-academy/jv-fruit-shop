package service;

import exceptions.BalanceException;
import java.util.HashMap;
import java.util.Map;

public class FruitBalanceService implements BalanceService<String, Integer> {
    private static final Map<String, Integer> fruitsBalance = new HashMap<>();

    @Override
    public void updateBalance(String fruit, Integer quantity) {
        if (fruitsBalance.containsKey(fruit)) {
            if (fruitsBalance.get(fruit) + quantity >= 0) {
                fruitsBalance.put(fruit, fruitsBalance.get(fruit) + quantity);
                return;
            }
            throw new RuntimeException("Bad operation :(, it can't be that 0 > fruits");
        }
        if (quantity > 0) {
            fruitsBalance.put(fruit, quantity);
            return;
        }
        throw new BalanceException("Quantity can't be smaller then zero.");
    }

    @Override
    public Integer getBalance(String fruit) {
        if (fruitsBalance.containsKey(fruit)) {
            return fruitsBalance.get(fruit);
        }
        throw new BalanceException("There is no element like this :(");
    }

    @Override
    public String getAll() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry entry : fruitsBalance.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        String result = builder.toString();
        return result.substring(0, result.length() - 1);
    }
}
