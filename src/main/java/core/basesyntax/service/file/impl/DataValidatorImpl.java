package core.basesyntax.service.file.impl;

import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.service.file.DataValidator;
import java.util.List;

public class DataValidatorImpl implements DataValidator {
    private static final String ROW_FORMAT = "[a-zA-Z],[\\w]+,[\\d]+";
    private static final String SPLITTER = ",";

    @Override
    public boolean validate(List<String> record) {
        for (int i = 1; i < record.size(); i++) {
            if (!record.get(i).matches(ROW_FORMAT)
                    || !Operations.contains(record.get(i).substring(0, 1))
                    || Integer.parseInt(record.get(i).substring(record.get(i)
                    .lastIndexOf(SPLITTER) + 1)) < 0) {
                throw new RuntimeException("Incorrect data");
            }
        }
        return true;
    }
}
