package core.basesyntax.servises;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> interfaceTransactionParser(List<String> list);
}
