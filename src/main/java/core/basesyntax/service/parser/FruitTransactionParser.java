package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionParser {
    List<FruitTransaction> parse(List<String> lines);
}
