package core.basesyntax.services.fileprocessing;

import java.util.List;

public interface FileDataReader {
    List<String> readFromFileAndHoldData(String fromFileName);
}
