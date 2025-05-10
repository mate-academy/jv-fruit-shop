package core.basesyntax.workwithfileinterface;

import core.basesyntax.operations.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> data);
}

