package core.basesyntax.service.impl;

import java.util.List;

public interface CsvReader {
    List<String> read(String pathFile);
}
