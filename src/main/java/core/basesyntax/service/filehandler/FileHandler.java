package core.basesyntax.service.filehandler;

import java.util.List;

public interface FileHandler {
    List<String> readFromFile(String fileName);

    void writeToFile(String fileName, String data);
}
