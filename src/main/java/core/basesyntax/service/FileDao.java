package core.basesyntax.service;

import java.util.List;

public interface FileDao {
    List<String> getData(String filePath);

    void writeData(String newFilePath, List<String> statistic);
}
