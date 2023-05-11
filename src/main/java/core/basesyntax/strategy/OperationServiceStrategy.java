package core.basesyntax.strategy;

import core.basesyntax.service.OperationService;
import core.basesyntax.service.impl.AddOperationService;
import core.basesyntax.service.impl.SubtractOperationService;

public class OperationServiceStrategy {
    public OperationService getOperationService(String operation) {
        switch (operation) {
            case "b" :
            case "s" :
            case "r" :
                return new AddOperationService();
            default:
                return new SubtractOperationService();
        }
    }
}
