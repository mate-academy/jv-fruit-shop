package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.InputData;

public class InputFileDaoImpl implements InputFileDao {
    @Override
    public void add(InputData inputData) {
        Storage.dataList.add(inputData);
    }

    @Override
    public InputData getFromStorage(String inputFileName) {
        return Storage.dataList.stream()
                .filter(inputData -> inputData.getFileName().equals(inputFileName))
                .findFirst()
                .get();
    }
}
