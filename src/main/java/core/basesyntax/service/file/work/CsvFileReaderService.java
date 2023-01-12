package core.basesyntax.service.file.work;

import java.util.List;

public interface CsvFileReaderService {
    List<String[]> readFile(String readFromFilePath);
}
