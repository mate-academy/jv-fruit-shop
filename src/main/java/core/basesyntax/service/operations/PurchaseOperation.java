package core.basesyntax.service.operations;

import core.basesyntax.model.Product;
import java.util.List;

public class PurchaseOperation implements Operation {
    private List<Product> list = Operation.storageService.getAll();

    @Override
    public boolean updateStorage(List<Product> products) {
        int countToBuy = products.size();
        long countInStock = Operation.storageService.getAll().stream()
                .filter(p -> checkProductConformity(p, products.get(0)))
                .count();
        if (countInStock - countToBuy < 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (checkProductConformity(list.get(i), products.get(0))) {
                Operation.storageService.get(i);
                countToBuy--;
                i--;
            }
            if (countToBuy <= 0) {
                break;
            }
        }
        return true;
    }

    private boolean checkProductConformity(Product storageProduct, Product actualProduct) {
        return storageProduct.getFruitType().equalsIgnoreCase(actualProduct.getFruitType())
                && storageProduct.getExpirationDate().isAfter(actualProduct.getExpirationDate());
    }
}
