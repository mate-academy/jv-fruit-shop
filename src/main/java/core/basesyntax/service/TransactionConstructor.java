package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionConstructor {
    FruitTransaction packToObject(String fromFile);

    List<FruitTransaction> packToObject(List<String> fromFile);
}
