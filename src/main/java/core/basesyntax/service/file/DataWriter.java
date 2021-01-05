package core.basesyntax.service.file;

import java.util.List;

public interface DataWriter {
    void writeToFile(List<String> report, String fileName);
}
