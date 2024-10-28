package core.basesyntax.validator;

import core.basesyntax.model.Operation;
import java.util.List;

public class DataValidator {
    private static final String COMMA = ",";
    private static final int DATA_LENGTH = 3;

    public void validate(List<String> inputData) {
        if (inputData == null || inputData.isEmpty()) {
            throw new IllegalArgumentException("Input data cannot be empty");
        }
        for (int i = 1; i < inputData.size(); i++) {
            validateLine(inputData.get(i));
        }
    }

    private void validateLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException("Line data cannot be null or empty");
        }

        String[] partsOfData = line.split(COMMA);
        if (partsOfData.length != DATA_LENGTH) {
            throw new IllegalArgumentException("Incorrect input data in line: " + line);
        }

        Operation.getOperationByCode(partsOfData[0].trim());
        try {
            Integer.parseInt(partsOfData[2].trim());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid number format in line: " + line);
        }
    }
}
