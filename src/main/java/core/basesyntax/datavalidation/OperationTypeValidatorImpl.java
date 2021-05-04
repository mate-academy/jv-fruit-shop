package core.basesyntax.datavalidation;

import core.basesyntax.operationswithfile.Operation;
import java.util.ArrayList;

public class OperationTypeValidatorImpl implements OperationTypeValidator {
    @Override
    public void validation(ArrayList<Operation> operationArrayList) {
        for (int i = 0; i < operationArrayList.size(); i++) {
            if (!"b".equals(operationArrayList.get(i).getOperationType())
                    && !"p".equals(operationArrayList.get(i).getOperationType())
                    && !"r".equals(operationArrayList.get(i).getOperationType())
                    && !"s".equals(operationArrayList.get(i).getOperationType())) {
                throw new RuntimeException("NotValid operation type! "
                        + operationArrayList.get(i).toString());
            }
        }
    }
}
