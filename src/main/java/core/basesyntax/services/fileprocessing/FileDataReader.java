package core.basesyntax.services.fileprocessing;

import java.util.List;

public interface FileReader {
    List<String> readFile(String filename);
}
