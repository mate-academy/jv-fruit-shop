package core.basesyntax.dao;

import core.basesyntax.model.Operation;
import java.util.List;

public interface OperationDao {
    List<Operation> getListOperations();
}
