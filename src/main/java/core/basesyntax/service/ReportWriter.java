package core.basesyntax.service;

import java.io.File;

public interface ReportWriter {
    void write(String report, File file);
}
