package core.basesyntax.Service.FileWorkWith;

import java.util.List;

public interface CSVFileReaderService {
    List<String[]> readFile(String readFromFilePath);
}
