package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.Instruction;
import core.basesyntax.service.OperationExecutor;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;

public class OperationExecutorImpl implements OperationExecutor {
    private final Map<FruitOperation, Operation> operationsHandlers;

    public OperationExecutorImpl(Map<FruitOperation, Operation> operationsHandlers) {
        this.operationsHandlers = operationsHandlers;
    }

    @Override
    public void proceedAll(List<Instruction> commands) {
        Operation currentOperation;
        for (Instruction instruction : commands) {
            currentOperation = operationsHandlers.get(instruction.getOperation());
            if (currentOperation == null) {
                throw new RuntimeException("No handler found for operation: "
                        + instruction.getOperation());
            }
            currentOperation.proceed(instruction);
        }
    }
}
