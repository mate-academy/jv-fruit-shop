package core.parser;

import java.util.List;

public interface FileService {
    List<String> readFile(String fullPath);

    boolean writeFile(List<String> text, String path);
}
