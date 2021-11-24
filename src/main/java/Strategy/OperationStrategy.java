package Strategy;

import service.OperationService;
import core.basesyntax.model.ParseLine;

public interface OperationStrategy {
    public OperationService getOperationService(ParseLine line);
}
