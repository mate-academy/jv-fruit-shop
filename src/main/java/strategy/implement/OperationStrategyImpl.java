package strategy.implement;

import core.basesyntax.model.ParseLine;
import service.OperationService;
import service.operationimpl.MinusOperation;
import service.operationimpl.OperationCreate;
import service.operationimpl.PlusOperation;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationService getOperationService(ParseLine line) {
        switch (line.getOperation()) {
            case "b" :
                return new OperationCreate();
            case "s" :
            case "r" :
                return new PlusOperation();
            case "p" :
                return new MinusOperation();
            default:
                return null;
        }
    }
}
