package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessData {
    List<FruitTransaction> process(String inputData);
}
