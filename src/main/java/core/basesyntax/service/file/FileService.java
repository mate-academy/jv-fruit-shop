package core.basesyntax.service.file;

import java.util.List;

public interface FileService {
    List<String> readFile(String data);

    void writeToFile(String data, String file);
}
