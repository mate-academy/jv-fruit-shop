package core.basesyntax.infrastructure.db;

import java.io.IOException;
import java.util.List;

public interface FileWriter {
    void write(List<String> resultingReport) throws IOException;
}
