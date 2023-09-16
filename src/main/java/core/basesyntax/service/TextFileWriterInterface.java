package core.basesyntax.service;

import java.io.IOException;

public interface TextFileWriterInterface {
    void writeText(String text, String filePath) throws IOException;
}
