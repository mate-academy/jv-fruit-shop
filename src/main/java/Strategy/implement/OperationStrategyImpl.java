package Strategy.implement;

import Strategy.OperationStrategy;
import service.OperationService;
import service.implementoOperation.MinusOperation;
import service.implementoOperation.OperationCreate;
import service.implementoOperation.PlusOperation;
import core.basesyntax.model.ParseLine;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationService getOperationService(ParseLine line) {
        switch (line.getOperation()){
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
