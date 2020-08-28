package core.basesyntax.operations;

import core.basesyntax.ProductBox;
import core.basesyntax.Record;
import core.basesyntax.Storage;

public class IncomeShopOperation implements ShopOperation {
    private Storage storage;

    public IncomeShopOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void transaction(Record record) {
        for (ProductBox product : storage.getFruitSupplies()) {
            if (record.getProductName().equals(product.getProductName())
                    && record.getDate().equals(product.getExpirationDate())) {
                product.setCount(product.getCount() + record.getCount());
                return;
            }
        }

        ProductBox product = new ProductBox(record.getProductName(),
                record.getCount(), record.getDate());
        storage.addProductBox(product);
    }
}
