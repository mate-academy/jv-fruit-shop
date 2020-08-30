package core.basesyntax;

import java.io.IOException;
import java.util.List;

public interface StorageUpdater {
    void parseDataToStorage(List<Transaction> newData) throws IOException;
}
