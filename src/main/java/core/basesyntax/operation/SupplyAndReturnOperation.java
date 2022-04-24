package core.basesyntax.operation;

import core.basesyntax.Product;
import core.basesyntax.Storage;
import core.basesyntax.service.Record;

public class SupplyAndReturnOperation implements Operation {
    private Storage storage;

    public SupplyAndReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void transaction(Record record) {
        for (Product product : storage.getFruitList()) {
            if (record.getName().equals(product.getProductName())
                    && record.getDate().equals(product.getExpirationDate())) {
                product.setCount(product.getCount() + record.getQuantity());
                return;
            }
        }

        Product product = new Product(record.getName(),
                record.getQuantity(), record.getDate());
        storage.addProductBox(product);
    }
}
