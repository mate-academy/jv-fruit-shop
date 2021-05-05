package core.basesyntax.strategy;

import core.basesyntax.dto.ProductDto;
import core.basesyntax.operations.AddOperation;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.PurchaseOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationStrategy {
    private static  final Map<String, Operation> operationMap = new HashMap<>();

    public void doAction(List<ProductDto> productDtoList) {
        operationMap.put("b", new BalanceOperation());
        operationMap.put("r", new AddOperation());
        operationMap.put("s", new AddOperation());
        operationMap.put("p", new PurchaseOperation());

        for (ProductDto productDto : productDtoList) {
            Operation operation = operationMap.get(productDto.getOperationType());
            operation.apply(productDto);
        }
    }
}
