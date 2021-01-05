package core.basesyntax.service;

import java.util.List;

public interface CSVParser<T> {
    List<T> parse(List<String> string);
}
