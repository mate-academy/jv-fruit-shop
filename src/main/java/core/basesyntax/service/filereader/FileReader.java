package core.basesyntax.service.filereader;

import java.util.List;

public interface FileReader {
    List<String> readAllLinesFromFile(String fileName);
}
