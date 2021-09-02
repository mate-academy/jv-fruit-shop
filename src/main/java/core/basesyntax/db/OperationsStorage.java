package core.basesyntax.db;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class OperationsStorage {
    private static List<Operation> operationList = new ArrayList<>();

    public static List<Operation> getOperationList() {
        return operationList;
    }
}
