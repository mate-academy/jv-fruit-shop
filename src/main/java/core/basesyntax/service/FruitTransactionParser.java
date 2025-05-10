package core.basesyntax.service;

import core.basesyntax.model.FruitsTransaction;
import java.util.List;

public interface FruitTransactionParser {
    List<FruitsTransaction> parse(List<String> data);
}
