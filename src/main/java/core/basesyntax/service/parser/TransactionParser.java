package core.basesyntax.service.parser;

import core.basesyntax.entity.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> processingStringList(List<String> str);
}
