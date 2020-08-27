package core.basesyntax.filewriter;

import core.basesyntax.model.InputDataModel;
import java.util.Map;

public interface FileWriterService {
    void writeFile(Map<InputDataModel, Integer> storage, String filePath);
}
