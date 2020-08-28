package core.basesyntax.operations;

import core.basesyntax.model.TransactionDto;
import java.util.HashMap;
import java.util.Map;

public class OperationConverter {
    private static final Map<String, Operation> mapWithOperations = new HashMap<>();

    static {
        mapWithOperations.put("s", new SupplyAndReturnOperation());
        mapWithOperations.put("b", new BuyOperation());
        mapWithOperations.put("r", new SupplyAndReturnOperation());
    }

    public void convert(TransactionDto transactionDto) {
        Operation operation = mapWithOperations.get(transactionDto.getOperation());
        operation.apply(transactionDto);
    }
}
