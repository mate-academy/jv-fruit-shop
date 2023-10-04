package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParseService {
    List<FruitTransaction> parseFruitTransaction(List<String> records);
}
