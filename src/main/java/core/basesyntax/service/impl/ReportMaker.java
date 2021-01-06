package core.basesyntax.service.impl;

import core.basesyntax.Storage;
import core.basesyntax.service.interfaces.DoOperation;
import core.basesyntax.service.interfaces.ReportParser;
import core.basesyntax.service.operations.Operation;
import java.util.Map;

public class ReportMaker implements DoOperation, ReportParser {
    private static final int OPERATION = 0;
    private static final int KEY = 1;
    private static final int INPUT = 2;

    @Override
    public void doOperation(String[] record, Map<String, Operation> strategy) {
        Storage.storage.put(record[KEY], strategy.get(record[OPERATION])
                .operation(Storage.storage.get(record[KEY]), Integer.parseInt(record[INPUT])));
    }

    @Override
    public String combineOutput() {
        String result = "fruit,quantity";
        for (Map.Entry<String, Integer> record : Storage.storage.entrySet()) {
            result = result + System.lineSeparator() + record.getKey() + "," + record.getValue();
        }
        return result;
    }
}
