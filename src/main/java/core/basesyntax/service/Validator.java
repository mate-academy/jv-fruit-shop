package core.basesyntax.service;

import java.util.List;

public interface Validator {
    boolean isDataValid(List<String> inputDataFromFile);

    boolean checkValidOfAmount(List<String> inputDataFromFile);
}
