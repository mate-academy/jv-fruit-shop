package core.basesyntax.datavalidation;

import core.basesyntax.operationswithfile.Operation;
import java.util.List;

public class OperationTypeValidatorImpl implements OperationTypeValidator {
    @Override
    public void validation(List<Operation> operationList) {
        for (int i = 0; i < operationList.size(); i++) {
            if (!"b".equals(operationList.get(i).getOperationType())
                    && !"p".equals(operationList.get(i).getOperationType())
                    && !"r".equals(operationList.get(i).getOperationType())
                    && !"s".equals(operationList.get(i).getOperationType())) {
                throw new RuntimeException("NotValid operation type! "
                        + operationList.get(i).toString());
            }
        }
    }
}
