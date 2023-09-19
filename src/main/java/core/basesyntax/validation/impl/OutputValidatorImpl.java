package core.basesyntax.validation.impl;

import core.basesyntax.validation.OutputValidator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OutputValidatorImpl implements OutputValidator {
    @Override
    public boolean validateFile(String filePath) {
        try {
            List<String> data = Files.readAllLines(Paths.get(filePath));
            isFirstLineValid(data.get(0));
            isDataValid(data);
            isValidQuantityOfFruit(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t check data from file: ", e);
        }
        return true;
    }

    private static void isValidQuantityOfFruit(List<String> data) {
        for (String str : data.subList(1, data.size())) {
            if (Integer.parseInt(str.split(",")[1]) < 0) {
                throw new RuntimeException("Quantity of fruit less than zero");
            }
        }
    }

    private void isDataValid(List<String> data) {
        for (String str : data.subList(1, data.size())) {
            if (str.split(",").length != 2) {
                throw new RuntimeException("Length must match pattern 'fruit,quantity'");
            }
        }
    }

    private void isFirstLineValid(String data) {
        if (!data.matches("fruit,quantity")) {
            throw new RuntimeException("First string invalid");
        }
    }
}
