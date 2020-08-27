package core.basesyntax.operations;

import core.basesyntax.model.FruitDto;
import java.util.HashMap;
import java.util.Map;

public class OperationConverter {
    private static final Map<String, Operation> mapWithOperations = new HashMap<>();

    static {
        mapWithOperations.put("s", new SupplyOperation());
        mapWithOperations.put("b", new BuyOperation());
        mapWithOperations.put("r", new ReturnOperation());
    }

    public void convert(FruitDto fruitDto) {
        Operation operation = mapWithOperations.get(fruitDto.getOperation());
        operation.apply(fruitDto);
    }
}
