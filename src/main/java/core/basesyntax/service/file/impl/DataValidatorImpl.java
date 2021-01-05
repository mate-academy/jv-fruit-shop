package core.basesyntax.service.file.impl;

import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.service.file.DataValidator;
import java.util.List;

public class DataValidatorImpl implements DataValidator {
    private static final String ROW_FORMAT = "[a-zA-Z],[\\w]+,[\\d]+";
    private static final String HEAD_FORMAT = "[\\w]+,[\\w]+,[\\D]+";
    private static final String SPLITTER = ",";

    @Override
    public boolean validate(List<String> record) {
        if (record.get(0).matches(HEAD_FORMAT)) {
            record.remove(0);
        }
        for (String row: record) {
            if (!row.matches(ROW_FORMAT)
                    || !Operations.contains(row.substring(0,1))
                    || Integer.parseInt(row.substring(row.lastIndexOf(SPLITTER) + 1)) < 0) {
                throw new RuntimeException("Incorrect data");
            }
        }
        return true;
    }
}
