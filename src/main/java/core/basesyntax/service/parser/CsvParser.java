package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvParser {
    List<FruitTransaction> parseFruits(List<String> fileInfo);
}
