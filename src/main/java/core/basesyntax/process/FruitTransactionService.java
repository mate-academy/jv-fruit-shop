package core.basesyntax.process;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionService {
    List<FruitTransaction> parseFruitData(String fruitData);

    void processTransactionList(List<FruitTransaction> fruitTransactionList);
}
