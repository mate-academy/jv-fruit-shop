package core.service;

import java.io.File;
import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(File file);
}
