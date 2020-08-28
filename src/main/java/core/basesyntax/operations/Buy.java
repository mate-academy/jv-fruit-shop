package core.basesyntax.operations;

import core.basesyntax.dao.Box;
import core.basesyntax.dao.Storage;
import core.basesyntax.goods.Product;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Buy implements Operation {
    @Override
    public boolean updateStorage(Product product, Storage storage) {
        LocalDate productExpDate = product.getExpDate();
        Product.checkExpDate(productExpDate);
        String type = product.getType();
        int quantity = product.getQuantity();
        if (!storage.contains(type)) {
            return false;
        }
        if (quantity == 0) {
            return true;
        }
        Box box = storage.getBox(type);
        List<LocalDate> expDates = new ArrayList<>(box.getExpDates());
        if (expDates.isEmpty()) {
            return false;
        }
        return buyCheck(product, expDates, box);
    }

    private boolean buyCheck(Product product,
                             List<LocalDate> expDates,
                             Box box) {
        int quantityToBuy = product.getQuantity();
        for (LocalDate expDate : expDates) {
            Integer quantityInBox = box.getProduct(expDate).getQuantity();
            if (quantityInBox > quantityToBuy) {
                Product productInBox = box.getProduct(expDate);
                productInBox.setQuantity(productInBox.getQuantity() - quantityToBuy);
                return true;
            }
            if (quantityInBox.equals(quantityToBuy)) {
                box.removeProduct(expDate);
                return true;
            }
            quantityToBuy = quantityToBuy - quantityInBox;
            box.removeProduct(expDate);
        }
        return quantityToBuy == 0;
    }
}
