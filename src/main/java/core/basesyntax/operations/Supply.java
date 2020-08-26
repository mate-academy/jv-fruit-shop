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
            Map<LocalDate, Integer> box = storage.getBoxWithFruit(type);
            if (box.containsKey(expirationDate)) {
                box.replace(expirationDate, box.get(expirationDate) + quantity);
                return true;
            }
            box.put(expirationDate, quantity);
            return true;
        }
        storage.addNewFruitToRange(type, quantity, expirationDate);
        return true;
    }
}
