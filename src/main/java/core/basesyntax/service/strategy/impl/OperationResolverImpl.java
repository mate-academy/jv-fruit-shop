package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.exception.NoSuchOperationException;
import core.basesyntax.service.strategy.OperationResolver;
import java.util.Map;

public class OperationResolverImpl implements OperationResolver {
    private Map<String, Operation> operationMap;

    public OperationResolverImpl(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public Operation getOperation(String str) {
        Operation operation = operationMap.get(str.trim());
        if (operation == null) {
            throw new NoSuchOperationException("No such operation found");
        }
        return operation;
    }
}
