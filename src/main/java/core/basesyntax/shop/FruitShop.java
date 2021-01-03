package core.basesyntax.shop;

import java.util.HashMap;
import java.util.Map;

public class FruitShop implements Shop {
    private Map<String, Integer> balance = new HashMap<>();

    @Override
    public Map<String, Integer> getBalance() {
        return balance;
    }

    @Override
    public void supply(String fruit, Integer quantity) {
        balance.put(fruit, balance.get(fruit) + quantity);
    }

    @Override
    public void purchase(String fruit, Integer quantity) {
        balance.put(fruit, balance.get(fruit) - quantity);
    }

    @Override
    public void returnProduct(String fruit, Integer quantity) {
        balance.put(fruit, balance.get(fruit) + quantity);
    }
}
