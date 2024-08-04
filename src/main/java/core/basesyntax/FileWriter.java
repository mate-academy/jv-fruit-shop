package core.basesyntax;

import java.io.IOException;

public interface FileWriter {
    void write(String data, String filePath) throws IOException;
}

