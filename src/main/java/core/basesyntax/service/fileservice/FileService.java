package core.basesyntax.service.fileservice;

import java.util.List;

public interface FileService {
    List<String> readAllLinesFromFile(String fromFile);

    void write(String content, String toFile);
}
