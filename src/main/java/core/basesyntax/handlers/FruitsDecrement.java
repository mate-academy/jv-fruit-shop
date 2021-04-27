package core.basesyntax.handlers;

import core.basesyntax.data.DataValidator;
import core.basesyntax.data.PurchaseAmountValidator;
import core.basesyntax.services.FruitsService;
import core.basesyntax.storage.FruitDataBase;

public class FruitsDecrement implements FruitsService {
    @Override
    public void change(String fruit, Integer amount, FruitDataBase fruitDataBase) {
        Integer oldFruitAmount = fruitDataBase.getFruitShopData(fruit);
        DataValidator purchaseValidator = new PurchaseAmountValidator();
        purchaseValidator.validate(oldFruitAmount, amount);
        fruitDataBase.setFruitShopData(fruit, oldFruitAmount - amount);
    }
}
