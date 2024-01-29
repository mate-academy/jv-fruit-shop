package core.basesyntax.service;

import core.basesyntax.fruittransaction.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parse(String data);
}
