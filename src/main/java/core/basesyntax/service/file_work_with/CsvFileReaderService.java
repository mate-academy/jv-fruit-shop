package core.basesyntax.service.file_work_with;

import java.util.List;

public interface CsvFileReaderService {
    List<String[]> readFile(String readFromFilePath);
}
