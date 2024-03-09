package core.basesyntax.service;

import java.util.List;

public interface CsvWriterCreateService {
    void createWriteCsv(String pathFile, List<String[]> listArrays);
}
