package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface LineParserService {
    List<FruitTransaction> lineInfo(List<String> lines);
}
