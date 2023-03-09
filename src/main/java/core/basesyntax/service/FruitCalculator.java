package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitCalculator {
    void calculate(List<FruitTransaction> convertedFileIntoList);
}
