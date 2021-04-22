package core.basesyntax.operations;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.Product;
import java.util.Map;

public class SupplyOperation implements Operation {

    @Override
    public int calculateAmount(int oldAmount, int amount) {
        return oldAmount + amount;
    }
}
