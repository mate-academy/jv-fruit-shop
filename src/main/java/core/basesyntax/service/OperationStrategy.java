package core.basesyntax.service;

import core.basesyntax.service.quantity.OperationHandler;

public interface OperationStrategy {

    OperationHandler operate(String codeOperation);
}
