package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer calculateNewAmount(FruitDao fruitDao, Fruit fruit, Integer amount) {
        Map<Fruit, Integer> fruitsMap = fruitDao.getBalance();
        if (!fruitsMap.containsKey(fruit)
                || fruitsMap.get(fruit).equals(amount)) {
            return amount;
        }
        throw new RuntimeException("Wrong balance! In storage are "
        + fruitsMap.get(fruit) + " " + fruit.getName() + "s, not " + amount);
    }
}


