package core.basesyntax.operation;

import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void execute(Map.Entry<String, Integer> entry, int value) {
        entry.setValue(entry.getValue() + value);
    }
}
