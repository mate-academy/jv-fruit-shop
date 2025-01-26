package core.basesyntax.IO;

import java.io.IOException;

public interface FileWriter {
    void write(String content, String filePath) throws IOException;
}
