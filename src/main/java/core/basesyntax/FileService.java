package core.basesyntax;

import java.util.List;

public interface FileService {
    public List<String[]> readFromFile(String filePath);

    public void writeToFile(String filePath);
}
