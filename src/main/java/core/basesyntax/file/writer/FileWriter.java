package core.basesyntax.file.writer;

import core.basesyntax.model.Fruit;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public interface FileWriter {
    void write(String path, String fileContent);
}
