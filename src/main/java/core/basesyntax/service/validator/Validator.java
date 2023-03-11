package core.basesyntax.service.validator;

import java.util.List;

public interface Validator {
    boolean isValid(List<String> dataFromFile);
}
