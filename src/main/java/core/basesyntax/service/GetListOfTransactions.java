package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface GetListOfTransactions {
    List<FruitTransaction> getListOfTransactions(String data);
}
