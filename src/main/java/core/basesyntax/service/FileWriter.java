package core.basesyntax.service;

import java.io.File;

public interface FileWriter {
    void writeReportToFile(String reportText, File toFile);
}
