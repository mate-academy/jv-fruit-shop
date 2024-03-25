package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.IOperationIdentifier;
import java.util.Map;

public class OperationIdentifier implements IOperationIdentifier {
    private final Map<String, Operation> codeOperationMap;

    public OperationIdentifier(Map<String, Operation> codeOperationMap) {
        this.codeOperationMap = codeOperationMap;
    }

    @Override
    public Operation get(String code) {
        Operation operation = codeOperationMap.get(code);
        if (operation == null) {
            throw new RuntimeException("Wrong operation code");
        }
        return operation;
    }
}
