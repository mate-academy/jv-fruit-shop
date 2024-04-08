package core.basesyntax.service;

import java.util.List;

public interface CSVReader {
    List<String> read(String filePath);
}
