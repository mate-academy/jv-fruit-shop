package core.basesyntax.dao.operation;

import core.basesyntax.dao.operation.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer useOperation(Integer quantity) {
        return quantity;
    }
}
