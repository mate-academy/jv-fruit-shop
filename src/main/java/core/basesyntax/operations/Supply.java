package core.basesyntax.operations;

import core.basesyntax.dao.Box;
import core.basesyntax.dao.Storage;
import core.basesyntax.goods.Product;

import java.time.LocalDate;

public class Supply implements Operation {
    @Override
    public boolean updateStorage(Product product, Storage storage) {
        LocalDate expDate = product.getExpDate();
        Product.checkExpDate(expDate);
        String type = product.getType();
        int quantity = product.getQuantity();
        if (storage.contains(type)) {
            Box box = storage.getBox(type);
            if (box.getExpDates().contains(expDate)) {
                Product productInBox = box.getProduct(expDate);
                productInBox.setQuantity(productInBox.getQuantity() + quantity);
                return true;
            }
            box.put(expDate, product);
            return true;
        }
        storage.add(product);
        return true;
    }
}
