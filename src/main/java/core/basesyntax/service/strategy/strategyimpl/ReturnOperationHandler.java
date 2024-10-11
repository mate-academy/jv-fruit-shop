package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitRecord transaction) {
        int returnFruits = transaction.getQuantity();
        if (returnFruits < 0) {
            throw new RuntimeException("Balance cannot be negative for fruit: "
                    + transaction.getFruit());
        }
        Storage.storage.merge(transaction.getFruit(), returnFruits, Integer::sum);
    }
}
