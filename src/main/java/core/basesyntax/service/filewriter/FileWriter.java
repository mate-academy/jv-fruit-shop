package core.basesyntax.service.filewriter;

import java.io.IOException;
import java.util.List;

public interface FileWriter {
    void writeToFile(List<String> report, String filePath) throws IOException;
}
