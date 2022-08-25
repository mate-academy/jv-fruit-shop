package core.basesyntax.servce;

import java.util.List;

public interface FileReader {

    List<String[]> readCsvFile(String fileName);
}
