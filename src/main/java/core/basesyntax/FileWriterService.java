package core.basesyntax;

import java.util.List;

public interface FileWriterService {
    void writeFile(List<List<String>> conclusionData, String separator, String filename);
}
