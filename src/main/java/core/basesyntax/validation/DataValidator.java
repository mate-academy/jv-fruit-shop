package core.basesyntax.validation;

import core.basesyntax.model.Operation;
import java.util.List;

public class DataValidator {
    private static final String COMMA = ",";

    public boolean validate(List<String> inputData) {
        if (inputData.isEmpty()) {
            throw new IllegalArgumentException("Input data cannot be empty");
        }

        for (String line : inputData.subList(1, inputData.size())) {
            String[] partsOfData = line.split(COMMA);
            if (partsOfData.length != 3) {
                throw new IllegalArgumentException("Incorrect input data in line: " + line);
            }
            try {
                Operation.valueOf(partsOfData[0]);
                Integer.parseInt(partsOfData[2]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid data in line: " + line);
            }
        }

        return true;
    }
}
