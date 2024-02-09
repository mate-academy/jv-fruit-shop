package core.basesyntax.service;

import java.util.List;

public interface FruitDao {
    List<String> getInputData(String fileName);

    void sendResultData(String report);
}
