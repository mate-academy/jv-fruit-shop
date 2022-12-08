package service.activity;

import java.math.BigDecimal;
import java.util.Map;
import model.Fruit;
import model.FruitTransaction;

public class BalanceActivityHandler implements ActivityHandler {

    @Override
    public Map<Fruit, BigDecimal> doActivity(Map<Fruit, BigDecimal> fruitBigDecimalMap,
                                             FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        if (fruitBigDecimalMap.containsKey(fruit)) {
            throw new RuntimeException("Balance information already has, fruit: "
                    + fruit.getName());
        }
        fruitBigDecimalMap.put(fruit, fruitTransaction.getAmount());
        return fruitBigDecimalMap;
    }
}
