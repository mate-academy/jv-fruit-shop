package core.basesyntax.service.operations;

import core.basesyntax.model.Product;
import java.util.List;

public class PurchaseOperation implements Operation {
    @Override
    public boolean updateStorage(List<Product> products) {
        List<Product> list = Operation.storageService.getAll();
        int countToBuy = products.size();
        long countInStock = Operation.storageService.getAll().stream()
                .filter(p -> p.getFruitType().equalsIgnoreCase(products.get(0).getFruitType())
                && p.getExpirationDate().isAfter(products.get(0).getExpirationDate()))
                .count();
        if (countInStock - countToBuy < 0) {
            return false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getFruitType().equalsIgnoreCase(products.get(0).getFruitType())
                        && list.get(i).getExpirationDate().isAfter(
                                products.get(0).getExpirationDate())) {
                    Operation.storageService.retrieve(i);
                    countToBuy--;
                    i--;
                }
                if (countToBuy <= 0) {
                    break;
                }
            }
            return true;
        }
    }
}
