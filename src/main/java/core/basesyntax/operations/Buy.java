package core.basesyntax.operations;

import core.basesyntax.items.Product;
import core.basesyntax.items.Storage;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Buy implements Operation {
    @Override
    public boolean updateStorage(Product product, Storage storage) {
        String type = product.getType();
        Integer quantity = product.getQuantity();
        LocalDate purchaseDate = product.getDate();
        if (!storage.isFruitInStorage(type)) {
            return false;
        }
        if (quantity == 0) {
            return true;
        }
        Map<LocalDate, Integer> box = storage.getBoxWithFruit(type);
        List<LocalDate> expirationDates = box.keySet().stream()
                .filter(expirationDate -> expirationDate.isAfter(purchaseDate))
                .sorted()
                .collect(Collectors.toList());
        if (expirationDates.isEmpty()) {
            return false;
        }
        return takeFromBoxes(quantity, expirationDates, box);
    }

    private boolean takeFromBoxes(Integer quantity,
                                  List<LocalDate> expirationDates,
                                  Map<LocalDate, Integer> box) {
        Integer quantityToBuy = quantity;
        for (LocalDate date : expirationDates) {
            Integer quantityInBox = box.get(date);
            if (quantityInBox > quantityToBuy) {
                box.replace(date, quantityInBox - quantityToBuy);
                return true;
            }
            if (quantityInBox.equals(quantityToBuy)) {
                box.remove(date);
                return true;
            }
            quantityToBuy = quantityToBuy - quantityInBox;
            box.remove(date);
        }
        return quantityToBuy == 0;
    }
}
