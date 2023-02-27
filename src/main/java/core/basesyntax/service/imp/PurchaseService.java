package core.basesyntax.service.imp;

import core.basesyntax.service.FruitService;

public class PurchaseService implements FruitService {

    @Override
    public void moveFruit(String fruit, Integer amount) {
        if (fruit == null || amount == null) {
            throw new RuntimeException("Incorrect input data in Purchase action");
        }
        FRUIT_DAO.remove(fruit, amount);
    }
}
