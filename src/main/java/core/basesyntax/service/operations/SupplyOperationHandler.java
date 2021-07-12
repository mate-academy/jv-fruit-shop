package core.basesyntax.service.operations;

import core.basesyntax.model.Record;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer updateValue(Record record, Integer oldValue) {
        return oldValue + record.getQuantity();
    }
}
