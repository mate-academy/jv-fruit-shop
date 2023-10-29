package core.basesyntax.report;

import java.io.IOException;

public interface WriterService {
    void writeToFile(String data, String outputPath) throws IOException;
}
