package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParseService {
    List<FruitTransaction> parseList(String data);
}
