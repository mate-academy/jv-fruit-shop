package core.basesyntax.workwithfile;

import java.io.File;
import java.util.List;

public interface WorkWithFile {
    void writeToFile(File file, String report);

    List<String[]> readFromFile(File file);

    String generateReport();
}
