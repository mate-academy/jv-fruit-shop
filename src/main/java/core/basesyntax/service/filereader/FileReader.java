package core.basesyntax.service.file_readers;

import java.util.List;

public interface FileReader {
    List<String> readAllLinesFromFile(String fileName);
}
