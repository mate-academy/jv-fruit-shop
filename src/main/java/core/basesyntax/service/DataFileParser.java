package core.basesyntax.service;

import java.util.List;

public interface DataFileParser<T> {
    List<T> parseDataFile(List<String> data);
}
