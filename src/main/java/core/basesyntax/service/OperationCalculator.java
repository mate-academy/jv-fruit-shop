package core.basesyntax.service;

import core.basesyntax.Storage;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.SellOperation;
import core.basesyntax.operation.SupplyAndReturnOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationCalculator {
    private Storage storage;
    private Map<TypeOfOperation, Operation> transaction = new HashMap<>();

    public OperationCalculator(Storage storage) {
        this.storage = storage;
        initDealMap();
    }

    private void initDealMap() {
        transaction.put(TypeOfOperation.s, new SupplyAndReturnOperation(storage));
        transaction.put(TypeOfOperation.r, new SupplyAndReturnOperation(storage));
        transaction.put(TypeOfOperation.b, new SellOperation(storage));
    }

    public void calculateBalance(List<Record> recordList) {
        for (Record record : recordList) {
            Operation operation = transaction.get(record.getType());
            operation.transaction(record);
        }
    }
}
