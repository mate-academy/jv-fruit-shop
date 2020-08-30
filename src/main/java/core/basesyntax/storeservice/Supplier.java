package core.basesyntax.storeservice;

import core.basesyntax.dao.Box;
import core.basesyntax.dao.FruitStorage;
import core.basesyntax.goods.FruitPack;
import java.time.LocalDate;

public class Supplier implements Operation {
    @Override
    public boolean updateStorage(FruitPack product, FruitStorage storage) {
        LocalDate expDate = product.getExpDate();
        FruitPack.checkExpDate(expDate);
        String type = product.getType();
        int quantity = product.getQuantity();
        if (storage.contains(type)) {
            Box box = storage.getBox(type);
            if (box.getExpDates().contains(expDate)) {
                FruitPack productInBox = box.getProduct(expDate);
                productInBox.setQuantity(productInBox.getQuantity() + quantity);
                return true;
            }
            box.addProduct(product);
            return true;
        }
        storage.addProduct(product);
        return true;
    }
}
