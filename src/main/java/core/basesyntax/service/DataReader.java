package core.basesyntax.service;

import java.util.List;

public interface DataReader {
    List<String> readFileLines(String fileName);
}
