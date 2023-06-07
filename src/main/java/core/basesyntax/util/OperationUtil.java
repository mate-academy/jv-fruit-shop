package core.basesyntax.util;

public class OperationUtil {
    public static String getCode(String operationCode) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(operationCode)) {
                return operation.getCode();
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + operationCode);
    }
}

