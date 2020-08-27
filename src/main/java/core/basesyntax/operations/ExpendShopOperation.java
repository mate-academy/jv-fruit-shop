package core.basesyntax.operations;

import core.basesyntax.ProductBox;
import core.basesyntax.Record;
import core.basesyntax.Storage;
import java.time.LocalDate;

public class ExpendShopOperation implements ShopOperation {
    private Storage storage;

    public ExpendShopOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void transaction(Record record) {
        for (ProductBox product : storage.getFruitSupplies()) {
            if (product.getProductName().equals(record.getProductName())
                    && product.getCount() >= record.getCount()
                    && isFresh(record.getDate(), product.getExpirationDate())) {
                product.setCount(product.getCount() - record.getCount());
                return;
            }
        }
        throw new RuntimeException("We don't have enough fresh [" + record.getProductName()
                + "] for sale [" + record.getDate() + " need count " + record.getCount() + "]");
    }

    public boolean isFresh(LocalDate recordDate, LocalDate productDate) {
        return recordDate.compareTo(productDate) < 0;
    }
}
