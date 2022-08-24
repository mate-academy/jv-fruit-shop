package core.basesyntax.service;

import java.util.List;

public interface RecordsReader {
    List<String> readFile(String inputFileName);
}
