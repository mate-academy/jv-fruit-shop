package core.basesyntax.filewriter;

import java.io.IOException;

public interface FileWriter {
    void write(String content, String fileName) throws IOException;
}
