package core.basesyntax.operations;

import core.basesyntax.items.Product;
import core.basesyntax.items.Storage;
import java.time.LocalDate;
import java.util.Map;

public class Supply implements Operation {
    @Override
    public boolean updateStorage(Product product, Storage storage) {
        String type = product.getType();
        Integer quantity = product.getQuantity();
        LocalDate expirationDate = product.getDate();
        if (storage.isFruitInStorage(type)) {
            Map<LocalDate, Product> box = storage.getBoxWithFruit(type);
            if (box.containsKey(expirationDate)) {
                Product productInBox = box.get(expirationDate);
                productInBox.setQuantity(productInBox.getQuantity() + quantity);
                return true;
            }
            box.put(expirationDate, product);
            return true;
        }
        storage.addNewFruitToRange(product);
        return true;
    }
}
