package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitDto;

public class PurchaseOperation implements TypeHandler {
    @Override
    public void handle(FruitDto fruitDto) {
        if (Storage.fruits.get(fruitDto.getFruit()) >= fruitDto.getQuantity()) {
            Storage.fruits.put(fruitDto.getFruit(), Storage.fruits.get(fruitDto.getFruit())
                    - fruitDto.getQuantity());
        } else {
            throw new RuntimeException("You can't buy this fruit! Fruit: " + fruitDto);
        }
    }
}
