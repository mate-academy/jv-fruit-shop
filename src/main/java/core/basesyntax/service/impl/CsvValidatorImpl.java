package core.basesyntax.service.impl;

import core.basesyntax.service.CsvValidator;
import java.util.regex.Pattern;

public class CsvValidatorImpl implements CsvValidator {
    private static final String FILE_HEADER = "type,fruit,quantity";
    private static final String DATA_PATTERN = "[bprs],[a-z]*,[0-9]*";

    @Override
    public void validate(String data) {
        if (data.isEmpty()) {
            throw new RuntimeException("Input file is empty");
        }

        String[] dataLines = data.split(System.lineSeparator());

        for (String line : dataLines) {
            if (!Pattern.matches(DATA_PATTERN, line) && !line.equals(FILE_HEADER)) {
                throw new RuntimeException("Invalid input data");
            }
        }
    }
}
