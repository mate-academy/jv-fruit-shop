package solid.service;

import java.nio.file.Path;

public interface FileReadService {
    String readFromFile(Path path);
}
