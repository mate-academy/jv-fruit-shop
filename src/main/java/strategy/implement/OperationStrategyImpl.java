package strategy.implement;

import core.basesyntax.model.ParseLine;
import java.util.HashMap;
import java.util.Map;
import service.OperationService;
import service.operationimpl.CreateOperation;
import service.operationimpl.MinusOperation;
import service.operationimpl.PlusOperation;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<String, OperationService> map = new HashMap<>();

    static {
        map.put("p", new MinusOperation());
        map.put("b", new CreateOperation());
        map.put("s", new PlusOperation());
        map.put("r", new PlusOperation());
    }

    @Override
    public OperationService getOperationService(ParseLine line) {
        return map.get(line.getOperation());
    }
}
