package core.basesyntax.typeofoperationhandler;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.operationstorage.OperationStorageImpl;
import core.basesyntax.operationstorage.OperationStorageService;
import java.util.List;

public class ReturnService implements TypeOfOperationService {
    private OperationStorageService operationStorageService = new OperationStorageImpl();

    public Integer getSumOfOperation(String fruit) {
        List<Operation> returnOperations = operationStorageService
                .getOperationsByTypeAndFruit(TypeOfOperation.r, fruit);
        return returnOperations.stream()
                .map(Operation::getQuantity)
                .mapToInt(o -> o)
                .sum();
    }
}
