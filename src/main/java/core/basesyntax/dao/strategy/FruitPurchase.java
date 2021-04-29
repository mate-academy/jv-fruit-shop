package core.basesyntax.dao.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;

public class FruitPurchase implements FruitOperations {
    @Override
    public void doOperationWithFruit(FruitDto fruitDto) {
        Storage.getFruits().replace(fruitDto.getFruitName(),
                Storage.getFruits().get(fruitDto.getFruitName()) - fruitDto.getQuantity());
    }
}
