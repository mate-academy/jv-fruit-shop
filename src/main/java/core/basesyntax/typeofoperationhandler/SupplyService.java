package core.basesyntax.typeofoperationhandler;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.operationstorage.OperationStorageImpl;
import core.basesyntax.operationstorage.OperationStorageService;
import java.util.List;

public class SupplyService implements TypeOfOperationService {
    private OperationStorageService operationStorageService = new OperationStorageImpl();

    public Integer getSumOfOperation(String fruit) {
        List<Operation> supplyOperations = operationStorageService
                .getOperationsByTypeAndFruit(TypeOfOperation.s, fruit);
        return supplyOperations.stream()
                .map(Operation::getQuantity)
                .mapToInt(o -> o)
                .sum();
    }
}
