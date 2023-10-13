package core.basesyntax.workwithfile.filereader;

import java.io.File;
import java.util.List;

public interface CsvFileReader {
    List<String[]> readFromFile(File file);
}
