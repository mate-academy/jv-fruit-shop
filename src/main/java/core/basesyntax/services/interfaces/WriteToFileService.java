package core.basesyntax.services.interfaces;

import java.io.File;

public interface WriteToFileService {
    void writeReportToFile(String reportText, File toFile);
}
