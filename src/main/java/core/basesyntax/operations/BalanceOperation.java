package core.basesyntax.operations;

import core.basesyntax.dto.ProductDto;
import core.basesyntax.storage.Storage;

public class BalanceOperation implements Operation {
    @Override
    public void apply(ProductDto fruitDto) {
        Storage.fruits.put(fruitDto.getFruitName(), fruitDto.getQuantity());
    }
}
