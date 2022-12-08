package service.activity;

import java.math.BigDecimal;
import java.util.Map;
import model.Fruit;
import model.FruitTransaction;

public class SupplyActivityHandler implements ActivityHandler {
    @Override
    public Map<Fruit, BigDecimal> doActivity(Map<Fruit, BigDecimal> fruitBigDecimalMap,
                                             FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        BigDecimal amount = fruitTransaction.getAmount();
        if (!fruitBigDecimalMap.containsKey(fruit)) {
            fruitBigDecimalMap.put(fruit, amount);
        } else {
            fruitBigDecimalMap.replace(fruit, (fruitBigDecimalMap.get(fruit).add(amount)));
        }
        return fruitBigDecimalMap;
    }

}
