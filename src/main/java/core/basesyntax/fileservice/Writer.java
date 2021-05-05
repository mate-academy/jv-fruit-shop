package core.basesyntax.fileservice;

import java.util.List;

public interface Writer {
    void writeToFile(String fileName, List<String> data);
}
