package core.basesyntax.fileWriter;

import java.util.HashMap;

public interface FileWriter {
    void writeInFile(HashMap<String, Integer> data, String toFile);
}
