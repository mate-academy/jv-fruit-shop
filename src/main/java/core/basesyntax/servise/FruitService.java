package core.basesyntax.servise;

import core.basesyntax.ProductsDto;
import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.FruitOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class FruitService {
    private static final Map<String, FruitOperation> operationMap = new HashMap<>();

    static {
        operationMap.put("s", new SupplyOperation());
        operationMap.put("b", new BuyOperation());
        operationMap.put("r", new ReturnOperation());
    }

    public void convert(ProductsDto productsDto) {
        FruitOperation operation = operationMap.get(productsDto.getOperation());
        operation.fruitOperation(productsDto);
    }
}
