package core.basesyntax.service;

import java.util.List;

public interface ReaderFromCsv {
    List<String> read(String filePath);
}
