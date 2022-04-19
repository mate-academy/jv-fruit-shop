package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FormatParserService {
    List<FruitTransaction> parseData(String csvFormatData);
}
