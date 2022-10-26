package service.read;

import java.util.List;
import model.FruitTransaction;

public interface ProcessFileContent {
    List<FruitTransaction> processFile(List<String> fileContent);

    int[] getTypesIndexes(String[] columnNames);
}
