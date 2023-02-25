package core.basesyntax.service.imp;

import core.basesyntax.service.FruitService;

public class ReturnService implements FruitService {

    @Override
    public void moveFruit(String fruit, Integer amount) {
        FRUIT_DAO.add(fruit, amount);
    }
}
