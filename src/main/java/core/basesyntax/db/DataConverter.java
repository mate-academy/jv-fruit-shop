package core.basesyntax.db;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> fruitTransaction(List<String> reader);
}
