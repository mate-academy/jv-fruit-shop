package core.basesyntax.service;

import core.basesyntax.model.InputData;

public class Validator {
    private static final int LAST_INDEX_NUMBER = 2;
    private static final String CSV_SEPARATOR = ",";

    public void validate(InputData inputData) {
        for (String line : inputData.getParsedFile()) {
            String[] data = line.split(CSV_SEPARATOR);
            if (data.length < 3) {
                throw new RuntimeException("Not enough input data in this line: " + line);
            } else if (!data[LAST_INDEX_NUMBER].equals("quantity")
                    && Integer.parseInt(data[LAST_INDEX_NUMBER]) < 0) {
                throw new RuntimeException("Impossible input for quantity data: "
                        + data[LAST_INDEX_NUMBER]);
            }
        }
    }
}
