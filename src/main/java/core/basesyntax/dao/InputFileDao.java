package core.basesyntax.dao;

import core.basesyntax.model.InputData;

public interface InputFileDao {
    void add(InputData inputData);

    InputData getFromStorage(String inputFileName);
}
