package files;

import java.nio.file.Path;

public interface Writer {
    void writeIntoFile(String path, String data);
}
