package core.basesyntax.service;

import java.io.IOException;

public interface CustomFileWriter {
    void write(String data, String path) throws IOException;
}
