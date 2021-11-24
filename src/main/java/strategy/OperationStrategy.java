package strategy;

import core.basesyntax.model.ParseLine;
import service.OperationService;

public interface OperationStrategy {
    public OperationService getOperationService(ParseLine line);
}
