package core.basesyntax.util;

import core.basesyntax.exception.DataValidationException;
import java.util.List;

public class DataValidator {
    public static boolean validateInputData(String operationCode,
                                            String fruitName,
                                            int fruitQuantity) {
        if (operationCode == null || operationCode.isEmpty()) {
            throw new DataValidationException(String.format(
                    "Invalid initial operationCode: %s", operationCode));
        } else if (fruitName == null || fruitName.isEmpty()) {
            throw new DataValidationException(String.format(
                    "Invalid initial fruitName: %s", fruitName));
        } else if (fruitQuantity < 0) {
            throw new DataValidationException(String.format(
                    "Invalid initial fruitQuantity: %d", fruitQuantity));
        }
        return true;
    }

    public static boolean validateIsSourceDataEmpty(List<String> sourceData) {
        if (sourceData.isEmpty()) {
            throw new RuntimeException("Source file is empty");
        }
        return true;
    }
}
