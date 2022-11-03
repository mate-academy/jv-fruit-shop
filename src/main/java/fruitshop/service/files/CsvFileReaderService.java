package fruitshop.service.files;

import java.nio.file.Path;

public interface CsvFileReaderService {
    String readFromFile(Path csvFilePath);
}
