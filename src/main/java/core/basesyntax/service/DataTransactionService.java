package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataTransactionService {
    List<FruitTransaction> getData(String data);
}
