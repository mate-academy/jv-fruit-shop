package core.basesyntax.service.interfaces;

import java.util.List;

public interface FileReader {
    List<String> readAllLinesFromFile(String fileName);
}
