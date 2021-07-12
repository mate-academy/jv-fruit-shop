package core.basesyntax.service.operations;

import core.basesyntax.model.Record;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer updateValue(Record record, Integer oldValue) {
        if (oldValue - record.getQuantity() < 0) {
            throw new IllegalArgumentException("Recorded operations resulting negative "
                    + "fruit balance");
        } else {
            return oldValue - record.getQuantity();
        }
    }
}
