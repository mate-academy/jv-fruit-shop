package core.basesyntax.services;

import java.io.File;

public interface ReportWriter {
    void write(String report, File reportFile);
}
