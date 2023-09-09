package core.basesyntax;

import java.io.IOException;

public interface TextFileWriterInterface {
    void writeText(String text, String filePath) throws IOException;
}
