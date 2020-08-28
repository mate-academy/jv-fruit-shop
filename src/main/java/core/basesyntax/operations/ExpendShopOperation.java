package core.basesyntax.operations;

import core.basesyntax.ProductBox;
import core.basesyntax.Record;
import core.basesyntax.Storage;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ExpendShopOperation implements ShopOperation {
    private Storage storage;

    public ExpendShopOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void transaction(Record record) {
        int availableCount = getAvailableCount(record);

        if (availableCount < record.getCount()) {
            throw new RuntimeException("We don't have enough fresh [" + record.getProductName()
                    + "] for sale [" + record.getDate() + " need count " + record.getCount() + "]");
        }

        List<ProductBox> availableProductBoxes = getAvailableBoxes(record);

        for (ProductBox productBox : availableProductBoxes) {
            if (productBox.getCount() <= record.getCount()) {
                record.setCount(record.getCount() - productBox.getCount());
                storage.removeProductBox(productBox);
            } else {
                productBox.setCount(productBox.getCount() - record.getCount());
                return;
            }
        }
    }

    private List<ProductBox> getAvailableBoxes(Record record) {
        return storage.getFruitSupplies().stream()
                .filter(product -> product.getProductName().equals(record.getProductName())
                        && isBefore(record.getDate(), product.getExpirationDate()))
                .collect(Collectors.toList());
    }

    private int getAvailableCount(Record record) {
        return storage.getFruitSupplies().stream()
                .filter(product -> product.getProductName().equals(record.getProductName())
                        && isBefore(record.getDate(), product.getExpirationDate()))
                .map(productBox -> productBox.getCount())
                .reduce(0, (n, m) -> n + m);
    }

    public boolean isBefore(LocalDate recordDate, LocalDate productDate) {
        return recordDate.compareTo(productDate) < 0;
    }
}
