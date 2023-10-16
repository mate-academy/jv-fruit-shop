package core.basesyntax.service.strategy;

import core.basesyntax.model.LineInformation;

public interface OperationHandler {

    boolean operate(LineInformation lineInformation);
}
