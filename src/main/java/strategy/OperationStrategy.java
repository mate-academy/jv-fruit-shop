package strategy;

import core.basesyntax.model.ParseLine;
import service.OperationService;

public interface OperationStrategy {
    OperationService getOperationService(ParseLine line);
}
