package core.basesyntax.operationstrategy;

import core.basesyntax.model.OperationFruitDto;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy implements OperationService {
    public static final Map<String, OperationService> mapOperation = new HashMap<>();

    static {
        mapOperation.put("b", new AddOperationService());
        mapOperation.put("s", new AddOperationService());
        mapOperation.put("p", new ReduceOperationService());
        mapOperation.put("r", new AddOperationService());
    }

    @Override
    public void apply(OperationFruitDto operationFruitDto) {
        mapOperation.get(operationFruitDto.getOperation()).apply(operationFruitDto);
    }
}
