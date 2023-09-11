package core.basesyntax.writer;

import java.io.IOException;

public interface TextFileWriterInterface {
    void writeText(String text, String filePath) throws IOException;
}
