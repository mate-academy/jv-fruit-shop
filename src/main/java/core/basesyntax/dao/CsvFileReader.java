package core.basesyntax.dao;

import java.util.List;

public interface CsvFileReader {
    List<String> read(String nameOfFile);
}
