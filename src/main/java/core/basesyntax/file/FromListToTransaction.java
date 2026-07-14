package core.basesyntax.file;

import core.basesyntax.transactions.FruitTransaction;
import java.util.List;

public interface FromListToTransaction {
    List<FruitTransaction> finalProcess(List<String> fileName);
}
