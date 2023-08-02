package core.basesyntax.services;

import core.basesyntax.transactor.FruitTransaction;
import java.util.List;

public interface ProcessData {
    List<FruitTransaction> process(String inputData);
}
