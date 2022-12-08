package service.activity;

import java.math.BigDecimal;
import java.util.Map;
import model.Fruit;
import model.FruitTransaction;

public interface ActivityHandler {
    Map<Fruit, BigDecimal> doActivity(Map<Fruit, BigDecimal> fruitBigDecimalMap,
                                      FruitTransaction fruitTransaction);
}
