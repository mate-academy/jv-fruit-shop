package core.basesyntax.operations;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.Product;
import java.util.Map;

public class PurchaseOperation implements Operation {
    @Override
    public int calculateAmount(int oldAmount, int amount) {
        if (oldAmount - amount < 0) {
            throw new RuntimeException("There is only " + oldAmount
                    + " of product, you can't buy more!");
        }
        return oldAmount - amount;
    }
}
