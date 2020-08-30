package core.basesyntax.storeservice;

import core.basesyntax.dao.Box;
import core.basesyntax.dao.FruitStorage;
import core.basesyntax.goods.FruitPack;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consumer implements Operation {
    /*private FruitStorage storage;

    public Consumer(FruitStorage storage) {
        this.storage = storage;
    }*/

    @Override
    public boolean updateStorage(FruitPack product, FruitStorage storage) {
        LocalDate productExpDate = product.getExpDate();
        FruitPack.checkExpDate(productExpDate);
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
        return buySuccess(product, expDates, box);
    }

    private boolean buySuccess(FruitPack product,
                               List<LocalDate> expDates,
                               Box box) {
        int quantityToBuy = product.getQuantity();
        for (LocalDate expDate : expDates) {
            Integer quantityInBox = box.getProduct(expDate).getQuantity();
            if (quantityInBox > quantityToBuy) {
                FruitPack productInBox = box.getProduct(expDate);
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
