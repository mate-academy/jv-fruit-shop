package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class SupplyOperation implements OperationHandler {
    private static final int MIN_SUPPLY_QUANTITY = 1;
    
    @Override
    public void apply(FruitRecord transaction) {
        int supplyQuantity = transaction.getQuantity();
        Storage.storage.merge(transaction.getFruit(), supplyQuantity, Integer::sum);
    }

    private void validateTransaction(FruitRecord transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < MIN_SUPPLY_QUANTITY) {
            throw new IllegalArgumentException(
                    String.format("Supply quantity must be positive", quantity)
            );
        }
    }
}
