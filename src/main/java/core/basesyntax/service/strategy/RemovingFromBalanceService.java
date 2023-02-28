package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.exeption.FruitShopExeption;
import core.basesyntax.service.FruitService;

public class RemovingFromBalanceService extends FruitService {

    public RemovingFromBalanceService() {
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public void moveFruit(String fruit, Integer amount) {
        if (fruit == null || amount == null) {
            throw new FruitShopExeption("Incorrect input data for removing action");
        }
        fruitDao.remove(fruit, amount);
    }
}
