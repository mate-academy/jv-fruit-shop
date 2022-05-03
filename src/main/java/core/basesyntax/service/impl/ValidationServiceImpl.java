package core.basesyntax.service.impl;

import core.basesyntax.service.ValidationService;
import java.util.List;

public class ValidationServiceImpl implements ValidationService {
    private static final String VALIDATION_PATTERN = "[bspr]";

    @Override
    public List<String> validate(List<String> list) {
        list.removeIf(line -> !String.valueOf(line.charAt(0)).matches(VALIDATION_PATTERN));
        return list;
    }
}
