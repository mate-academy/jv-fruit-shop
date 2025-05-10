package core.basesyntax.validator;

import core.basesyntax.exception.FruitShopException;

public class QuantityValidator {
    public void getQuantityValidation(int quantity) {
        if (quantity < 0) {
            throw new FruitShopException("Fruit's quantity can't be less than 0");
        }
    }
}
