package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parse(String fromFile);
}
