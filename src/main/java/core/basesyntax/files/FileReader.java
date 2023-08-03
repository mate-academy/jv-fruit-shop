package core.basesyntax.files;

import java.util.List;

public interface FileReader {
    List<String> readFileLines(String fileName);
}
