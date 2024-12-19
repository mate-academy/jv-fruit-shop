package core.basesyntax.file;

import java.io.IOException;

public interface ReportWriter {
    void write(String data, String fileName) throws IOException;
}
