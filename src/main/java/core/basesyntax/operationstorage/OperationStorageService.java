package core.basesyntax.operationstorage;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TypeOfOperation;
import java.util.List;

public interface OperationStorageService {
    default List<Operation> getOperationsByTypeAndFruit(TypeOfOperation typeOfOperation,
                                                        String fruit) {
        return null;
    }
}
