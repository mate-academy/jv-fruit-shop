package homework.service;

import java.nio.file.Path;

public interface WriterService {
    void csvWrite(Path path, String string);
}
