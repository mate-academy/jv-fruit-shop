package core.basesyntax.service.impl.service;

import java.util.List;

public interface CsvFileReaderService {
    List<String> readData(String fromFile);
}
