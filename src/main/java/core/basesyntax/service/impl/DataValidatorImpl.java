package core.basesyntax.service.impl;

import core.basesyntax.service.DataValidator;
import java.util.List;

public class DataValidatorImpl implements DataValidator {
    @Override
    public void validate(List<String> info) {
        if (info.size() < 2) {
            throw new RuntimeException("Not enough data");
        }
        if (!info.get(0).equals("type,fruit,quantity")) {
            throw new RuntimeException("Inappropriate format(1 line)");
        }
    }
}
