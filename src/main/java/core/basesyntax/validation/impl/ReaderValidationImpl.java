package core.basesyntax.validation.impl;

import core.basesyntax.validation.ReaderValidation;
import java.util.List;

public class ReaderValidationImpl implements ReaderValidation {
    private static final String FIRST_STRING_PATTERN = "type,fruit,quantity";

    public List<String> validate(List<String> stringList) {
        isFirstStringValid(stringList);
        List<String> validStringList = skipUnvalidOperation(stringList);
        return validStringList;
    }

    private List<String> skipUnvalidOperation(List<String> stringList) {
        return stringList.stream()
                .skip(1)
                .filter(string -> string.split(",")[0].matches(".*[bspr].*"))
                .filter(string -> Integer.parseInt(string.split(",")[2]) > 0)
                .toList();
    }

    private void isFirstStringValid(List<String> stringList) {
        if (!stringList.get(0).equals(FIRST_STRING_PATTERN)) {
            throw new RuntimeException(String.format("Invalid data at csv file, must match "
                    + "pattern '%s' but was '%s'", FIRST_STRING_PATTERN, stringList.get(0)));
        }
    }

}
