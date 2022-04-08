package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileService {
    public List<FruitTransaction> getData(String filePath);

    public void writeData(String newFilePath, List<String> records);
}
