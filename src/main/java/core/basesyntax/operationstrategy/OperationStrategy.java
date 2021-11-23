package core.basesyntax.operationstrategy;

import core.basesyntax.model.OperationFruitDto;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy implements OperationService {
    public static final Map<String, OperationService> MAP_OPERATION = new HashMap<>();

    static {
        MAP_OPERATION.put("b", new AddOperationService());
        MAP_OPERATION.put("s", new AddOperationService());
        MAP_OPERATION.put("p", new ReduceOperationService());
        MAP_OPERATION.put("r", new AddOperationService());
    }

    @Override
    public void apply(OperationFruitDto operationFruitDto) {
        operationFruitDto.getOperationService().apply(operationFruitDto);
    }
}
