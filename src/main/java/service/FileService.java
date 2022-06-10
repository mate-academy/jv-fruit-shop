package service;

import java.io.File;
import java.util.List;

public interface FileService {
    List<String[]> read(File file);

    void writeFile(File file, List<String[]> message);
}
