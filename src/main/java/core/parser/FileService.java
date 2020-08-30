package core.parser;

import java.util.List;

public interface FileService {
    List<String> readFile();

    boolean writeFile(List<String> text, String path);

    void setPath(String path);

    void setFileName(String fileName);

    void setExtension(String extension);

    String getPath();
}
