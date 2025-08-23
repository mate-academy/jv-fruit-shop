package core.basesyntax.typeofoperationhandler;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.operationstorage.OperationStorageImpl;
import core.basesyntax.operationstorage.OperationStorageService;
import java.util.List;

public class BalanceService implements TypeOfOperationService {
    private OperationStorageService operationStorageService = new OperationStorageImpl();

    @Override
    public Integer getSumOfOperation(String fruit) {
        List<Operation> balanceOperations = operationStorageService
                .getOperationsByTypeAndFruit(TypeOfOperation.b, fruit);
        Operation balanceOperation = balanceOperations.get(0);
        return balanceOperation.getQuantity();
    }
}
