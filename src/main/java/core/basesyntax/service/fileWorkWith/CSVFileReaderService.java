package core.basesyntax.service.fileWorkWith;

import java.util.List;

public interface CSVFileReaderService {
    List<String[]> readFile(String readFromFilePath);
}
