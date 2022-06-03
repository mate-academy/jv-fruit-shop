package csv;

import java.util.List;

public interface FileWriteService {
    void writeFile(String writeFilePath, List<String> writelist);
}
