package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvParserService {
    List<FruitTransaction> parse(List<String> lines);
}
