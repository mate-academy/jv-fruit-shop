package core.basesyntax.service;

import java.util.List;

public interface CsvDataParserService {
    List<FruitTransaction> parseData(List<String> lines);
}
