package core.basesyntax.service.fileoperation;

import java.util.List;

public interface CsvFileReader {
    List<String> inputFile(String filePath);
}
