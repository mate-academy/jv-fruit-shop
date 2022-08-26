package core.basesyntax.storage.impl;

import java.util.HashMap;
import java.util.Map;

public class Database<T> {
    private final Map<T, Integer> productBalance;

    public Database() {
        productBalance = new HashMap<>();
    }

    public Map<T, Integer> getBalance() {
        return Map.copyOf(productBalance);
    }

    public int getAmount(T objectT) {
        return productBalance.get(objectT);
    }

    public void updateBalance(T objectT, int amount) {
        productBalance.put(objectT, amount);
    }
}
