package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategyImpl {
    private final Map<String, OperationStrategy> commands;

    public OperationStrategyImpl(Map<String, OperationStrategy> commands) {
        this.commands = commands;
    }

    public OperationStrategy getByOperation(String operation) {
        return commands.get(operation);
    }
}
