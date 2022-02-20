package core.basesyntax.service.fileservice;

import java.util.List;

public interface FileService {

    List<String> readDataFromFile(String fileName);

    void writeDataToFile(String filename, String data);
}
