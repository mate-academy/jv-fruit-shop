package core.basesyntax.service.imp;

import core.basesyntax.exeption.FruitShopExeption;
import core.basesyntax.service.FruitService;

public class SupplyService implements FruitService {

    @Override
    public void moveFruit(String fruit, Integer amount) {
        if (fruit == null || amount == null) {
            throw new FruitShopExeption("Incorrect input data in Supply action");
        }
        FRUIT_DAO.add(fruit, amount);
    }
}
