package core.basesyntax.service.parsing;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parse(List<String> records);
}
