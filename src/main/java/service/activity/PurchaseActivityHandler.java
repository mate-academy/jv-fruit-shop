package service.activity;

import java.math.BigDecimal;
import java.util.Map;
import model.Fruit;
import model.FruitTransaction;

public class PurchaseActivityHandler implements ActivityHandler {
    @Override
    public Map<Fruit, BigDecimal> doActivity(Map<Fruit, BigDecimal> fruitBigDecimalMap,
                                             FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        BigDecimal amount = fruitTransaction.getAmount();
        if (!fruitBigDecimalMap.containsKey(fruit)) {
            throw new RuntimeException("Missing information about fruit balance, fruit: "
                    + fruit.getName());
        } else if (fruitBigDecimalMap.get(fruit).compareTo(amount) < 0) {
            throw new RuntimeException("Purchased can't be more than the amount, amount: "
                    + fruitBigDecimalMap.get(fruit) + ", purchase: " + amount);
        }
        fruitBigDecimalMap.replace(fruit, (fruitBigDecimalMap.get(fruit).subtract(amount)));
        return fruitBigDecimalMap;
    }
}
