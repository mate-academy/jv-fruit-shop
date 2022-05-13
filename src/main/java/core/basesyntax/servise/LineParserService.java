package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface LineParserService {
    List<FruitTransaction> parse(List<String> csvData);
}
