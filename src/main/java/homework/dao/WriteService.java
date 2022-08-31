package homework.dao;

import java.nio.file.Path;

public interface WriteService {
    void csvWrite(Path path, String string);
}
