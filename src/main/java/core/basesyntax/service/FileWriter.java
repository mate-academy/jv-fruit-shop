package core.basesyntax.service;

import java.io.IOException;

public interface FileWriter {
    void write(String data, String fileName) throws IOException;
}
