package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParsingService {
    List<FruitTransaction> parse(String data);
}
