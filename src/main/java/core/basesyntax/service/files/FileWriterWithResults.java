package core.basesyntax.service.files;

import java.util.List;

public interface FileWriterWithResults {
    void writeResultToFile(String filePath, List<String> outputInfo);
}
