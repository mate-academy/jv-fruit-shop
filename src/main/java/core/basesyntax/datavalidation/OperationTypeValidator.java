package core.basesyntax.datavalidation;

import core.basesyntax.operationswithfile.Operation;
import java.util.List;

public interface OperationTypeValidator {
    void validation(List<Operation> operationList);
}
