package core.basesyntax.service;

import java.util.List;

public interface CsvParserService<T> {
    List<T> parse(List<String> list);
}
