package service.file;

import java.util.List;

public interface FileWriter {
    void write(List<String> data, String filePath);
}
