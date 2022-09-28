package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface InputDataService {
    public List<FruitTransaction> stringToFruitTransactionConverter(List<String> inputText);
}
