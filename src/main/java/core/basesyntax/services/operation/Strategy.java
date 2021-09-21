package core.basesyntax.services.operation;

import core.basesyntax.model.Operation;

public interface Strategy {
    Handler get(Operation.Type operation);
}
