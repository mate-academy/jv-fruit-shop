package core.basesyntax.db.service;

import core.basesyntax.db.model.FruitTransaction;
import java.util.List;

public interface FruitParserService {
    List<FruitTransaction> parse(List<String> input);
}
