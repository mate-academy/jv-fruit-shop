package fruitshop.service.files;

import java.nio.file.Path;

public interface CsvFileWriterService {
    void writeToFile(Path targetFile, String data);
}
