package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.FruitTransaction;

public interface TransactionParseService {
    List<FruitTransaction> parseList(String data);
}
