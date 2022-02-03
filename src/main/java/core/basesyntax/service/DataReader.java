package core.basesyntax.service;

import java.util.List;

public interface DataReader {
    List<List<String>> getData(String fromFileName);
}
