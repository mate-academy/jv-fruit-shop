package core.basesyntax.operation;

import core.basesyntax.Product;
import core.basesyntax.Storage;
import core.basesyntax.service.Record;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SellOperation implements Operation {
    private Storage storage;

    public SellOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void transaction(Record record) {
        int availableCount = getAvailableCount(record);

        if (availableCount < record.getQuantity()) {
            throw new RuntimeException("We have'nt enough fruits" + record.getName()
                    + " need quantity: " + record.getQuantity());
        }
        List<Product> availableProducts = getAvailableBoxes(record);
        for (Product product : availableProducts) {
            if (product.getCount() <= record.getQuantity()) {
                record.setQuantity(record.getQuantity() - product.getCount());
                storage.removeProductBox(product);
            } else {
                product.setCount(product.getCount() - record.getQuantity());
                return;
            }
        }
    }

    private List<Product> getAvailableBoxes(Record record) {
        return storage.getFruitList().stream()
                .filter(product -> product.getProductName().equals(record.getName())
                        && isBefore(record.getDate(), product.getExpirationDate()))
                .collect(Collectors.toList());
    }

    private int getAvailableCount(Record record) {
        return storage.getFruitList().stream()
                .filter(product -> product.getProductName().equals(record.getName())
                        && isBefore(record.getDate(), product.getExpirationDate()))
                .map(Product::getCount)
                .reduce(0, Integer::sum);
    }

    public boolean isBefore(LocalDate recordDate, LocalDate productDate) {
        return recordDate.compareTo(productDate) < 0;
    }
}
