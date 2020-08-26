package core.basesyntax;

import java.io.IOException;
import java.util.List;

public interface StorageUpdater {
    void parseData(String fileName) throws IOException;
}
