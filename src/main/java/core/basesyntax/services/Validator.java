package core.basesyntax.services;

import java.util.List;

public interface Validator {
    boolean checkInputData(List<String> listData);

    boolean checkOperation(int money);
}
