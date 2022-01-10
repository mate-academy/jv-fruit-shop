package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface FileService {

    List<String> readDataFromFile(File file);

    void writeDataToFile(List<String> data, File file);

    File createNewFile(String fileFullPath);
}
