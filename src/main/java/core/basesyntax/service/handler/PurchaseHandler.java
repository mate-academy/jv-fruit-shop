package core.basesyntax.service.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.inter.Operation;
import java.util.Map;

public class PurchaseHandler implements Operation {
    private final Map<String, Integer> fruitsQuantity = Storage.fruitsQuantity;

    @Override
    public void apply(FruitOperation operation) {
        Integer currentQuantity = fruitsQuantity.get(operation.getFruit());
        Integer updatedQuantity = currentQuantity - operation.getQuantity();
        fruitsQuantity.put(operation.getFruit(), updatedQuantity);
    }
}
