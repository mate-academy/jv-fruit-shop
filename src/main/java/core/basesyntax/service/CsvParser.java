package core.basesyntax.service;

import java.util.List;

public interface CsvParser<T> {
    List<T> parse(List<String> string);
}
