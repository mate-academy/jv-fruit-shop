package core.basesyntax.service.file;

import java.util.List;

public interface FileService {
    List<String> readFile(String inputFile);

    void writeToFile(String outputFile, String data);
}
