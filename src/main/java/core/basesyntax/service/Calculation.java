package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Calculation {
    void calculation(List<FruitTransaction> convertedFileIntoList);
}
