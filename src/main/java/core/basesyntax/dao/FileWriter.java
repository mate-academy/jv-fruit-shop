package core.basesyntax.dao;

import java.io.IOException;

public interface FileWriter {
    void write(String data, String fileName) throws IOException;
}
