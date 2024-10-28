package core.basesyntax.WorkWithFileInterface;
import core.basesyntax.Operations.FruitTransaction;

import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> data);
}

