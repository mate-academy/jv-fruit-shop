package core.basesyntax.services;

import java.util.List;

public interface FileService {
    List<String> dataFromFile(String pathName);

    void writeDataToFile(String data, String file);
}
