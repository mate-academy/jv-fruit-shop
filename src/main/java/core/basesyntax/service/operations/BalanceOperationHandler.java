package core.basesyntax.service.operations;

import core.basesyntax.model.Record;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer updateValue(Record record, Integer oldValue) {
        if (oldValue != 0) {
            throw new IllegalArgumentException("Set operation is not the first one during the day");
        } else {
            return record.getQuantity();
        }
    }
}
