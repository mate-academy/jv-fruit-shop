package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitDto;

public class SupplyOperation implements TypeHandler {
    @Override
    public void handle(FruitDto fruitDto) {
        Integer quantity = Storage.fruits.get(fruitDto.getFruit());
        int countFruit = quantity == null ? fruitDto.getQuantity() : quantity
                + fruitDto.getQuantity();
        Storage.fruits.put(fruitDto.getFruit(), countFruit);
    }
}
