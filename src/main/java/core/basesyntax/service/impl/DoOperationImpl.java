package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.DoOperation;
import core.basesyntax.service.operations.Operation;
import java.util.Map;

public class DoOperationImpl implements DoOperation {
    private static final int OPERATION = 0;
    private static final int KEY = 1;
    private static final int INPUT = 2;

    @Override
    public void doOperation(Map<String, Integer> shop, String[] record,
                            Map<String, Operation> strategy) {

        shop.put(record[KEY], strategy.get(record[OPERATION])
                .operation(shop.get(record[KEY]), Integer.parseInt(record[INPUT])));
    }
}
