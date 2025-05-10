package core.basesyntax.filereader;

import java.util.List;

public interface CsvFileReader {
    List<String> read(String fileName);
}
