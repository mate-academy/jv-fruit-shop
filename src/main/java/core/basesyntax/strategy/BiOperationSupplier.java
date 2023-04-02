package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.impl.AddBiOperation;
import core.basesyntax.strategy.impl.SubtractBiOperation;
import java.util.Map;

public class BiOperationSupplier {
    private Map<Operation, BiOperation> operations;

    public BiOperationSupplier() {
        this.operations = Map.of(Operation.BALANCE, new AddBiOperation(),
                Operation.RETURN, new AddBiOperation(),
                Operation.SUPPLY, new AddBiOperation(),
                Operation.PURCHASE, new SubtractBiOperation());
    }

    public BiOperation getOperation(Operation operation) {
        return operations.get(operation);
    }
}
