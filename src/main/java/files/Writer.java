package files;

import java.nio.file.Path;

public interface Writer {
    void writeIntoFile(Path path, String data);
}
