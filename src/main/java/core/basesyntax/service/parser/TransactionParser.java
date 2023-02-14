package core.basesyntax.service.parser;

import core.basesyntax.entity.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parse(List<String> str, String nameFruit);
}
