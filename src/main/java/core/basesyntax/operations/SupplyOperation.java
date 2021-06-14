package core.basesyntax.operations;

import core.basesyntax.dto.ProductDto;
import core.basesyntax.storage.Storage;

public class SupplyOperation implements Operation {
    @Override
    public void apply(ProductDto productDto) {
        Integer newQuantity =
                productDto.getQuantity() + Storage.fruits.get(productDto.getFruitName());
        Storage.fruits.put(productDto.getFruitName(), newQuantity);
    }
}
