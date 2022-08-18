package core.basesyntax.service.fruittransactionservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionMapper {
    List<FruitTransaction> getFruitTransactions(List<String> lines);
}
