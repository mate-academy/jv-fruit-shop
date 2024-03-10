package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.IOperatorIdentifier;
import java.util.HashMap;
import java.util.Map;

public class OperatorIdentifier implements IOperatorIdentifier {
    private final Map<String, Operation> codeOperationMap;

    public OperatorIdentifier() {
        codeOperationMap = new HashMap<>();
        codeOperationMap.put("b", Operation.BALANCE);
        codeOperationMap.put("s", Operation.SUPPLY);
        codeOperationMap.put("p", Operation.PURCHASE);
        codeOperationMap.put("r", Operation.RETURN);
    }

    @Override
    public Operation getOperator(String code) {
        Operation operation = codeOperationMap.get(code);
        if (operation == null) {
            throw new RuntimeException("Wrong operation code");
        }
        return operation;
    }
}
