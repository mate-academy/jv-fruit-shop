package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> parse(List<String> lines);
}
