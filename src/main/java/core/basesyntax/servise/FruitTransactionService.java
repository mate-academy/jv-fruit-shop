package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionService {
    public List<FruitTransaction> createTransactionList(List<String> date);
}
