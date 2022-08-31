package service;

import java.nio.file.Path;

public interface WriterService {
    void write(Path path, String string);
}
