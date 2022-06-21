package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface LineParserService {
    List<FruitTransaction> parse(List<String> lines);
}
