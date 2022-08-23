package core.basesyntax.servce;

import java.util.List;

public interface CsvFileReader {
    String FILE_NAME = "src/main/resources/inputFileExample.csv";

    List<String[]> readCsvFile();
}
