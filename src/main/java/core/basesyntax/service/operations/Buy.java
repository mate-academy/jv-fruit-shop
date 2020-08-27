package core.basesyntax.service.operations;

import core.basesyntax.model.Product;
import java.util.List;

public class Buy implements Operation {
    @Override
    public boolean updateStorage(List<Product> products) {
        List<Product> list = Operation.STORAGE_SERVICE.getAll();
        int countToBuy = products.size();
        long countInStock = Operation.STORAGE_SERVICE.getAll().stream()
                .filter(p -> p.getFruitType().equalsIgnoreCase(products.get(0).getFruitType())
                && p.getExDate().isAfter(products.get(0).getExDate()))
                .count();
        if (countInStock - countToBuy < 0) {
            return false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getFruitType().equalsIgnoreCase(products.get(0).getFruitType())
                        && list.get(i).getExDate().isAfter(products.get(0).getExDate())) {
                    Operation.STORAGE_SERVICE.retrieve(i);
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
