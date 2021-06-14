package core.basesyntax.operations;

import core.basesyntax.dto.ProductDto;
import core.basesyntax.storage.Storage;

public class PurchaseOperation implements Operation {
    @Override
    public void apply(ProductDto productDto) {
        if (productDto.getQuantity() < 0
                || !Storage.fruits.containsKey(productDto.getFruitName())
                || Storage.fruits.get(productDto.getFruitName()) < productDto.getQuantity()) {
            throw new RuntimeException("Invalid input");
        }
        Integer newQuantity =
                Storage.fruits.get(productDto.getFruitName()) - productDto.getQuantity();
        Storage.fruits.put(productDto.getFruitName(), newQuantity);
    }
}
