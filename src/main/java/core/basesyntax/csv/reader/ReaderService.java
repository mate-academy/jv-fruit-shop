package core.basesyntax.csv.reader;

import java.util.List;

public interface ReaderService {
    List<String[]> readFromFile(String path);
}
