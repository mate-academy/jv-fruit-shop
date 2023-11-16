package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;

public interface OperationResolver {

    Operation getOperation(String str);
}
